package com.baseknow.string;


/**
 * 字符串反转
 */
public class StringRotation {


    public static void main(String[] args) {
        System.out.println(reverseString("比知识"));
    }

    /**
     * 第一种方式
     * @param s
     * @return
     */
    public static  String reverseString(String s) {

         char[] chars = s.toCharArray();
        StringBuilder builder =new StringBuilder();
        for(int i =chars.length-1;i>=0;i--){
            builder.append(chars[i]);
        }
        return builder.toString();

    }

    /**
     * 简单API 调用
     */
    public static String builderApi(String s){

        return new StringBuilder(s).reverse().toString();
    }


}
