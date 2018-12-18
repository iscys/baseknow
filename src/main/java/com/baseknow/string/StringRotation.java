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






    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     * 示例 1:
     *
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc"
     * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     */

    public static  String reverseWords(String s) {

        String[] s1 = s.split(" ");
        StringBuilder builder =new StringBuilder();
        for(String si :s1){
            StringBuilder reverse = new StringBuilder(si).reverse();
            builder.append(reverse);
            if(si!=s1[s1.length-1]){
                builder.append(" ");
            }

        }
        return builder.toString();


    }

    public static String reverseWords2(String s){
        String[] split = s.split(" ");
        StringBuilder builder =new StringBuilder();
        for(int i=0;i<split.length;i++){
            String str =split[i];
            char[] chars=str.toCharArray();
            int pre =0;
            int tail =chars.length-1;
            for(int j=0;j<chars.length;j++){
                if( pre >=tail){
                    break;
                }
                char tmp =chars[pre];
                chars[pre]=chars[tail];
                chars[tail] =tmp;
                pre++;
                tail--;

            }
            builder.append(new String(chars)+(i==split.length-1?"":" "));
        }
        return builder.toString();
    }


}
