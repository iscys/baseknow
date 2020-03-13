package com.baseknow.string;

import java.util.LinkedList;

public class StringDoc {

	/**
	 * 字符串的创建都会放在字符串常量池中；
	 * 字符串字面量创建会将字符串放在常量池中 比如 String a ="qwe" ;String b="qwe";
	 * a首先会在常量池中创建qwe， b会直接在常量池中拿到qwe 的引用，a,b 拿到的都是常量池中相同的引用
	 * 所以a=b;
	 * 而 new String("hello") 会先判断常量池中是否有此字符串，没有则创建一个，并且还会在堆内存中创建一个引用，并
	 * 返回堆内存的引用，所以"hello" <> new String("hello")
	 * @param args
	 */
	public static void main(String[] args) {
		String lo="lo";
		String hello ="hello";
		System.out.println(hello=="hel"+"lo");
		System.out.println(hello=="hel"+lo);
		System.out.println(hello== new String("hello"));
		System.out.println(hello== new String("hello").intern());
		System.out.println(new String("hello")== new String("hello"));
		System.out.println(new String("hello").intern()== new String("hello").intern());

		/**
		 * 拆装箱
		 */
		Integer a=new Integer(1231);
		int b=1231;
		System.out.println(a==b);
	}
}
