package com.baseknow.netty.service;


import com.baseknow.nio.NettyCustomDecoder;
import com.baseknow.nio.NettyCustomEncoder;
import com.baseknow.nio.NettyHandle;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;



public class ChatServiceInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {


        System.out.println("initchannel");

        ChannelPipeline pip=ch.pipeline();
        pip.addLast(new NettyCustomDecoder());
        pip.addLast(new NettyCustomEncoder());
       // pip.addLast(new IdleStateHandler(0, 0, 1));
        pip.addLast(new NettyHandle());

    }

}
