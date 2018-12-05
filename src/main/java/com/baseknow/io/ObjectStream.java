package com.baseknow.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.baseknow.testclass.TestClass;
import com.baseknow.utils.ResourceUtils;

/**
 * 对象输入输出流
 * @author iscys
 *
 */
public class ObjectStream {

	
	public static void main(String[] args) throws Exception {
		
		File file = ResourceUtils.getFile("readme.txt");
		OutputStream out =new FileOutputStream(file);
		ObjectOutputStream obj =new ObjectOutputStream(out);
		obj.writeObject(new TestClass("cys","sss"));
		obj.close();
		out.close();
		InputStream ins =new FileInputStream(file);
		ObjectInputStream inn =new ObjectInputStream(ins);
		TestClass readObject = (TestClass) inn.readObject();
		System.out.println(readObject);
		ins.close();
		inn.close();
		
	}
	
	
	
}
