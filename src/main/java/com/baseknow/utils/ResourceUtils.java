package com.baseknow.utils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.util.StringUtils;

/**
 * spring 提供的文件工具类->FileSystemContextResource
 * @author iscys
 *
 */
public class ResourceUtils {
	
	
	/**
	 * 加载项目中的文件转换为文件File对象
	 * 如果文件在classpath 目录下，resourceName = classes下的相对路径 eg->spring/applicationContext.xml
	 * 如果查找的文件在磁盘中，resourceName=磁盘绝对路径：rg->D:\\tomcat7.0.59\\apache-tomcat-7.0.59\\
	 * 首先先会到项目路径下找
	 * 然后才会到系统文件中去找
	 * ..可以返回上一级目录
	 * @throws Exception 
	 */
	
	public static File getFile(String resourceName) throws Exception {
		
		notNull(resourceName, "文件名不能为空");
		ClassLoader loader = getClassLoader();
		//判断是否在classpath目录下
		URL url = loader.getResource(resourceName);
		if(url==null) {
			//去磁盘中获取文件
			File file = new File(resourceName);
			if(!file.exists()) {throw new IOException("文件不存在");}
			return file;
		}
		else {
			//创建classpath 目录下的文件对象,utils使用spring的
			URI uri = toURI(url.toString());
			return new File(uri.getSchemeSpecificPart());
			
		}
		
	}
	
	/**
	 * 创建URL实例为给定的location
	 * @param location
	 * @return
	 * @throws URISyntaxException
	 */
	public static URI toURI(String location) throws URISyntaxException {
		return new URI(StringUtils.replace(location, " ", "%20"));
	}

	
	
	
	
	
	
	
	/**
	 * 获取类加载器
	 */
	
	public static  ClassLoader getClassLoader() {
		
		
		ClassLoader loader = null;
		try {
			loader = Thread.currentThread().getContextClassLoader();
		}catch(Exception e) {}
		if(loader==null) {
		 loader = ResourceUtils.class.getClassLoader();
		}
		return loader;
	}
	
	/**
	 * 检测抛异常
	 */
	
	public static void notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}
	

}
