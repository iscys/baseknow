package com.baseknow.netty.service;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NettyBootService {

    NioEventLoopGroup boosGroup;
    NioEventLoopGroup workGroup;
    ServerBootstrap boostrap;
    int port;

    public NettyBootService(int port){
        this.port=port;
        initNettyConfig();
        doStart();

    }

    private void initNettyConfig() {
        boosGroup =new NioEventLoopGroup(2, new ThreadFactory(){
            private AtomicInteger threadIndex = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,String.format("boosGroup-%s",threadIndex.getAndIncrement()
                ));
            }
        });
        workGroup =new NioEventLoopGroup(4,new ThreadFactory(){
            private AtomicInteger workIdex = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,String.format("workGroup-%s",workIdex.getAndIncrement()
                ));
            }
        });
        boostrap =new ServerBootstrap();


    }

    private void doStart() {
        boostrap.group(boosGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChatServiceInitializer())
                .localAddress(new InetSocketAddress(9011));
        try {
            ChannelFuture sync = boostrap.bind().sync();
            InetSocketAddress socketAddress = (InetSocketAddress)sync.channel().localAddress();
            System.out.println(socketAddress.getPort());
        }catch (Exception e1){
            throw new RuntimeException("this.serverBootstrap.bind().sync() InterruptedException", e1);
        }

    }

    public static void main(String[] args)throws Exception {
       new NettyBootService(9011);


        //System.out.println(1111);

    }
}
