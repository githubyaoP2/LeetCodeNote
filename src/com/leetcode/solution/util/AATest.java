package com.leetcode.solution.util;

public class AATest {

    public class Apple implements Comparable<Apple>{

        int weight;

        public Apple(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Apple o) {
            return this.weight - o.weight;
        }
    }

    Apple[] apples = new Apple[10];

    {
        apples[0] = new Apple(3);
        apples[1] = new Apple(5);
        apples[2] = new Apple(2);
        apples[3] = new Apple(1);
        apples[4] = new Apple(6);
        apples[5] = new Apple(9);
        apples[6] = new Apple(7);
        apples[7] = new Apple(8);
        apples[8] = new Apple(4);
        apples[9] = new Apple(2);
    }

    public static void main(String[] args) {
//        AATest test = new AATest();
//        Sort.quickSort(test.apples);
//        System.out.println();
        System.out.println(new Search().KMP("aaaabba","d"));
    }
}
