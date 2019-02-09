package com.baseknow.faceTest;

import java.util.LinkedList;

/**
 * leetcode 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack {
    /**
     * 采用两个栈进行存储
     */
    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;

    public MinStack() {
         stack =new LinkedList<Integer>();
         minStack=new LinkedList<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }
        else{
            if(x<=minStack.peek())
                minStack.push(x);
        }
    }

    public void pop() {
        Integer pop=stack.pop();
        if(pop.equals(minStack.peek()))
        {
            minStack.pop();
        }
    }

    public int top() {
       return  stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack m =new MinStack();
        m.push(512);
        m.push(-1024);
        m.push(-1024);
        m.push(512);
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
    }

}
