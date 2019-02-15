package com.baseknow.faceTest;

import java.util.Arrays;

/**
 * 二分查找法
 * 有序的数组，并且进行了排序
 */
public class BinarySearch {


    public static int binarySearch(int[] array,int target){

        Arrays.sort(array);//数组排序

        //二分查找法模板
        /**
         * 1,左右中比较
         */
        int left =0;
        int right =array.length-1;
        int middle=0;
        while(left<=right){

             middle =(left+right)>>1;// 除以2
            if(array[middle]==target){
                return middle;
            }else if(array[middle]<target){
                    left=middle+1;
            }else{
                right=middle-1;
            }

        }
        return middle;

    }

    public static void main(String[] args) {

        int i = binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 4);
        System.out.println(i);

    }

}
