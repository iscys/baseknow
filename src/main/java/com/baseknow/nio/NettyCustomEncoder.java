package com.baseknow.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.ByteBuffer;

public class NettyCustomEncoder extends MessageToByteEncoder<RemotingModel> {
    @Override
    protected void encode(ChannelHandlerContext ctx, RemotingModel remoting, ByteBuf out) throws Exception {
        try {
            ByteBuffer encode = remoting.encode();
            out.writeBytes(encode);
        }catch (Exception e){
            System.out.println("error");
        }

    }
}
