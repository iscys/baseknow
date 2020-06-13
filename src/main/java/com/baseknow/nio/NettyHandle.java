package com.baseknow.nio;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyHandle extends SimpleChannelInboundHandler<RemotingModel> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RemotingModel msg) throws Exception {

        System.out.println(msg);
    }

    public static void main(String[] args) {
        System.out.println(0x000C);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("111111");
        super.channelRegistered(ctx);
    }
}
