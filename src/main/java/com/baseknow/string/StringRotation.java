package com.baseknow.string;


/**
 * 字符串反转
 */
public class StringRotation {


    public static void main(String[] args) {
       System.out.println('b'-'a');
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
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba")
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        int[] count1 = new int[26]; // s1每个字符出现的次数
        int[] count2 = new int[26]; // s2每个字符出现的次数

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        int[] diff = new int[26]; // s1和s2每个字符的数量差距
        for (int i = 0; i < diff.length; i++) {
            diff[i] = count2[i] - count1[i];
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if(isSame(diff)) {
                return true;
            }
            diff[s2.charAt(i - s1.length()) - 'a']--; // 去掉首个字符
            diff[s2.charAt(i) - 'a']++; // 添加最新的字符
        }
        return isSame(diff);
    }

    public boolean isSame(int[] diff) {
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] != 0) {
                return false;
            }
        }
        return true;
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
