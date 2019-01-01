package com.baseknow.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

    private Bootstrap clientBootstrap;
    private Channel channel;
    private String host ;
    private int port ;
    private EventLoopGroup event;

    NettyClient(String host,int port){
        this.host=host;
        this.port=port;
        doOpen();
        connection();
    }

    /**
     * open
     *
     */
    protected void doOpen() {
        event = new NioEventLoopGroup();
        clientBootstrap = new Bootstrap();
        clientBootstrap.group(event)
                .channel(NioSocketChannel.class)
                .handler(new ChatClientInitializer());

    }
    /**
     * nettyClient
     */
    protected void connection() {
        try {
            ChannelFuture connect = clientBootstrap.connect(host, port);
            channel = connect.sync().channel();

        }catch(Exception e){}

    }



    /**
     * 获得当前的channel
     */
    public Channel getChannel(){
        if(null==channel){
            return null;
        }
        else{
            return channel;
        }
    }

    public void destory(){
        event.shutdownGracefully();
    }
}
