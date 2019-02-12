package com.baseknow.faceTest;

import java.util.*;

/**
 * leetcode 242
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 */
public class Leetcode242 {

    public static void main(String[] args) {

        System.out.println(isAnagram("rat","car"));

    }
    public  static boolean isAnagram2(String s, String t)  {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars1);
       return  String.valueOf(chars).equals(String.valueOf(chars1));
    }


    public  static boolean isAnagram(String s, String t)  {

        HashMap<Character,Integer> current =new HashMap<>();
        HashMap<Character,Integer> receive =new HashMap<>();
        int current_len = s.length();
        int receive_len = t.length();
        if(current_len!=receive_len) return false;
        for(int i=0;i<current_len;i++){
            char c = s.charAt(i);
            if(current.containsKey(c)){
                Integer integer = current.get(c);
                integer+=1;
                current.put(c,integer);
            }else{
                current.put(c,1);
            }
        }

        for(int i=0;i<receive_len;i++){
            char c = t.charAt(i);
            if(receive.containsKey(c)){
                Integer integer = receive.get(c);
                integer+=1;
                receive.put(c,integer);
            }else{
                receive.put(c,1);
            }
        }
      return   current.equals(receive);







    }


}
