package com.leetcode.solution._1_10;

public class AddTwoNumbers {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
    }

    //占用内存过大，待优化，考虑不new，每次把值累计到其中一个原始节点上
    public ListNode solution1(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode sum = new ListNode(0);
        ListNode tail = sum;
        int flag = 0;
        while(n1!=null || n2!=null || flag!=0){
            int value;
            if(n1 == null && n2 != null){
                value = n2.val+flag;
                n2 = n2.next;
            }else if(n2 == null && n1!= null){
                value = n1.val+flag;
                n1 = n1.next;
            }else if(n1==null && n2==null){
                value = flag;
            }else{
                value = n1.val + n2.val + flag;
                n1 = n1.next;
                n2 = n2.next;
            }
            if (value >= 10) {
                value = value - 10;
                flag = 1;
            } else {
                flag = 0;
            }
            tail.next = new ListNode(value);
            tail = tail.next;
        }
        return sum.next;
    }

    public ListNode solution2(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode tail = l1;
        int flag = 0;
        while(n1!=null || n2!=null || flag!=0){
            int value;
            if(n1 == null && n2 != null){
                value = n2.val+flag;
                n2 = n2.next;
            }else if(n2 == null && n1!= null){
                value = n1.val+flag;
                n1 = n1.next;
            }else if(n1==null && n2==null){
                value = flag;
            }else{
                value = n1.val + n2.val + flag;
                n1 = n1.next;
                n2 = n2.next;
            }
            if (value >= 10) {
                value = value - 10;
                flag = 1;
            } else {
                flag = 0;
            }
            tail.val = value;
            if(n1 == null && (n2!=null || flag==1)){
                tail.next = new ListNode(0);
            }
            tail = tail.next;
        }
        return l1;
    }
}
