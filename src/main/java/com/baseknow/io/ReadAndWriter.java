package com.baseknow.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.io.IOUtils;

import com.baseknow.utils.ResourceUtils;

/**
 * IO字节流操作对于文件的读和写操作；
 * @author iscys
 *
 */
public class ReadAndWriter {


	
	public static void main(String[] args) throws Exception {

		ReentrantReadWriteLock lock =new ReentrantReadWriteLock();
		ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
		ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

		new Thread(()->{
			try {
				readLock.lock();
				Thread.sleep(100000);
			}catch (Exception e){

			}finally {
				readLock.unlock();
			}
		}).start();

	new Thread(()->{
			try {
				writeLock.lock();
				Thread.sleep(100000);
			}catch (Exception e){

			}finally {
				writeLock.unlock();
			}
		}).start();


	}

	/**
	 * 无缓冲区的方法
	 * @throws Exception
	 */
	public static void noBufferMethod() throws Exception {
		File file = ResourceUtils.getFile("readme.txt");
		//获取文件的输入流；
		FileInputStream fileInput =new FileInputStream(file);
		int read = fileInput.read();
		System.out.println(read);
		int read2 = fileInput.read();//每读一次，只会读取一个字节，指针往后移动一次，当没有数据的时候会返回-1
		System.out.println(read2);
		fileInput.close();
		
		///-------------华丽的分界线,循环读取数据---------------///
		File file2 = ResourceUtils.getFile("readme.txt");
		//获取文件的输入流；
		FileInputStream fileInput2 =new FileInputStream(file);
		int h;
		while((h=fileInput2.read())!=-1) {
			System.out.println(h);
		}
		fileInput2.close();
		
		//--------------输入流与输出流进行文件的复制粘贴----------///
		File file3 = ResourceUtils.getFile("readme.txt");
		//获取文件的输入流；
		FileInputStream fileInput3 =new FileInputStream(file);
		//获取文件的输出流
		FileOutputStream out =new FileOutputStream("me.txt");
		int x;
		while((x =fileInput3.read())!=-1) {
			//不断的写入
			out.write(x);
		}
		out.close();
		fileInput3.close();
		
		
		//--------------IOUtils 中也实现了对文件流之间拷贝对封装----------///
				File file4 = ResourceUtils.getFile("readme.txt");
				//获取文件的输入流；
				FileInputStream fileInput4 =new FileInputStream(file);
				//获取文件的输出流
				FileOutputStream out4 =new FileOutputStream("me.txt");
				IOUtils.copy(fileInput4, out4);
				out4.close();
				fileInput4.close();
		
	}
	
	/**
	 * 带缓冲区的,
	 * h=fileInput.read(b)
	 * h返回读取的字节个数
	 * @throws Exception 
	 */
	public static void haveBuffer() throws Exception{
		File file = ResourceUtils.getFile("readme.txt");
		//获取文件的输入流；
		FileInputStream fileInput =new FileInputStream(file);
		//获取文件的输出流
		FileOutputStream out =new FileOutputStream("me.txt");
		byte [] b = new byte[2048];
		int h;
		while((h=fileInput.read(b))!=-1) {
			System.out.println(h);
			out.write(b, 0, h);
		}
		
		out.close();
		fileInput.close();
	}
	

}
