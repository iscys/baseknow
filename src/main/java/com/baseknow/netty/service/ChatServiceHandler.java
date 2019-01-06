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
    //netty 提供的 可以获得当前channel 组,用来保存一个一个的channel 对象，这个很重要
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        Channel channel =ctx.channel();
        Invocations invoke = (Invocations) msg;

        System.out.println(invoke.method);
//		for(Channel ch:channelGroup) {
//			if(ch==channel) {
//				//如果是自己发的消息的话
//				ch.writeAndFlush("【自己的消息】msg="+msg);
//			}
//			else {
//				//群发消息
//				ch.writeAndFlush(channel.remoteAddress()+"msg="+msg);
//			}
        //	}
        excutor.submit(()->{
            ResultResponse result =new ResultResponse();
            result.setResult(result);
            result.setId(invoke.getId());
            System.out.println(Thread.currentThread().getName()+":"+invoke.getId());
            ctx.channel().writeAndFlush(result);
        });


    }


    //================重写handlerAdded方法，用来进行维护channelGrop==============//

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        System.err.println("新来了一位连接者"+ctx.channel().id().asShortText());//channel 的id，是唯一的
        Channel channel = ctx.channel();
        //进行广播。channelGroup.writeAndFlush 会对所有的channel进行消息的发送与广播
        channelGroup.writeAndFlush("【服务器】-"+channel.remoteAddress()+"进入了聊天室");
        channelGroup.add(channel);

        //ctx.channel().write()


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
