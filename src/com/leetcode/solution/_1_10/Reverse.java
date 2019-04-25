package com.leetcode.solution._1_10;

public class Reverse {

    //几种特殊情况的reverse
    // -2^31 -- 2^31-1
    // 120 -- 21
    // -21 -- -12
    //time 68.73%
    //space 0.95%
    //与最快只有用两个变量存储值的差距
    public int solution1(int x) {
        int range1 = Integer.MAX_VALUE/10;
        int range2 = Integer.MIN_VALUE/10;
        int sum = 0;
        while(x!=0){
            if(sum>range1||sum<range2)
                return 0;
            sum = sum*10+x%10;
            x = x/10;
        }
        return sum;
    }
}
