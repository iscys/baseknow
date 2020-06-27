package com.baseknow.concurrent;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPool {



    private  volatile  int goods;

    private ReentrantLock putLock =new ReentrantLock();
    private Condition notFull =putLock.newCondition();
    private Condition notEmpty =putLock.newCondition();


      public void put() {
            try {
                putLock.lock();

                while(goods==1){
                    notFull.await();
                }
                goods=1;
                System.out.println("put---"+goods);
                notEmpty.signal();
            }catch (Exception e){


            }finally {
                putLock.unlock();
            }


      }


    public void take() {
        try {

            putLock.lock();
            Thread.sleep(1000);
            while(goods==0){
                notEmpty.await();
            }
            goods=0;
            System.out.println("take---"+goods);
            notFull.signal();
        }catch (Exception e){


        }finally {
            putLock.unlock();
        }


    }





    public static void main(String[] args) throws Exception {

        ArrayBlockingQueue<String> queue =new ArrayBlockingQueue<String>(3);

        /**
         * 核心线程为2
         * 最大线程为6
         * LinkedBlockingQueue 容纳 Integer.MAX_VALUE个任务
         */

        /**
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 6,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());


        pool.submit(()-> fs());
        pool.submit(()-> fs());
        pool.submit(()-> fs());
        pool.submit(()->fs());
        pool.submit(()->fs());
        pool.submit(()->fs());
        pool.submit(()->fs());
        pool.submit(()->fs());

**/

        HashMap<String,String>  map =new HashMap<>();
        map.put("1","2");
        for(Map.Entry<String,String> en :map.entrySet()){

        }
        /*(
        ThreadPool pool=new ThreadPool();


        new Thread(()->
        {
            while(true)

            pool.put();
        }).start();

        new Thread(()->{
            while(true)
                pool.take();
        }).start();






    }

    public static void fs(){
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        }catch (Exception E){

        }

**/
    }
}
