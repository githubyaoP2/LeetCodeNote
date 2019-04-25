package com.leetcode.solution._31_40;

public class SearchInsert {

    /**
     *
     示例 1:

     输入: [1,3,5,6], 5
     输出: 2
     示例 2:

     输入: [1,3,5,6], 2
     输出: 1
     示例 3:

     输入: [1,3,5,6], 7
     输出: 4
     */

    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(new SearchInsert().searchInsert(nums,3));
    }
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        if(nums.length == 1){
            if(target<=nums[0])
                return 0;
            else
                return 1;
        }
        int m = 0;
        int n = nums.length-1;
        while(m<n){
            int mid = (m+n)/2;
            if(mid == m){
                if(target <= nums[m]){
                    return m;
                }else if(target > nums[n]){
                    return n+1;
                }else {
                    return n;
                }
            }
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                n = mid;
            }else {
                m = mid;
            }
        }
        return 1;
    }
}
