package com.leetcode.solution._1_10;

import com.leetcode.solution.util.Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    //暴力法
    public int[] solution1(int[] nums,int target){
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    //先排序
    public int[] solution2(int[] sum,int target){
        Arrays.sort(sum);
        int i=0;
        int j=sum.length-1;
        while(i<j){
            if(sum[i]+sum[j]<=target){
                if(sum[i]+sum[j] == target){
                    return new int[]{i,j};
                }else
                    i++;
            }else
                j--;
        }
        return null;
    }

    //用额外空间哈希
    public int[] solution3(int[] sum,int target) {
        Map<Integer,Integer> m = new HashMap();
        for(int i=0; i<sum.length; i++){
            if(m.containsKey(sum[i])){
                return new int[]{m.get(sum[i]),i};
            }else{
                m.put(target-sum[i],i);
            }
        }
        return null;
    }
}
