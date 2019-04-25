package com.leetcode.solution._11_20;

public class RemoveNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode solution1(ListNode head, int n) {
        if(n<=0) return null;
        ListNode tail = head;
        while(n-- >0 ){
            if(tail == null)
                return null;
            tail = tail.next;

        }
        ListNode prev = head;
        ListNode curr = head;
        if(tail == null){
            return head.next;
        }
        while(tail!=null){
            prev = curr;
            curr = curr.next;
            tail = tail.next;
        }
        prev.next = curr.next;
        return head;
    }


















    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n <= 0 || head == null) return null;
        if(head.next == null && n >= 1) return null;
        ListNode tail = head;
        while(n-- >1){
            tail = tail.next;
            if(tail == null){
                return null;
            }
        }

        ListNode prev = head;
        ListNode node = head;
        while(tail.next != null){
            prev = node;
            node = node.next;
            tail = tail.next;
        }

        if(node == head){
            head = head.next;
        }else {
            prev.next = node.next;
        }
        return head;
    }

}

