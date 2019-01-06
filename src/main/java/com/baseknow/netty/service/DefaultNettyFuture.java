package com.baseknow.netty.service;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DefaultNettyFuture {

    public static  ConcurrentHashMap<Long,DefaultNettyFuture> FUTURES = new ConcurrentHashMap<>();
    public static  AtomicLong ATOLONG = new AtomicLong();
    private volatile Object response;
    private int timeout;
    private ReentrantLock lock =new ReentrantLock();
    private Condition done =lock.newCondition();
    private volatile Long id;

    /**
     * 设置默认future
     */
    public DefaultNettyFuture(Channel channel, int timeout){
        this.timeout = timeout<0?0:timeout;
        this.id = ATOLONG.incrementAndGet();
        FUTURES.put(id,this);
    }

    /**
     * 设置需要返回的参数
     * @param res
     */
    public static void setResponse(Object res){
        ResultResponse resp = (ResultResponse) res;
        DefaultNettyFuture future = FUTURES.remove(resp.getId());
        if(future==null){
            System.out.println("异常信息");
        }
        future.doResponse(resp.getResult());
    }


    private  void doResponse(Object result) {

        lock.lock();
        try {
            response = result;
            if (done != null) {
                done.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * 得到返回的参数，该方法是阻塞的在没有获得response的时候
     */

    public  Object get(){
       return  get(timeout);

    }
    public Object get(int timeout)  {

        if (! isDone()) {
            long start = System.currentTimeMillis();
            lock.lock();
            try {
                while (! isDone()) {
                    done.await(timeout, TimeUnit.MILLISECONDS);
                    if (isDone() || System.currentTimeMillis() - start > timeout) {
                        break;
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
            if (! isDone()) {
                System.out.println("timeout");
            }
        }
        return response;
    }

    /**
     * 是否有返回的结果
     * @return
     */
    public boolean isDone() {
        return response != null;
    }

    /**
     * 返回当前future的ID
     */
    public long getId(){
        return id;
    }

}
