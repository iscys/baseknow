package com.baseknow.io;

import com.baseknow.utils.ResourceUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 字符流
 * @Author:iscys
 */
public class FileReaderAndWriter {


    public static void main(String[] args)throws Exception {
        fileReader();
    }


    /**
     *与字节流一样的操作
     */
    public static void fileReader() throws   Exception{
        File file = ResourceUtils.getFile("readme.txt");
        FileReader reader = new FileReader(file);
        FileWriter writer =new FileWriter("me.txt");
        int h;
        while ((h=reader.read())!=-1){
            System.out.println((char)h);
            writer.write(h);
        }
        reader.close();
        writer.close();

    }
}
