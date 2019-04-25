package com.leetcode.solution._31_40;

import java.util.Arrays;

public class NextPermutation {
    /**
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     *
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     *
     * 必须原地修改，只允许使用额外常数空间。
     *
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     * @param nums
     */
    //从右到左扫描当前排列，寻找第一对连续元素a(i)和a(i+1),并且a(i)<a(i+1)(同时,a(i+1)>...>a(n)).然后在尾部寻找大于a(i)的最小元素，放到i上，从i+1到n增序填充，
    public void nextPermutation(int[] nums) {
        if(nums.length == 0) return;
        for(int i=nums.length-1; i>=0; i--){
            if(i>0){
                if(nums[i-1]<nums[i]){
                    int min = i;
                    for(int j=i; j<nums.length; j++){
                        if(nums[j] > nums[i-1] && nums[j] < nums[min]){
                            min = j;
                        }
                    }
                    int tmp = nums[min];
                    nums[min] = nums[i-1];
                    nums[i-1] = tmp;
                    Arrays.sort(nums,i,nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        new NextPermutation().nextPermutation(a);
        System.out.println();
    }
}
