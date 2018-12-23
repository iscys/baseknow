package com.baseknow.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDoc {

    public static void main(String[] args) {

        ReentrantLock lock =new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    Thread.sleep(1000);
                    System.out.println("1 obtain lock");
                    condition.await();
                    System.out.println(" 1 thread access");

                }catch (Exception e){}finally {
                    lock.unlock();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    Thread.sleep(1200);
                    System.out.println("3 obtain lock");
                    System.out.println(" 3 thread access");

                }catch (Exception e){}finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{

                    System.out.println("2 obtain lock");
                    Thread.sleep(1000);
                    condition.signal();
                    System.out.println(" 2 thread access");

                }catch (Exception e){}finally {
                    lock.unlock();
                }
            }
        }).start();





    }
}
