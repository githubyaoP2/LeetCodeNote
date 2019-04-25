package com.leetcode.solution._41_50;

import java.util.Set;

public class FirstMissingPositive {

    /**
     * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
     *
     * 示例 1:
     *
     * 输入: [1,2,0]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [3,4,-1,1]
     * 输出: 2
     * 示例 3:
     *
     * 输入: [7,8,9,11,12]
     * 输出: 1
     * 说明:
     *
     * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
     */
    public int firstMissingPositive(int[] nums) {

        for(int i=0; i<nums.length; i++){
            while(nums[i]<=nums.length && nums[i]>0 && nums[i] != i+1){
                int tmp = nums[nums[i]-1];
                if(tmp == nums[i])
                    break;
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        int[] i = {1,1};
        new FirstMissingPositive().firstMissingPositive(i);
    }
}
