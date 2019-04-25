package com.leetcode.solution._1_10;

public class IsPalindrome {
    public boolean solution1(int x) {
        if(x<0)
            return false;
        if(x==0)
            return false;
        char[] c = String.valueOf(x).toCharArray();
        int i=0;
        int j = c.length-1;
        while(i<j){
            if(c[i] == c[j]){
                i++;j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
