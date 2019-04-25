package com.leetcode.solution._1_10;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class IsMatch {
    public boolean solution1(String s, String p) {
        if("".equals(p))
            return "".equals(s);
        if(p.length() == 1)
            return s.length() == 1 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
        if(p.charAt(1) != '*') {
            if (s.isEmpty())
                return false;
            return (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && solution1(s.substring(1), p.substring(1));
        }
        while(!s.isEmpty() && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))){
            if(solution1(s,p.substring(2)))
                return true;
            s = s.substring(1);
        }
        return solution1(s,p.substring(2));
    }

    /**
     *  与solution1一样，不过减少了代码
     */
    public boolean solution2(String s, String p){
        if(p.isEmpty()) return s.isEmpty();
        if(p.length()>1 && p.charAt(1)=='*'){
            return solution2(s,p.substring(2)) || (!s.isEmpty()&&p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && solution2(s.substring(1),p);
        }else {
            return !s.isEmpty() && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && solution2(s.substring(1),p.substring(1));
        }
    }

    /**
     * 动态规划
     *
     * dp[i][j]表示字符串0--(i-1)与模式0--(j-1)是否匹配
     * dp[i][j] = dp[i-1][j-1]        if(p[j-1]!='*' && (s[i-1]=p[j-1] || p[j-1]='.'))
     * dp[i][j] = dp[i][j-2] || ((s[i-1]=p[j-2] || p[j-2]='.') && dp[i-1][j])     if(p[j-1]='*')
     * dp[i][j] = false     if(else)
     */
    public boolean solution3(String s, String p){
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=1; i<=s.length(); i++){
            dp[i][0] = false;
        }
        boolean flag = true;
        for(int j=1; j<=p.length(); j++){
            if(flag && j%2 == 0 ){
                if(p.charAt(j-1) == '*') {
                    dp[0][j] = true;
                }else {
                    dp[0][j] = false;
                    flag = false;
                }
            }else {
                dp[0][j] = false;
            }
        }
        for(int i=1; i<=s.length(); i++){
            for (int j=1; j<=p.length(); j++){
                if(p.charAt(j-1)=='*'&& j>1){
                    dp[i][j] = dp[i][j-2] || ((s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.')&&dp[i-1][j]);
                }else {
                    if(i<1) {
                        dp[i][j] = false;
                        continue;
                    }
                    if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                        dp[i][j] = dp[i-1][j-1];
                    }else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
