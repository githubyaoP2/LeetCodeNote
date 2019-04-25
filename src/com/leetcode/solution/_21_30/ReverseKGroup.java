package com.leetcode.solution._21_30;

/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReverseKGroup {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    //74.07%
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode node = new ListNode(0);//源节点
        node.next = head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode conn = new ListNode(0);
        boolean flag = true;
        while(curr!=null){
            int i=1;
            while(curr != null && ++i <= k){
                prev.next = curr.next;
                curr.next = newHead.next;
                newHead.next = curr;
                curr = prev.next;
            }
            if(curr == null &&i == k){
                if(flag){
                    node.next = newHead.next;
                    flag = false;
                }
                conn.next = newHead.next;
            }else if(i == k+1 ){
                if(flag){
                    node.next = newHead.next;
                    flag = false;
                }
                conn.next = newHead.next;
                newHead.next = curr;
                conn = prev;

               // prev.next = curr;
//                prev.next = newHead.next;
                prev = prev.next;
                curr = curr.next;
            }else {
                prev = newHead.next;
                curr = prev.next;
                while(i-->1){
                    prev.next = curr.next;
                    curr.next = newHead.next;
                    newHead.next = curr;
                    curr = prev.next;
                }
            }
        }
        return node.next;
    }

    public ListNode reverse(ListNode head){
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode prev = head;
        ListNode curr = prev.next;
        int i = 1;
        while(curr != null){
            prev.next = curr.next;
            curr.next = node.next;
            node.next = curr;
            curr = prev.next;
        }
        return node.next;
    }

    public ListNode reverse2(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode l = reverseKGroup.generate();
        l = reverseKGroup.reverse2(l);
        //l = reverseKGroup.reverseKGroup(l,3);
        //l = reverseKGroup.solution2(l,3);
        System.out.println();
    }

    public ListNode generate(){
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ListNode ln7 = new ListNode(7);
        ListNode ln8 = new ListNode(8);
        ListNode ln9 = new ListNode(9);
        ListNode ln10 = new ListNode(10);
        ListNode ln11 = new ListNode(11);
        ListNode ln12 = new ListNode(12);
        ListNode ln13 = new ListNode(13);
        ListNode ln14 = new ListNode(14);
        ListNode ln15 = new ListNode(15);
        ListNode ln16 = new ListNode(16);
        ListNode ln17 = new ListNode(17);
        ListNode ln18 = new ListNode(18);
        ListNode ln19 = new ListNode(19);
        ListNode ln20 = new ListNode(20);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = ln9;
        ln9.next = ln10;
        ln10.next = ln11;
        ln11.next = ln12;
        ln12.next = ln13;
        ln13.next = ln14;
        ln14.next = ln15;
        ln15.next = ln16;
        ln16.next = ln17;
        ln17.next = ln18;
        ln18.next = ln19;
        ln19.next = ln20;
        return ln1;
    }

    public ListNode solution2(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check =head;
        int canProceed = 0;
        int count = 0;

        while(canProceed<k && check != null){
            check=check.next;
            canProceed++;
        }

        if(canProceed==k){
            while(count<k && cur != null){
                next = cur.next;
                cur.next=prev;
                prev=cur;
                cur=next;
                count++;
            }
            if(next!=null){
                head.next=solution2(next,k);
            }
            return prev;
        } else {
            return head;
        }
    }
}
