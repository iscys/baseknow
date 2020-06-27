package com.baseknow.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class SemaphoreDemo {


    private final static Semaphore GATE =new Semaphore(3);

    private  static ExecutorService exec = Executors.newFixedThreadPool(2);


    public static void main(String[] args)throws Exception {

        for(int i=0;i<3;i++){

          exec.submit(()->{
              try {
                  GATE.acquire();
                  System.out.println("111111");
                  Thread.sleep(900000);

              }
              catch (Exception e){

              }finally {
                  GATE.release();
              }
          });


        }

    }
}
