package com.baseknow.faceTest;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Swap2SwapPlus {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        //记录一个有多少节点，并且将链表变成为一个环形链表，首尾相连
        if(head==null) return null;
        ListNode pre =head;
        ListNode tail =null;
        int size=0;
        while(pre !=null){
            size++;
            if(pre.next==null){
                tail =pre;
            }
            pre =pre.next;
        }
        tail.next=head;//首尾相连
        int res =k%size;
        for(int i=0;i<size-res;i++){
            tail =tail.next;

        }
        pre =tail.next;
        tail.next=null;

        return pre;

    }


}