package com.ohgiraffers;

public class Appilcation {
    static int v=0;
    public static void main(String[] args) {
        //System.out.println(plus(5,4));
        plus(4,6);
        System.out.println(9);

        System.out.println(v);
    }

    public static void plus(int a, int b){
        int c=0;
        v=a+b;
    }
}
