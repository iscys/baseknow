package com.baseknow.concurrent;

import com.baseknow.Wrap.WarpAndWrap;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WaitSingal {

    private ReentrantLock lock =new ReentrantLock();
    private Condition done =lock.newCondition();


    public static void main(String[] args)throws Exception {
       final WaitSingal w =new WaitSingal();

        new Thread(()->{
            try {
                w.await();
            }catch (Exception e){}
        }).start();
        new Thread(()->{
            try {
                w.signal();
            }catch (Exception e){System.out.println("Exception");}
        }).start();


    }

    public void await() throws Exception{
        lock.lock();
        try{
            done.await();
            System.out.println("123");

        }finally {
            lock.unlock();
        }
    }

    public void signal() throws Exception{
        lock.lock();
        try{
            done.signal();

        }finally {
            lock.unlock();
        }
    }

}
