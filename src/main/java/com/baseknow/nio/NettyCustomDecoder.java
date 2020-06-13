package com.baseknow.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.nio.ByteBuffer;

public class NettyCustomDecoder extends LengthFieldBasedFrameDecoder {

    public NettyCustomDecoder() {

        super(1677216, 0, 4, 0, 0);

    }


    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {

        /**final ByteBuffer buffer1 = in.nioBuffer();

        buffer1.getInt();
        final int limit = buffer1.limit();
        int co =limit-4;
        byte [] bytes =new byte[co];
        buffer1.get(bytes);
        System.out.println(new String(bytes));
         **/
        ByteBuf decode = (ByteBuf)super.decode(ctx, in);
        if(decode ==null){
            return null;
        }

         ByteBuffer buffer = decode.nioBuffer();

        return RemotingModel.decode(buffer);

    }


}
