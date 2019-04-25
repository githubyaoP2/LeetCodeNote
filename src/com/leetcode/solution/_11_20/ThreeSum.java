package com.leetcode.solution._11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> solution1(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int m = i+1;
            int n = nums.length-1;
            while(m<n){
                while(m<n && m>i+1 && nums[m] == nums[m-1]){
                    m++;
                }
                while(m<n && n<nums.length-1 && nums[n] == nums[n+1]){
                    n--;
                }
                if(m<n) {
                    if (nums[i] + nums[m] + nums[n] < 0) {
                        m++;
                    } else if (nums[i] + nums[m] + nums[n] > 0) {
                        n--;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[m], nums[n]));
                        m++;
                        n--;
                    }
                }
            }
        }
        return list;
    }
}
