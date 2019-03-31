package com.baseknow.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProductAndCustomer {

    final ReentrantLock lock =new ReentrantLock();
    final Condition notFull =lock.newCondition();
    final Condition notEmpty =lock.newCondition();

    volatile  static int count;

    public static void main(String[] args) {
       ProductAndCustomer pc =new ProductAndCustomer();

        ExecutorService es = Executors.newFixedThreadPool(3);
       es.submit(new Runnable() {
           @Override
           public void run() {
               while(true)
               pc.put();
           }
       });

       es.submit(()->{
            while(true)
                pc.take();
       });



    }



    public  void put(){

        lock.lock();
        try{
            while(count==1){
                notEmpty.await();
            }
            ++count;
            Thread.sleep(1000);
            System.out.println(count);
            notFull.signal();

        }catch (Exception e){

        }
        finally {
            lock.unlock();
        }
    }

    public void take(){

        lock.lock();
        try{
            while(count==0){
                notFull.await();
            }
            --count;
            Thread.sleep(1000);
            System.out.println(count);
            notEmpty.signal();

        }catch (Exception e){

        }
        finally {
            lock.unlock();
        }
    }
}
