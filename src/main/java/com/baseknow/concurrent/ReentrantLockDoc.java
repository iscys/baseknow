package com.baseknow.concurrent;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
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

    public static void main(String[] args) throws Exception {
        ReentrantLock lock =new ReentrantLock();
        Condition isFull = lock.newCondition();
        Condition isEmpty = lock.newCondition();
        //CyclicBarrier
        CountDownLatch count =new CountDownLatch(4);
        count.countDown();
        count.countDown();
        count.countDown();

        count.await();
        System.out.println("ss");
    }
}
