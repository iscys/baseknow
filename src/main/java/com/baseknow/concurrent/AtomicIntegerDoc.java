package com.baseknow.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDoc {
	
	
	public static void main(String[] args) {
		AtomicInteger ato =new AtomicInteger();
		ato.incrementAndGet();
		System.out.println(ato.getAndIncrement());
		ato.incrementAndGet();
		System.out.println(ato.get());
		ato.incrementAndGet();
		System.out.println(ato.get());
		
	}

}
