package com.baseknow.list;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


public class LinkedListStack {


    public static void main(String[] args) {

        //stack();
       // invocation(31);


    }

    /**
     * push（） poll（）--> ArrayList 进行栈的操作，
     * peek() 获取顶端元素；
     *
     * 先进后出的原则
     * Stack 不推荐使用，因为它继承了vector已经是过时的方法了
     * 在HEAD 部位进行链表的操作
     */
    private static void stack() {

        LinkedList<String> list =new LinkedList<String>();
        list.push("2");//onto stack linkedFirst
        list.push("3");//onto stack linkedFirst
        System.out.println(list.peek());

        String res = list.poll();
        System.out.println(res);
        System.out.println(list.size());



    }

    /**
     * 利用栈进行十进制转二进制
     * 先进后出
     * push()-头放入元素
     * poll()-头取元素
     */
    public static  Deque<Integer> invocation (int param){
        Deque<Integer> queue =new LinkedList<>();
        Integer p =param;
        while(p!=0){
            queue.push(p%2);
            p =p/2;
        }
        Integer h;
        while((h=queue.poll())!=null){
            System.out.println(h);
        }
     return queue;

    }


}
