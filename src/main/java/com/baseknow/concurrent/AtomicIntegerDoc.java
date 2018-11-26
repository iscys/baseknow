package com.baseknow.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * 在并发环境下，可以使用原子计数器
 * @author iscys
 *
 */
public class AtomicIntegerDoc {
	
	
	public static void main(String[] args) {
		AtomicInteger ato =new AtomicInteger();
		System.err.println(ato.get());
		ato.incrementAndGet();//+1自增
		System.err.println(ato.getAndIncrement());//获取值并+1
		ato.incrementAndGet();
		System.out.println(ato.get());//知只是获取当前值
		ato.incrementAndGet();
		System.out.println(ato.get());
		
	}

}
