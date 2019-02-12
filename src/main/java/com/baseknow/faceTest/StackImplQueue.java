package com.baseknow.faceTest;

import com.sun.tools.internal.ws.wsdl.document.Output;

import java.util.Stack;

/**
 * 栈实现队列
 * 实现思路：
 * 采用两个栈进行操作，一个栈进行存放，一个栈进行取出；
 * leetcode 232
 * 1->2->3
 *
 * |       |
 * |    3  |
 * |    2  |  -> input----------\
 * |    1  |                    |
 * |_______|                    |
 *                              |
 * |       |                    |
 * |    1  |                    |
 * |    2  |  -> output----------
 * |    3  |
 * |_______|
 */
public class StackImplQueue {

    public static void main(String[] args) {
        StackImplQueue queue =new StackImplQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
    Stack<Integer> input;
    Stack<Integer> out;

    /** Initialize your data structure here. */
    public StackImplQueue() {
            input =new Stack<>();
            out =new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        check();
        if(out.isEmpty()) return 0;
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        check();
        if(out.isEmpty()) return 0;
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        check();
        return out.isEmpty();
    }


   public void check(){
       if(out.isEmpty()&& !input.isEmpty()){
           while(!input.isEmpty()){
               out.push(input.pop());
           }
       }
   }




}
