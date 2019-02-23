package com.baseknow.faceTest;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Swap2Swap {


    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        ListNode pre =new ListNode(0);
        ListNode now =pre;
        ListNode current =head;
        while(current!=null){
            if(current.next==null){
                pre.next =current;
                pre =current;
                break;
            }
            ListNode next2 = current.next.next;//保存下下一个节点的指针,下次循环进行交换
            ListNode next = current.next;
            current.next =null;
            next.next=current;
            pre.next =next;
            pre =current;
            current =next2;
        }
    return now.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

}
