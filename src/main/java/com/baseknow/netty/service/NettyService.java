package com.baseknow.netty.service;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NettyService {

    private volatile EventLoopGroup boosGroup;
    private volatile  EventLoopGroup workGroup;
    private volatile ServerBootstrap boostrap;
    private volatile int port;


    NettyService(int bindPort){
        //万年不变的流程
        boosGroup =new NioEventLoopGroup();
        workGroup =new NioEventLoopGroup();
        boostrap =new ServerBootstrap();
        this.port=bindPort;

    }

    public void doOpen() throws Exception{

        try{
            boostrap.group(boosGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChatServiceInitializer());

            ChannelFuture channelFuture=boostrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();
        }
        finally {

            workGroup.shutdownGracefully();
            boosGroup.shutdownGracefully();
        }


    }

    public static void main(String[] args) throws Exception {

        NettyService service =new NettyService(9011);
        service.doOpen();


    }


}

