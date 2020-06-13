package com.baseknow.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;

public class NettyCustimService {

    public static void main(String[] args) {
         ServerBootstrap serverBootstrap = new ServerBootstrap();
         ChannelFuture bind = serverBootstrap.group(new NioEventLoopGroup(1), new NioEventLoopGroup(4))
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {

                    }
                })
                .bind(9088);


    }
}
