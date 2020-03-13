package com.baseknow.netty.service;


import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 自己业务的处理
 * @author Administrator
 *
 */
public class ChatServiceHandler extends SimpleChannelInboundHandler<Object> {
    private  ExecutorService excutor = Executors.newFixedThreadPool(10);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("111111111" +msg);
        ctx.channel().writeAndFlush("send Message id =");
        /**
        excutor.submit(()->{
            int i=0;
            for(;;){
                Thread.sleep(1000);
                i++;
                ctx.channel().writeAndFlush("send Message id ="+i);
            }

        });
**/

    }


    //================重写handlerAdded方法，用来进行维护channelGrop==============//

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {



    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        ctx.channel().close();
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel()+"---remove");
    }



}
