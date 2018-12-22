package com.baseknow.concurrent;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDoc {
    /**
     * unpark 颁发许可
     * park 获取许可，获取不到一直阻塞；
     * @param args
     */

    public static void main(String[] args) {

        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();



        System.out.println("1");
    }
}
