package com.leetcode.solution._11_20;

/**
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 */
public class IntToRoman {
    public String solution1(int num) {
        StringBuilder sb = new StringBuilder();
        int tmp = 0;
        if((tmp=num/1000)>0){
            while(tmp-->0) {
                sb.append("M");
            }
        }
        num %= 1000;
        if((tmp=num/100)>0){
            if(tmp == 4){
                sb.append("CD");
            }else if(tmp == 9){
                sb.append("CM");
            }else{
                if(tmp >= 5){
                    sb.append("D");
                    tmp -= 5;
                }
                while(tmp-->0) {
                    sb.append("C");
                }
            }
        }
        num %= 100;
        if((tmp=num/10)>0){
            if(tmp == 4){
                sb.append("XL");
            }else if(tmp == 9){
                sb.append("XC");
            }else{
                if(tmp >= 5){
                    sb.append("L");
                    tmp -= 5;
                }
                while(tmp-->0) {
                    sb.append("X");
                }
            }
        }
        num %= 10;
        if((tmp=num)>0){
            if(tmp == 4){
                sb.append("IV");
            }else if(tmp == 9){
                sb.append("IX");
            }else{
                if(tmp >= 5){
                    sb.append("V");
                    tmp -= 5;
                }
                while(tmp-->0) {
                    sb.append("I");
                }
            }
        }
        return sb.toString();
    }
}
