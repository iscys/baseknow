package com.baseknow.nio;

import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
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

}
