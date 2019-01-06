package com.baseknow.netty;

import com.baseknow.netty.service.DefaultNettyFuture;
import com.baseknow.netty.service.Invocations;
import io.netty.channel.ChannelFuture;
import io.netty.channel.socket.nio.NioSocketChannel;


public class NettyDoc {

    public static void main(String[] args)throws Exception {
        NettyClient client = new NettyClient("127.0.0.1", 9077);
        //NioSocketChannel  channel =(NioSocketChannel)client.getChannel();

        DefaultNettyFuture future = client.write(new Invocations("陈岳松", "去那买了"));
       Object o = future.get();
        System.err.println(o);


    }




}



