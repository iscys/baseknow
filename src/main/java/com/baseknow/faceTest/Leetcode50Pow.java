package com.baseknow.faceTest;

public class Leetcode50Pow {
    /**
     * 2^10 2的10次幂
     * 2*2*2*2*2*2*2*2*2*2
     * @param x
     * @param n
     * 递归分治
     * @return
     */
    public double myPow(double x, int n) {

        if(n==0) return 1; //2^0 =1

        if(n%2!=0) return x*myPow(x,n-1);//奇数情况

       return myPow(x*x,n/2);

    }

    public static void main(String[] args) {
        System.out.println(2>>1);
    }
}
