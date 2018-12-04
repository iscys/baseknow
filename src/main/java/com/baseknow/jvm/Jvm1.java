package com.baseknow.jvm;

/**
 * 
 * 堆分配参数
 * -XX:+PrintGCDetails     :查看详细信息，包括各个区的情况；
 * -XX:+PrintGC       :遇到gc 就会打印信息；
 * -XX:+UseSerialGC    :配置串行回收器
 * -Xms :设置Java 程序启动时初始堆的大小；
 * -Xmx  :设置Java 程序能获得的最大堆大小；
 * -Xmx20m -Xms5m -XX:+PrintCommandLineFlags    :可以将隐式或者显示传给vm的参数输出；
 * @author iscys
 *
 */
public class Jvm1 {
	Jvm1(){
		//byte [] by =new byte[1024*8];
	}
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("总共内存"+Runtime.getRuntime().totalMemory());
		System.out.println("最大内存"+Runtime.getRuntime().maxMemory());
		System.out.println("空闲内存"+Runtime.getRuntime().freeMemory());
		
		
		byte [] by =new byte[1*1024*1024];
		System.out.println("分配了1m");
		System.out.println("总共内存"+Runtime.getRuntime().totalMemory());
		System.out.println("最大内存"+Runtime.getRuntime().maxMemory());
		System.out.println("空闲内存"+Runtime.getRuntime().freeMemory());
		
		
		
	}

}
