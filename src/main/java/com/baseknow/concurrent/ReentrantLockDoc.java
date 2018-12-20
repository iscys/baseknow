package com.baseknow.concurrent;


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
 */
public class ReentrantLockDoc {

    static ReentrantLock lock =new ReentrantLock();

    public static void main(String[] args) throws Exception {


        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("1111");
                lock.unlock();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("2222");

            }
        }).start();





        Condition isFull = lock.newCondition();
        Condition isEmpty = lock.newCondition();
        //CyclicBarrier
        CountDownLatch count =new CountDownLatch(4);
        count.countDown();
        count.countDown();
        count.countDown();
        count.countDown();
        count.await();
        System.out.println("ss");

    }
}
