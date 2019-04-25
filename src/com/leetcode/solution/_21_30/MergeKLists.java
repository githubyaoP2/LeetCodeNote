package com.leetcode.solution._21_30;

public class MergeKLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode m = l1;
        ListNode n = l2;
        ListNode curr = new ListNode(0);
        ListNode head = curr;
        while(m!=null || n!= null){
            if(m == null){
                curr.next = n;
                break;
            }else if(n == null){
                curr.next = m;
                break;
            }else {
                if(m.val <= n.val){
                    //addLast
                    curr.next = m;
                    curr = curr.next;
                    m = m.next;
                }else {
                    curr.next = n;
                    curr = curr.next;
                    n = n.next;
                }
            }

        }
        return head.next;
    }

    public ListNode merge(ListNode[] lists,int lo,int hi) {
        if(lo == hi)
            return lists[lo];
        int mid = (lo+hi)/2;
        return merge(merge(lists,lo,mid),merge(lists,mid+1,hi));

    }

    //90.54%
    public ListNode solution1(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }
}
