package com.leetcode.solution._31_40;

import java.util.*;

public class CombinationSum2 {
    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用一次。
     *
     * 说明：
     *
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1:
     *
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     * 示例 2:
     *
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 所求解集为:
     * [
     *   [1,2,2],
     *   [5]

     */
    Stack<Integer> stack = new Stack<>();
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        find(candidates, target,0);
        return list;
    }

    public void find(int[] candidates, int target,int start){
        if(target<0)
            return;
        Set<Integer> set = new HashSet<>();
        for(int i=start; i<candidates.length; i++){
            if(set.contains(candidates[i]))
                continue;
            else
                set.add(candidates[i]);
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
                find(candidates, target - candidates[i], i+1);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        //int[] candidates = {1,2,1,5};
        int target = 8;
        List list = new CombinationSum2().combinationSum2(candidates,target);
        System.out.println();
    }
}
