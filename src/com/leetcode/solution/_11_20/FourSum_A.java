package com.leetcode.solution._11_20;

import java.util.*;

public class FourSum_A {
    //超出时间限制
    public List<List<Integer>> solution1(int[] nums, int target) {
        if(nums.length < 4) return null;
        List<List<Integer>> list = new ArrayList<>();
//        if(nums.length == 4 && nums[0]+nums[1]+nums[2]+nums[3] == target) {
//            list.add(Arrays.asList(nums[0],nums[1],nums[2],nums[3]));
//        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            for(int j=nums.length-1; j>i+2; j--){
                int m = i+1;
                int n = j-1;
                while(m<n){
                    while(m<n && m>i+1 && nums[m] == nums[m-1]){
                        m++;
                    }
                    while(m<n && n<nums.length-1 && nums[n] == nums[n+1]){
                        n--;
                    }
                    if(nums[m]+nums[n]+nums[i]+nums[j] == 0){
                        list.add(Arrays.asList(nums[m],nums[n],nums[i],nums[j]));
                    }else if(nums[m]+nums[n]+nums[i]+nums[j] < 0){
                        m++;
                    }else {
                        n--;
                    }
                }
            }
        }
        return list;
    }

    //用hash
    public List<List<Integer>> solution2(int[] nums, int target) {
        if(nums.length < 4) return null;
        Map<Integer,List<List<Integer>>> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length == 4 ) {
            if(nums[0]+nums[1]+nums[2]+nums[3] == target) {
                list.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            }
            return list;
        }
       // Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
//            while(i>0  &&i<nums.length&& nums[i] == nums[i-1]){
//                i++;
//            }
            for(int j=i+1; j<nums.length; j++){
//                while(j>i+1 &&j<nums.length && nums[j] == nums[j-1]){
//                    j++;
//                }
                if(map.containsKey(nums[i]+nums[j])){
                    List<List<Integer>> llist = map.get(nums[i]+nums[j]);
                    for(List<Integer> l:llist){
                        int m = l.get(0);
                        int n = l.get(1);
                        if(m!=i && m!=j && n!=i && n!=j ) {
                            List tmp = new ArrayList();
                            tmp.add(nums[i]);
                            tmp.add(nums[j]);
                            tmp.add(nums[m]);
                            tmp.add(nums[n]);
                            list.add(tmp);
                        }
                    }

                }else{
                    if(map.get(target-nums[i]-nums[j]) == null) {
                        map.put(target - nums[i] - nums[j], new ArrayList());
                    }
                    map.get(target-nums[i]-nums[j]).add(Arrays.asList(i,j));
                }
            }
        }

        return list;
    }

    //n数之和通用
    public List<List<Integer>> solution3(int[] nums, int target) {
        func1(nums,target,0);
        return null;
    }

    Stack<Integer> stack = new Stack<>();

    public void func1(int[] nums,int target,int n){
        if(n == nums.length)
            return;
        if(nums[n] == target){
            List<Integer> list = new ArrayList<>();
            Iterator<Integer> iterator = stack.iterator();
            while(iterator.hasNext()){
                list.add(iterator.next());
            }
            return;
        }

        stack.push(nums[n]);
        func1(nums,target-nums[n],n+1);
        stack.pop();
        func1(nums,target,n+1);
    }
}
