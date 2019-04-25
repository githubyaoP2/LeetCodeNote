package com.leetcode.solution._1_10;

import java.util.*;

public class LengthOfLongestSubstring {
    public int solution1(String s) {
        char[] c = s.toCharArray();
        int max = 0;
        int index = 0;
        Map<Character,Integer> map = new HashMap<>();
        int i;
        for(i=0; i<c.length; i++){
            if(map.containsKey(c[i])){
                max = Integer.max(max,i-index);
                index = Integer.max(map.get(c[i])+1,index);
            }
            map.put(c[i],i);
        }
        max = Integer.max(max,c.length-index);
        return max;
    }

    //用数组替代map
    public int solution2(String s) {
        int ans = 0;
        int[] vis = new int[257];
        int len = s.length();
        int left = -1;
        Arrays.fill(vis,-1);
        for(int i = 0; i < len; i++) {
            if(vis[s.charAt(i)] > left) {
                left = vis[s.charAt(i)];
            }
            ans = Math.max(ans,i - left);
            vis[s.charAt(i)] = i;
        }

        return ans;
    }
}
