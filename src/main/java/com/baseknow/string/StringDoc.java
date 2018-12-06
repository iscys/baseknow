package com.baseknow.string;

public class StringDoc {

	/**
	 * 字符串的创建都会放在字符串常量池中；
	 * 字符串字面量创建会将字符串放在常量池中 比如 String a ="qwe" ;String b="qwe"; b 的引用直接拿到的就是常量池中的
	 * 引用；所以a=b;
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
	}
}
