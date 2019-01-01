package com.baseknow.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 构建自己的Handler
 * @author cys
 *
 */
public class ChatClientMyHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(ctx.channel());
        System.out.println(msg);
        System.out.println("消息接收");
        ctx.channel().close();


    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {


        ctx.channel().close();

    }

}
