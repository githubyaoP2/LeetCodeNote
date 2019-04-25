package com.leetcode.solution._11_20;

import java.util.*;

public class LetterCombinations {
    /**
     *         Map<Character,List<Character>> map = new HashMap<>();
     *         map.put('2',Arrays.asList('a','b','c'));
     *         map.put('3',Arrays.asList('d','e','f'));
     *         map.put('4',Arrays.asList('g','h','i'));
     *         map.put('5',Arrays.asList('j','k','l'));
     *         map.put('6',Arrays.asList('m','n','o'));
     *         map.put('7',Arrays.asList('p','q','r','s'));
     *         map.put('8',Arrays.asList('t','u','v'));
     *         map.put('9',Arrays.asList('w','x','y','z'));
     *         return null;
     * @param digits
     * @return
     */
    public List<String> solution1(String digits) {
        List<String> list = new ArrayList<>();
        for(int i=0; i<digits.length(); i++){
            String tmp = "";
            switch (digits.charAt(i)){
                case '2':
                    tmp = "abc";
                    break;
                case '3':
                    tmp = "def";
                    break;
                case '4':
                    tmp = "ghi";
                    break;
                case '5':
                    tmp = "jkl";
                    break;
                case '6':
                    tmp = "mno";
                    break;
                case '7':
                    tmp = "pqrs";
                    break;
                case '8':
                    tmp = "tuv";
                    break;
                case '9':
                    tmp = "wxyz";
                    break;
                default:
                    break;
            }
            if(list.isEmpty()){
                for(int j=0; j<tmp.length(); j++){
                    list.add(String.valueOf(tmp.charAt(j)));
                }
            }else {
                List newList = new ArrayList(list.size() * 3);
                for (String s : list) {
                    for (int j = 0; j < tmp.length(); j++) {
                        newList.add(s + String.valueOf(tmp.charAt(j)));
                    }
                }
                list = newList;
            }
        }
        return list;
    }
}
