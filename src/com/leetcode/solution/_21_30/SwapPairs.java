package com.leetcode.solution._21_30;

public class SwapPairs {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode solution1(ListNode head) {
        ListNode curr = head;
        ListNode next;
        ListNode prev = null;
        while(curr != null &&(next = curr.next) != null){
            if(prev != null) {
                prev.next = curr.next;
            }else{
                head = next;
            }
            curr.next = next.next;
            next.next = curr;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public ListNode solution2(ListNode head){
        if (head == null || head.next == null) return head;

        ListNode temp = head;
        head = head.next;
        temp.next = head.next;
        head.next = temp;

        head.next.next = solution2(head.next.next);
        return head;
    }
}
