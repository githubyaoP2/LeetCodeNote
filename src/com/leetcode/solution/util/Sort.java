package com.leetcode.solution.util;

import java.util.Arrays;

public class Sort {
    //计数排序

    //桶排序

    //基数排序

    //冒泡

    //选择

    //插入

    //希尔

    //堆排序
    public static void heapSort(Comparable[] comparables){
        for(int i=comparables.length/2; i>=0; i--){
            fun7(comparables,0,comparables.length-1);
        }

        for(int i=0; i<comparables.length-1; i++){
            swap(comparables,0,comparables.length-1-i);
            fun7(comparables,0,comparables.length-2-i);
        }

    }

   private static void fun7(Comparable[] comparables,int start,int end){
       int parent = start;
       int child = start*2+1;
       while(child<=end) {
           if (comparables[child].compareTo(comparables[child + 1]) < 0)
               child++;
           if(comparables[child].compareTo(comparables[parent])>0){
               swap(comparables,child,start);
               parent = child;
               child = parent*2 + 1;
           }else
               break;
       }
   }

    //归并
    public static void mergeSort(Comparable[] comparables){
        fun3(comparables,0,comparables.length-1);
    }

    private static void fun3(Comparable[] comparables,int lo,int hi){
        if(lo >= hi ) return;
        int mid = (lo+hi)/2;
        fun3(comparables,lo,mid);
        fun3(comparables,mid+1,hi);
        func4(comparables,lo,mid,hi);//merge
    }

    private static void func4(Comparable[] comparables,int lo,int mid,int hi){
        Comparable[] tmp = new Comparable[hi-lo+1];
        for(int i=lo; i<=hi; i++){
            tmp[i-lo] = comparables[i];
        }
        int i = lo;
        int j = mid;
        for(int k=0; k<=hi-lo; k++){
            if(i > mid)
                comparables[k] = tmp[j++];
            else if(j > hi)
                comparables[k] = tmp[i++];
            else if(tmp[i].compareTo(tmp[j]) < 0)
                comparables[k] = tmp[i++];
            else
                comparables[k] = tmp[j++];
        }
    }
    //快速
    public static void quickSort(Comparable[] comparables){
        fun1(comparables,0,comparables.length-1);
    }

    private static void fun1(Comparable[] comparables,int lo,int hi){
        int mid = fun2(comparables,lo,hi);
        if(lo<hi) {
            fun1(comparables, lo, mid-1);
            fun1(comparables, mid + 1, hi);
        }
    }

    private static int fun2(Comparable[] comparables,int lo,int hi){
        Comparable o = comparables[lo];
        while(lo < hi){
            while(lo<hi && comparables[hi].compareTo(o)>=0)
                hi --;
            swap(comparables,lo,hi);
            while(lo<hi && comparables[lo].compareTo(o)<=0)
                lo ++;
            swap(comparables,lo,hi);
        }
        return lo;
    }
    //计数排序




    //交换数组两个元素
    private static void swap(Comparable[] comparables,int i,int j){
        Comparable v = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = v;
    }
}
