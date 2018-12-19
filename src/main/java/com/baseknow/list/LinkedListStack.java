package com.baseknow.list;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;


public class LinkedListStack {


    public static void main(String[] args) {

        //stack();
       // invocation(31);


    }

    /**
     * push（） poll（）--> ArrayList 进行栈的操作，(后进先出)
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


    /**
     *请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     *单链表
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     *
     *     4 -> 5 -> 1 -> 9
     * 示例 1:
     *
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     */

    public static  void deleteNode(ListNode node) {
        //单链表无法寻找到节点的上一个节点

        ListNode nextNode =node.next;
        node.val=nextNode.val;
        node.next=nextNode.next;
        nextNode.next=null;



    }


    public class ListNode {
      int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }



/**
 *   给定一个链表，判断链表中是否有环。
 *
 *     为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 *     示例 1：
 *
 *     输入：head = [3,2,0,-4], pos = 1
 *     输出：true
 *     解释：链表中有一个环，其尾部连接到第二个节点。
 *
 */

public boolean hasCycle(ListNode head) {

    HashSet<ListNode> set =  new HashSet<>();
    while(head !=null){
        if(set.contains(head)){
            return true;
        }else{
            set.add(head);
            head =head.next;
        }
    }
    return false;

}







    /**
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
    static class MinStack {

        /** initialize your data structure here. */
        //使用两个队列进行数据的存储
        public  LinkedList<Integer>  list;
        public  LinkedList<Integer>  minStack = new LinkedList<>();
        Integer min;
        public MinStack() {
            list = new LinkedList<>();

        }

        public void push(int x) {
            if(min == null){
                min=x;
                minStack.push(x);
            }else{
                if(x<=min){
                    min=x;
                    minStack.push(x);

                } else{
                    minStack.offer(x);
                }
            }
            list.push(x);
        }

        public void pop() {
            int a=list.pop();
            if(a==min){
                minStack.pop();
                min=minStack.peek();
            }
        }

        public int top() {
            return list.peek();
        }

        public int getMin() {

            return min;
        }
    }



}
