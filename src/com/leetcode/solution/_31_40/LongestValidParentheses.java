package com.leetcode.solution._31_40;

import java.util.Stack;

public class LongestValidParentheses {
    /**
     * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
     *
     * 示例 1:
     *
     * 输入: "(()"
     * 输出: 2
     * 解释: 最长有效括号子串为 "()"
     * 示例 2:
     *
     * 输入: ")()())"
     * 输出: 4
     * 解释: 最长有效括号子串为 "()()"
     * @param s
     * @return
     */
    //检测断点
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++){
            switch (s.charAt(i)){
                case '(':
                    stack.push(i);
                    break;
                case ')':
                    if(stack.isEmpty())
                        start = i+1;
                    else {
                        stack.pop();
                        if(stack.isEmpty()){
                            max = Integer.max(max,i-start+1);
                        }else {
                            max = Integer.max(max,i-stack.peek());
                        }
                    }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
    }
}
