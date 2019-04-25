package com.leetcode.solution._21_30;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> solution1(int n) {
        put("",n,n);
        return l;
    }

    List<String> l = new ArrayList<>();

    void put(String s,int left,int right){
        if(left == 0 && right == 0){
            l.add(s);
        }

        if(left>0){
            put(s+"(",left-1,right);
        }

        if(right>left){
            put(s+")",left,right-1);
        }
    }

}
