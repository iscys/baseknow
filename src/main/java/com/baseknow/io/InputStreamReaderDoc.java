package com.baseknow.io;

import com.baseknow.utils.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 字节流转换为字符流的桥梁
 * InputStreamReader
 * OutputStreamWriter
 */
public class InputStreamReaderDoc {

    public static void main(String[] args) throws Exception {

        File file = ResourceUtils.getFile("readme.txt");
        FileInputStream fileInputStream =new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
        int h;
        while (( h=inputStreamReader.read())!=-1){
            System.out.println((char)h);
        }

    }
}
