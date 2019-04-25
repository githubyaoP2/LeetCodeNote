package com.leetcode.solution._41_50;

import java.math.BigInteger;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Multiply {

    public static void main(String[] args) {
        new Multiply().multiply("999","999");
    }

    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2))
            return "0";
        int[] array = new int[num1.length()+num2.length()];
        int low = 0;
        int high = 0;
        //进位数组
        for(int i=num1.length()-1; i>=0; i--){
            for(int j=num2.length()-1; j>=0; j--){
                int tmp = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                if(tmp%10+array[i+j+1]+high > 9){
                  low = 1;
                }
                array[i+j+1] = (tmp%10+array[i+j+1]+high)%10;
                high = 0;
                if(tmp/10+array[i+j]+low > 9){
                    high = 1;
                }
                array[i+j] = (tmp/10+array[i+j]+low)%10;
                low = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(array[0] != 0)
            sb.append(array[0]);
        for(int i=1; i<array.length; i++){
            sb.append(array[i]);
        }
        return sb.toString();
    }
}
