package com.leetcode.solution._31_40;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以无限制重复被选取。
     *
     * 说明：
     *
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1:
     *
     * 输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * 示例 2:
     *
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     */
    Stack<Integer> stack = new Stack<>();
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        find(candidates, target,0);
        return list;
    }

    public void find(int[] candidates, int target,int start){
        if(target<0)
            return;
        for(int i=start; i<candidates.length; i++){
            if(target == candidates[i]){
                List<Integer> l = new ArrayList<>();
                l.add(candidates[i]);
                Iterator<Integer> iterator = stack.iterator();
                while(iterator.hasNext()){
                    l.add(iterator.next());
                }
                list.add(l);
                //return;
            }else {
                stack.push(candidates[i]);
                find(candidates, target - candidates[i], i);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {4,2,8};
        int target = 8;
        List list = new CombinationSum().combinationSum(candidates,target);
        System.out.println();
    }
}
