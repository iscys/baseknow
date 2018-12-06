package com.baseknow.string;

public class StringDoc {

	
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
