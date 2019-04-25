package com.leetcode.solution._1_10;

public class LongestPalindrome {
    public String solution1(String s){
        if("".equals(s)){
            return "";
        }
        char[] c = s.toCharArray();
        int max = 1;
        String sub = String.valueOf(c[0]);
        for(int i=1; i<c.length-1; i++){
            int k=1;
            int m = i-k;
            int n = i+k;
            while(m>=0 && n<c.length){
                if(c[m--] == c[n++])
                    k++;
                else
                    break;
            }
            if(2*k-1>max){
                max = 2*k-1;
                sub = new String(c,i-k+1,2*k-1);
            }
        }

        for(int i=0; i<c.length-1; i++){
            int k=1;
            int m = i;
            int n = i+k;
            while(m>=0 && n<c.length){
                if(c[m--] == c[n++])
                    k++;
                else
                    break;
            }
            if(2*k-2>max){
                max = 2*k-2;
                sub = new String(c,i+2-k,2*k-2);
            }
        }
        return sub;
    }

}
