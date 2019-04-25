package com.leetcode.solution._11_20;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if((s.length() & 1) != 0)
            return false;
        for(int i=0; i<s.length(); i++){
            switch (s.charAt(i)){
                case '(':
                case '{':
                case '[': stack.push(s.charAt(i));
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                    break;
            }
        }
        if(stack.isEmpty()) {
            return true;
        }else{
            return false;
        }

    }
}
