package com.leetcode.solution._31_40;

public class SearchRange {

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 如果数组中不存在目标值，返回 [-1, -1]。
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     */

    int start = -1;
    int end = -1;

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1,-1};
        else if(nums.length == 1){
            if(nums[0] != target)
                return new int[]{-1,-1};
            else
                return new int[]{0,0};
        }
        searchHelp(nums,0,nums.length-1,target);
        return new int[]{start,end};
    }

    public void searchHelp(int[] nums,int left,int right,int target){
        if(left>right) return;
        int mid = (left+right)/2;
        if(mid == left){
            if(nums[left] == target){
                if(start == -1 || left<start){
                    start = left;
                }
                if(end == -1 || left>end){
                    end = left;
                }
            }
            if(nums[right] == target){
                if(start == -1 || right<start){
                    start = right;
                }
                if(end == -1 || right>end){
                    end = right;
                }
            }
        }else if(nums[mid] == target){
            if(start == -1 || mid<start){
                start = mid;
            }
            if(end == -1 || mid>end){
                end = mid;
            }
            searchHelp(nums,left,mid-1,target);
            searchHelp(nums,mid+1,right,target);
        }else if(nums[mid] < target){
            searchHelp(nums,mid+1,right,target);
        }else if(nums[mid] > target){
            searchHelp(nums,left,mid-1,target);
        }
    }

    public static void main(String[] args) {
//        int[] a = {5,7,7,8,8,10};
//        int[] b = new SearchRange().searchRange(a,6);
        int[] a = {1,3};
        int[] b = new SearchRange().searchRange(a,1);
        System.out.println();
    }
}
