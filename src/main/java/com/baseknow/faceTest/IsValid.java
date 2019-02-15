package com.baseknow.faceTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class IsValid {

    /**
     * 思路：使用栈的特点FILO进行判断括号是否是有效的；
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        LinkedList<Character> list =new LinkedList();
        HashMap<Character,Character> map =new HashMap();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){

           if(map.containsValue(chars[i])){
               list.push(chars[i]);

           }else{
               Character peek = list.peek();
               if(!map.get(chars[i]).equals(peek)){
                   return false;
               }else{
                   list.pop();
               }

           }

        }
        return list.isEmpty();
    }


    /**
     * 第二种解法
     * {{}}
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        HashMap<Character,Character> map =new HashMap<>();
        LinkedList<Character> list =new LinkedList<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        int strLen =s.length();
        for(int i=0;i<strLen;i++){
            char siChar = s.charAt(i);
            if(map.containsKey(siChar)){
                Character obtain = list.peek();
                if(!map.get(siChar).equals(obtain)){
                    return false;
                }else{
                    list.pop();
                }
            }else{
                list.push(siChar);
            }

        }
        return list.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(isValid2("{{}}"));
    }
}
