package com.baseknow.concurrent;


import org.omg.CosNaming.NamingContextPackage.NotEmpty;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock 代替synchrinized 锁
 *
 * try{
 *     lock.lock();
 * }
 * finally{
 *     lock.unlock();
 * }
 *
 * condition 代替 原始的wait(). notify().notifyAll();
 * cnnlogs:https://www.cnblogs.com/iscys/p/10152885.html
 *
 * 在线程未unpack 且 tryAcquire() 不等于1 的时候 lock.lock 一直处于阻塞状态
 * 这样就保证了线程的安全性；
 *
 *
 * unlock会将state 致为0  且将队列的下一个线程unpack ，这样下一个线程就可以
 * tryAcquire() 拿到执行权 1  ,lock 方法将不在堵塞；
 */
public class ReentrantLockDoc {

    static ReentrantLock lock =new ReentrantLock();
    volatile static int count;

    public static void main(String[] args) throws Exception {

        Condition isFull = lock.newCondition();
        Condition isEmpty = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    while(true){
                        while(count==0){
                            isEmpty.await();
                        }
                        --count;
                        System.out.println(Thread.currentThread().getName()+"-->"+count);
                        isFull.signal();
                    }
                }
                catch(Exception e){}
                finally {
                    lock.unlock();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    while(true){
                        while(count==0){
                            isEmpty.await();
                        }
                        --count;
                        System.out.println(Thread.currentThread().getName()+"-->"+count);
                        isFull.signal();
                    }
                }
                catch(Exception e){}
                finally {
                    lock.unlock();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    while(true){

                        while(count==1){
                            isFull.await();
                        }
                        ++count;
                        System.out.println(Thread.currentThread().getName()+"-->"+count);
                        isEmpty.signal();
                    }
                }
                catch(Exception e){}
                finally {
                    lock.unlock();
                }

            }
        }).start();


        //CyclicBarrier
       final CountDownLatch count =new CountDownLatch(4);
        count.countDown();
        count.countDown();
        count.countDown();






        count.countDown();

       // System.out.println("ff");

    }
}
