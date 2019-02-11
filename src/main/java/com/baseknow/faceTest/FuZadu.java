package com.baseknow.faceTest;

public class FuZadu {

    /**
     * o(1)复杂度 ->常数复杂，只会做一次运算
     */
    public static void o1(){

        int n =1000;
        System.out.println("you input is"+n);
    }

    /**
     * o(n)线性时间复杂度
     */
    public static void on(){

       for(int i =1;i<=1000;i++){
           System.out.println(i);
       }
    }

    /**
     * o(n^2)平方复杂度
     *
     */
    public static void on2(){
        for(int i =1;i<=1000;i++){
            for(int j =1;j<=1000;j++) {
                System.out.println(i+"---"+j);
            }
        }
    }



    /**
     * o(log(n))对数复杂度
     *
     */
    public static void ologn(){
        for(int i =1;i<=1000;i=i*2){
            System.out.println(i);
        }
    }



    public static void main(String[] args) {
        ologn();
    }


}
