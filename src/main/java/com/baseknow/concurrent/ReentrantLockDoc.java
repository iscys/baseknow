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
 * cnnlogs:https://www.cnblogs.com/iscys/p/10152885.html
 */
public class ReentrantLockDoc {

    static ReentrantLock lock =new ReentrantLock();

    public static void main(String[] args) throws Exception {






        Condition isFull = lock.newCondition();
        Condition isEmpty = lock.newCondition();
        //CyclicBarrier
       final CountDownLatch count =new CountDownLatch(4);
        count.countDown();
        count.countDown();
        count.countDown();




        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    count.await();
                    System.out.println("ss");
                }catch(Exception e){}

            }
        }).start();


        count.countDown();

        System.out.println("ff");

    }
}
