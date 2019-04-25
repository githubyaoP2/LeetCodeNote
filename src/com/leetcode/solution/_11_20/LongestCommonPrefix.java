package com.leetcode.solution._11_20;

public class LongestCommonPrefix {
    public String solution1(String[] strs) {
        if(strs.length == 0) return "";
        for(int i=0; i<strs[0].length(); i++){
            for(int j=1; j<strs.length; j++){
                if(strs[j].length() == i || strs[j].charAt(i) != strs[0].charAt(i))
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }

    //先拿出长度最小的字符串
    public String solution2(String[] strs) {
        if(strs.length == 0) return "";
        char[] c=strs[0].toCharArray();
        int min = strs[0].length();
        for(String s:strs){
            if(min>s.length()) {
                min = s.length();
            }
        }
        int j;
        for(j=0; j<min; j++) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(j) != c[j])
                    return new String(c,0,j);
            }
        }
        return new String(c,0,min);
    }
}
