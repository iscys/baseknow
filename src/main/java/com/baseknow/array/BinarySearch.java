package com.baseknow.array;

import java.util.Arrays;

/**
 * 二分查找法
 * @author iscys
 */
public class BinarySearch {


    public static void main(String[] args) {
            System.out.println(binary());
    }


    public static int binary() {

        //Arrays.binarySearch()
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 14, 15, 16, 17};
        int key = 15;
        int low = 0;
        int height = a.length - 1;
        while (low <= height) {
            int middle = (low + height) >>> 1;

            if (a[middle] > key) {
                height = middle - 1;
            } else if (a[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;


    }
}