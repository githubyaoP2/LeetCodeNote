package com.leetcode.solution._1_10;

public class Convert {
    //time 66.84
    //space 20.03
    public String solution1(String s, int numRows) {
        if("".equals(s) || numRows == 1) {
            return s;
        }
        char[][] result = new char[numRows][s.length()/(numRows-1)+1];
        int m=0;
        int n=0;
        boolean flag = true;
        for(int i=0; i<s.length(); i++){
            result[m][n] = s.charAt(i);
            if(i!=0 && i%(numRows-1) == 0){
                n++;
                flag = !flag;
            }
            if(flag){
                m++;
            }else{
                m--;
            }

        }
        char[] cc = new char[s.length()];
        int k=0;
        for(int i=0; i<numRows; i++){
            for (int j=0; j<result[i].length; j++){
                if(result[i][j] != '\u0000'){
                    cc[k++] = result[i][j];
                }
            }
        }
        return new String(cc);
    }
}
