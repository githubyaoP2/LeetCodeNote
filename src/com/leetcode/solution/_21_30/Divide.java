package com.leetcode.solution._21_30;

/**
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class Divide {
    public int solution1(int dividend, int divisor) {
        if(divisor == dividend){
            return 1;
        }
        if(divisor == Integer.MIN_VALUE){
            return 0;
        }
        int result = 0;
        boolean flag = false;
        boolean f = false;
        if(dividend>0&&divisor<0 || dividend<0&&divisor>0){
            flag = true;
        }
        if(dividend == Integer.MIN_VALUE){
            if(divisor == -1)
                return Integer.MAX_VALUE;
            dividend = Integer.MAX_VALUE;
            f = true;
        }
        if(divisor<0){
            divisor = 0-divisor;
        }
        if(dividend<0){
            dividend = 0-dividend;
        }
        while(dividend>=divisor){
            dividend -= divisor;
            result++;
        }
        if(f && dividend+1>=divisor){
            result++;
        }
        if(flag){
            result = 0-result;
        }
        return result;
    }

    public int solution2(int dividend, int divisor){
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        boolean flag = false;
        if(dividend>0&&divisor<0 || dividend<0&&divisor>0){
            flag = true;
        }

        long var1 = Math.abs((long)dividend);
        long var2 = Math.abs((long)divisor);
        int shift = 0;
        int result = 0;
        while(var1>=var2){
            while(var1>=var2<<shift){
                shift ++;
            }
            result += 1<<(shift-1);
            var1 -= var2<<(shift-1);
            shift = 0;
        }
        return flag?-result:result;
    }











    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isPositive = true;
        if (dividend > 0 && divisor < 0 || (dividend < 0 && divisor > 0)) {
            isPositive = false;
        }

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int shift = 0;
        int result = 0;

        while (a >= b) {
            while (a >= b << shift) {
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
            shift = 0;
        }

        return isPositive ? result : -result;
    }
}
