package com.baseknow.faceTest;

import java.util.HashMap;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSUM {
    /**
     * 暴力破解法o(n^2)复杂度，涉及到了两层的for 循环，
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int [] array =new int[2];

        for(int i =0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    array[0]=i;
                    array[1]=j;

                }
            }
        }
        return array;
    }


    /**
     * hash 求解
     * o(n)复杂度
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSums(int[] nums, int target) {

    int [] array  =new int[2];
    HashMap map =new HashMap();

    for(int i=0;i<nums.length;i++){

       int res= target  -nums[i];
       if(map.containsKey(res)){
           int o = (int)map.get(res);
           array[0]= i;
           array[1]=o;
           break;
       }
        map.put(nums[i],i);
    }
    return array;
    }

}
