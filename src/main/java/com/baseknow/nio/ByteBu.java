package com.baseknow.nio;

import java.nio.ByteBuffer;

public class ByteBu {

    public static void main(String[] args) {
         ByteBuffer allocate = ByteBuffer.allocateDirect(10);
        allocate.putInt(10);
         ByteBuffer slice = allocate.slice();
         slice.putInt(20);
        allocate.flip();
        allocate.limit(8);
         System.out.println(allocate.getInt());
        System.out.println(allocate.getInt());

    }
}
