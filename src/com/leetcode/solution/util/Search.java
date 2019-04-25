package com.leetcode.solution.util;

public class Search {
    //1.Brute force
    public int search1(String haystack, String needle){
        if("".equals(needle)){
            return 0;
        }
        for(int i=0; i<haystack.length(); i++){
            int m = i;
            int n = 0;
            do{
                if(haystack.charAt(m) != needle.charAt(n))
                    break;
                m++;
                n++;
            } while(m<haystack.length() && n<needle.length());
            if(n == needle.length())
                return i;
        }
        return -1;
    }

    public int KMP(String t, String p) {
        int[] next = getNext(p);
        int i = 0;
        int j = 0;

        while (i < t.length() && j < p.length()) {
            if (j == -1 || t.charAt(i) == p.charAt(j))
            {
                i++;
                j++;
            }
            else
                j = next[j];
        }
        if (j == p.length())
            return i - j;
        else
            return -1;
    }

    public int[] getNext(String p){
        int[] next = new int[p.length()];
        next[0] = -1;
        int i=0, j=-1;
        while(i<p.length()){
            if (j == -1 || p.charAt(i) == p.charAt(j))
            {
                ++i;
                ++j;
                next[i] = j;
            }
            else
                j = next[j];
        }
        return next;
    }
}
