package com.baseknow.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.baseknow.utils.ResourceUtils;

/**
 * 内存输出流；
 * 读取到到数据全部先全部放入到内存中，然后再进行输出,是一个数组，所以不必进行，大容量的数据不要进行此操作
 * 关闭；一般用这个流是为了解决乱码到问题；
 * @author iscys
 *
 */
public class ByteArrayOutputstreamDoc {

	
	public static void main(String[] args) throws Exception {
		//--------------输入流与输出流进行文件的复制粘贴----------///
				File file = ResourceUtils.getFile("readme.txt");
				System.out.println(file);
				//获取文件的输入流；
				FileInputStream fileInput3 =new FileInputStream(file);
				//将数据写入到一个byte 数组中
				ByteArrayOutputStream out =new ByteArrayOutputStream();
				int x;
				while((x =fileInput3.read())!=-1) {
					//不断的写入
					out.write(x);
				}
				System.out.println(out);
				fileInput3.close();
	}
}
