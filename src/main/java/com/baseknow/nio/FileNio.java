package com.baseknow.nio;


import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileNio {

    public static void main(String[] args)throws Exception {

         RandomAccessFile rw = new RandomAccessFile("1.txt", "rw");
         System.out.println(rw.length());
         ByteBuffer allocate = ByteBuffer.allocate(4);
         ByteBuffer buffer = allocate.putInt(31);
         buffer.flip();
         FileChannel channel = rw.getChannel();
          MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 8);
        final int anInt = map.getInt();
        System.out.println(anInt);
        map.put(allocate);
        // map.force();


    }
}
