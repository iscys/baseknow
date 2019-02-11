package com.baseknow.faceTest;

/**
 * 排序链表
 *
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class SortLink {



    public ListNode sortList(ListNode head) {

        merage(head);
        return head;
    }

    private void merage(ListNode head) {
        if(head==null) return;
        ListNode n1 =head.next;
        while(n1!=null){
            if(head.val>n1.val){
                int temp =head.val;
                head.val =n1.val;
                n1.val =temp;

            }
            n1=n1.next;
        }

        merage(head.next);

    }


    public class ListNode {
        int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

}
