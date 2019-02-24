package com.baseknow.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exc {

    public static void main(String[] args) throws Exception {

        ExecutorService exe = Executors.newFixedThreadPool(3);

       Future<String> t = exe.submit(() -> {
           return "1";
       });
       System.out.println(t.get());
    }
}
