package com.leetcode.solution._31_40;

public class Search {
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     * 你可以假设数组中不存在重复的元素。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 示例 1:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     */
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        return searchHelp(nums,0,nums.length-1,target);
    }

    public int searchHelp(int[] nums,int start,int end,int target){
        if(start == end){
            if(nums[start] == target){
                return start;
            }else {
                return -1;
            }
        }
        int mid = (start+end)/2;
        if(nums[start]<nums[mid]){
            int m = start;
            int n = mid;
            if(m == n && nums[m] == target){
                return m;
            }
            while(m<n){
                int tmp = (m+n)/2;
                if(nums[tmp] == target){
                    return tmp;
                }else if(nums[tmp] < target){
                    m = tmp+1;
                }else {
                    n = tmp;
                }
                if(m == n && nums[m] == target){
                    return m;
                }
            }
            return searchHelp(nums,mid+1,end,target);
        }else{
            int m = mid+1;
            int n = end;
            if(m == n && nums[m] == target){
                return m;
            }
            while(m<n){
                int tmp = (m+n)/2;
                if(nums[tmp] == target){
                    return tmp;
                }else if(nums[tmp] < target){
                    m = tmp+1;
                }else {
                    n = tmp;
                }
                if(m == n && nums[m] == target){
                    return m;
                }
            }
            return searchHelp(nums,start,mid,target);
        }
    }

    public int searchHelp2(int[] nums,int start,int end,int target){
        if(start == end){
            if(nums[start] == target){
                return start;
            }else {
                return -1;
            }
        }
        int mid = (start+end)/2;
        if(nums[start]<nums[mid]){
            int m = start;
            int n = mid;
            if(m == n && nums[m] == target){
                return m;
            }
            while(m<=n){
                int tmp = (m+n)/2;
                if(nums[tmp] == target){
                    return tmp;
                }else if(nums[tmp] < target){
                    m = tmp+1;
                }else {
                    n = tmp;
                }
                if(m == n && nums[m] == target){
                    return m;
                }
            }
            return searchHelp2(nums,mid+1,end,target);
        }else{
            int m = mid+1;
            int n = end;
            if(m == n && nums[m] == target){
                return m;
            }
            while(m<=n){
                int tmp = (m+n)/2;
                if(nums[tmp] == target){
                    return tmp;
                }else if(nums[tmp] < target){
                    m = tmp+1;
                }else {
                    n = tmp;
                }
                if(m == n && nums[m] == target){
                    return m;
                }
            }
            return searchHelp2(nums,start,mid,target);
        }
    }
}
