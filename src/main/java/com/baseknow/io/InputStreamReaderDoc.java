package com.baseknow.io;

import com.baseknow.utils.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * 字节流转换为字符流的桥梁
 * InputStreamReader
 * OutputStreamWriter
 */
public class InputStreamReaderDoc {

    public static void main(String[] args) throws Exception {

       //x1();
    	bytes();

    }
    


     /**
      * 解决乱码的问题
      * @throws Exception
      */
    static void bytes() throws Exception{
    	 File file = ResourceUtils.getFile("readme2.txt");
    	 FileInputStream fileInputStream =new FileInputStream(file);
    	 FileWriter fil =new FileWriter("me.txt");
    	 InputStreamReader reader =new InputStreamReader(fileInputStream,"gbk");
    	 int h;
         while (( h=reader.read())!=-1){
            fil.write(h);
        	 System.out.println((char)h);
             
         }
         fileInputStream.close();
         reader.close();
         fil.close();
         
    }
    static void x1() throws Exception{
    	 File file = ResourceUtils.getFile("readme.txt");
         FileInputStream fileInputStream =new FileInputStream(file);
         InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
         int h;
         while (( h=inputStreamReader.read())!=-1){
             System.out.println((char)h);
         }
         fileInputStream.close();
         inputStreamReader.close();
    }
}
