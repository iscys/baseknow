package com.baseknow.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockQueueDoc {

    public static void main(String[] args) throws Exception {


        LinkedBlockingQueue<Integer> blockingQueue =new LinkedBlockingQueue();

        new Thread(()->{
            Integer poll = blockingQueue.poll();
            System.out.println(poll);
        }).start();

       new Thread(()->{
           try {
               blockingQueue.offer(1);
           }catch (Exception e){}
       }).start();
        new Thread(()->{
            Integer poll = blockingQueue.poll();
            System.out.println(poll);
        }).start();


    }

}
