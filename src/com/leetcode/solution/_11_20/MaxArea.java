package com.leetcode.solution._11_20;

public class MaxArea {
    public int solution1(int[] height) {
        int max = -1;
        int i=0; int j=height.length-1;
        while (i<j){
            if(height[i]<=height[j]){
                max = Integer.max(height[i]*(j-i),max);
                i++;
            }else {
                max = Integer.max(height[j]*(j-i),max);
                j--;
            }
        }

        return max;
    }
}
