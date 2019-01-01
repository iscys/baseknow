package com.baseknow.netty.service;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.nio.channels.Selector;

public class ChatService {


    public static void main(String[] args) throws Exception {


        //万年不变的流程
        EventLoopGroup boosGroup =new NioEventLoopGroup();
        EventLoopGroup workGroup =new NioEventLoopGroup();
        ServerBootstrap boostrap =new ServerBootstrap();
        Selector selector = Selector.open();
        //selector.selectedKeys()
        //boosGroup.next();
        try{

            boostrap.group(boosGroup, workGroup)
                    .channel(NioServerSocketChannel.class)

                    .childHandler(new ChatServiceInitializer());


            ChannelFuture channelFuture=boostrap.bind(9077).sync();

            channelFuture.channel().closeFuture().sync();
        }
        finally {

            workGroup.shutdownGracefully();
            boosGroup.shutdownGracefully();
        }


    }


}

