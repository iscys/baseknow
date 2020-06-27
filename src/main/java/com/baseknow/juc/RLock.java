package com.baseknow.juc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RLock {

    public static void main(String[] args)throws Exception {
        ReentrantLock lock =new ReentrantLock();
         Condition condition = lock.newCondition();
        lock.lock();

        new Thread(()->{
            lock.lock();
            System.out.println("1111");
            lock.unlock();
        }).start();

        new Thread(()->{
            lock.lock();
            System.out.println("1111");
            condition.signal();
            lock.unlock();
        }).start();

        condition.await();
        lock.unlock();




        CountDownLatch latch = new CountDownLatch(1);
        new Thread(()->{
            try {
                final boolean await = latch.await(1115000, TimeUnit.MILLISECONDS);
                System.out.println(await);
            }catch (Exception e){

            }
        }).start();
        new Thread(()->{
            try {
                final boolean await = latch.await(1115000, TimeUnit.MILLISECONDS);
                System.out.println(await);
            }catch (Exception e){

            }
        }).start();
        Thread.sleep(100);
        latch.countDown();


        ConcurrentHashMap map =new ConcurrentHashMap();

    }
}
