package com.leetcode.solution._21_30;

public class StrStr {
    //"aabaaabaaac"
    //"aabaaac"
    public static void main(String[] args) {
        int[] a = new StrStr().GetNext("ll");
        System.out.println( new StrStr().StrStr("aabaaabaaac","aabaaac"));
        //System.out.println(new StrStr().strStr("dasdaascababababdsdladkkladsdjadhjcbajsdjabsdjabababca","abababca"));
    }
    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        int i=0;
        int j=0;
        while(i<haystack.length()-1 && j<needle.length()-1){
            if(j == -1||haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                i++;
                j = next[j];
            }
        }
        if(j == needle.length()){
            return j-i+1;
        }
        return -1;
    }

    public int[] getNext(String needle){
        int[] next = new int[needle.length()];
        next[0] = -1;

        int i=0;
        int j=-1;
        while(i<needle.length()-1) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
                next[i] = j;
            }else {
                i++;
                j = next[j];
            }
        }
        return next;
    }

    public int[] GetNext(String needle){
        int[] next = new int[needle.length()];
        next[0] = -1;
        int i=1;
        int j=0;
        while(i<needle.length()){
            if(j == -1||needle.charAt(i) == needle.charAt(j)){
                next[i] = j;
                j++;
                i++;
            }else {
                j = next[j];
            }
        }
        return next;
    }

    public int StrStr(String haystack, String needle){
        if("".equals(needle)){
            return 0;
        }
        int[] next = GetNext(needle);
        int i=0;
        int j=0;
        while(i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                if(j != 0) {
                    j = next[j - 1] + 1;
                }else {
                    i++;
                }
            }
            if(j == needle.length()){
                return i-j;
            }
        }
        return -1;
    }
}
