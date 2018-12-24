package com.baseknow.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockQueueDoc {

    public static void main(String[] args) throws Exception {

        LinkedBlockingQueue<Integer> blockingQueue =new LinkedBlockingQueue();
        blockingQueue.offer(1);
        Integer take = blockingQueue.take();
        System.out.println(take);
    }

}
