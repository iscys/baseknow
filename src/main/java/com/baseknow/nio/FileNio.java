package com.baseknow.nio;


import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileNio {

    public static void main(String[] args)throws Exception {



         RandomAccessFile rw = new RandomAccessFile("1.txt", "rw");
         ByteBuffer allocate = ByteBuffer.allocate(4);
         MappedByteBuffer mappedByteBuffer = rw.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 100L);

        mappedByteBuffer.putInt(100);
        ByteBuffer slice = mappedByteBuffer.slice();
        slice.putInt(200);
      // System.out.println( mappedByteBuffer.getInt());
     //   System.out.println( mappedByteBuffer.getInt());




    }
}
