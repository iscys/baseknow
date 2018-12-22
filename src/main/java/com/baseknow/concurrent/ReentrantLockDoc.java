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



        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lock.lock();
                    System.out.println("ss");
                    Thread.sleep(2000);

                    lock.unlock();
                    System.out.println("unlockok");

                }catch(Exception e){}

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                    lock.lock();
                    System.out.println("last");
                    lock.unlock();
                }catch(Exception e){}

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1800);
                    lock.lock();
                    System.out.println("ss1");


                }catch(Exception e){}

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1800);
                    lock.lock();
                    System.out.println("ss2");
                    lock.unlock();
                }catch(Exception e){}

            }
        }).start();




        Condition isFull = lock.newCondition();
        Condition isEmpty = lock.newCondition();
        //CyclicBarrier
       final CountDownLatch count =new CountDownLatch(4);
        count.countDown();
        count.countDown();
        count.countDown();






        count.countDown();

       // System.out.println("ff");

    }
}
