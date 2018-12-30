package com.baseknow.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

public class NettyDoc {

    public static void main(String[] args)throws Exception {
        NettyClient client = new NettyClient("127.0.0.1", 9077);
        Channel channel = client.getChannel();
        ChannelFuture future = channel.writeAndFlush("我是你爸爸的爸爸");
        channel.closeFuture().sync();

    }

}
