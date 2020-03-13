package com.baseknow.rocketMq;

import java.io.File;
import java.io.FileInputStream;

public class FileService {

    public static void main(String[] args) throws Exception {
        File file =new File("/Users/iscys/store/config/consumerFilter.json");
        System.out.println(file.length());
    }
}
