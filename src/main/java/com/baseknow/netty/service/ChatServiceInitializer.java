package com.baseknow.netty.service;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;



public class ChatServiceInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {


        System.out.println("initchannel");

        ChannelPipeline pip =ch.pipeline();
        //针对不同的业务，netty 提供了不同的channelHandler ,这也是我们需要学习的

        //pip.addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()));
        pip.addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
        pip.addLast(new ObjectEncoder());

        //实现自己的channelHandler
        pip.addLast(new ChatServiceHandler());

    }

}