package com.baseknow.faceTest;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class IntReverse {


    public static  int reverse(int x) {
        try {
            boolean flag = false;

            String str = String.valueOf(x);
            int i = str.indexOf("-");

            if (i != -1) {
                flag = true;
                str = str.substring(i + 1);
            }
            StringBuffer buffer = new StringBuffer(str);
            StringBuffer reverse = buffer.reverse();
            String s = new String(reverse);

            if (flag == true) {
                s = "-" + s;

            }
            return Integer.valueOf(s);
        }
        catch (Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {

        System.out.println(123/10);

    }

}
