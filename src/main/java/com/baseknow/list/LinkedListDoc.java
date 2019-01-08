package com.baseknow.list;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * LinkedList有点就是它的增删速度极快，得益于
 * 它的数据结构是双向链表。对于添加以及删除一个元素
 * 只是改变上下元素的指向就可以了，成本很低；
 * @author cys
 *
 */
public class LinkedListDoc {



	
	public static void main(String[] args) throws Exception{
		//new ConcurrentLinkedQueue<>();
		//List li =new LinkedList<>();
		//System.out.println(9>>1);//9/2
		//fork();
		
		normal();
	}


	public  static void fork() throws Exception{
		final int i =100009;
		long start =System.currentTimeMillis();
		System.err.println(10/3*2);
		CountDownLatch latch =new CountDownLatch(i);
		ConcurrentLinkedQueue<Object> objects = new ConcurrentLinkedQueue<>();
		ExecutorService exe = Executors.newFixedThreadPool(4);



		Future<String> submit1 = exe.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				for (int j = 1; j <= i / 3; j++) {
					System.out.println(j);
					objects.add(j);
					latch.countDown();
				}
				return null;
			}
		});

		Future<String> submit = exe.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				for (int j = i / 3+1; j <=i/3*2; j++) {
					System.out.println(j);
					objects.add(j);
					latch.countDown();
				}
				return null;
			}
		});


		Future<String> submit2 = exe.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				for (int j = i / 3*2+1; j <=i; j++) {
					System.out.println(j);
					objects.add(j);
					latch.countDown();
				}
				return null;
			}
		});

		latch.await();
		System.err.println(objects.size());
		System.out.println(System.currentTimeMillis()-start);

	}

	static  void normal(){
		ConcurrentLinkedQueue<Object> objects = new ConcurrentLinkedQueue<>();
		long start =System.currentTimeMillis();
		for(int i=1;i<=100009;i++){
			System.out.println(i);
			objects.add(i);
		}

		System.out.println(System.currentTimeMillis()-start);
		//69707

	}

}
