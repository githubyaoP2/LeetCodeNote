package com.leetcode.solution._41_50;

public class Trap {
    /**
     * while (start < end) {
     *             if (height[start] < height[end]) {
     *                 if (height[start] <leftMax) {
     *                     totalArea += leftMax - height[start];//计算差值
     *                 }else {
     *                     leftMax=height[start];//更新最大值
     *                 }
     *                 start++;
     *             } else {
     *                 if (height[end] < rightMax) {
     *                     totalArea += rightMax-height[end];
     *                 }else {
     *                     rightMax=height[end];
     *                 }
     *                 end--;
     *             }
     *         }
     *         return totalArea;
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int totalArea = 0;
        int leftMax = 0;
        int rightMax = 0;
        int start = 0;
        int end = height.length-1;
        while(start<end){
            if (height[start] < height[end]) {
                if (height[start] <leftMax) {
                  totalArea += leftMax - height[start];//计算差值
                }else {
                  leftMax=height[start];//更新最大值
                }
                start++;
            } else {
                if (height[end] < rightMax) {
                  totalArea += rightMax-height[end];
                }else {
                  rightMax=height[end];
                }
                end--;
            }
        }
        return totalArea;
    }

    public static void main(String[] args) {
        int[] y = {0,1,0,2,1,0,1,3,2,1,2,1};
        new Trap().trap(y);
    }
}
