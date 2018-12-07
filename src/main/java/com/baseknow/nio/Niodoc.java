package com.baseknow.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 直接缓冲区：将缓冲区建立在操作系统的物理内存中
 * 非直接缓冲区：通过allocate（）方法分配缓冲，将缓冲区建立在jvm的内存中
 * @author iscys
 *
 */
public class Niodoc {
	
	public static void main(String[] args)throws Exception {
		
	
		charset();
	}

	public  static void method() throws IOException {
		//利用通道完成文件的复制】1.7提供了 open 方法
		FileChannel read = FileChannel.open(Paths.get("me.txt"), StandardOpenOption.READ);//读模式
		FileChannel write = FileChannel.open(Paths.get("m21.txt"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);//读模式
		ByteBuffer bybuf= ByteBuffer.allocate(1024);
		while(read.read(bybuf)!=-1) {
			bybuf.flip();
			write.write(bybuf);
			bybuf.clear();
		}
		read.close();write.close();
		
	}
	/**
	 * transferTo
	 * @throws IOException 
	 */
	public  static void FileMap() throws IOException{
		FileChannel read = FileChannel.open(Paths.get("E:\\1.iso"), StandardOpenOption.READ);//读模式
		FileChannel write = FileChannel.open(Paths.get("E:\\2.iso"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);//读模式
		read.transferTo(0, read.size(), write);
		
	}
	/**
	 *字符编码
	 * @throws IOException 
	 * 文件用什么编的码，在解码的时候就用什么解码；
	 */
	public  static void charset() throws IOException{
		FileChannel ch = FileChannel.open(Paths.get("me.txt"), StandardOpenOption.READ);//读模式
		Charset forName = Charset.forName("UTF-8");
		
		ByteBuffer byteb =ByteBuffer.allocate(2048);
		ch.read(byteb);
		byteb.flip();
		CharBuffer cha = forName.decode(byteb);
		System.out.println(new String(cha.array()));
	}
}
