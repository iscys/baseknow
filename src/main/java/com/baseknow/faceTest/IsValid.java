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
}
