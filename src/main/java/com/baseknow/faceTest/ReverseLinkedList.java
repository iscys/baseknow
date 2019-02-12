package com.baseknow.faceTest;

/**
 * 反转单链表
 * leetcode 206
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public ListNode reverseList(ListNode head) {

        ListNode pre =null;
        ListNode current =head;
        while(current!=null){
            ListNode next =current.next;
            current.next=pre;
            pre =current;
            current =next;
        }
        return pre;
    }




    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}