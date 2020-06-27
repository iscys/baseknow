package com.baseknow.netty;

import com.baseknow.netty.service.DefaultNettyFuture;
import com.baseknow.netty.service.Invocations;
import com.baseknow.netty.service.ResultResponse;
import com.baseknow.nio.NettyCustomDecoder;
import com.baseknow.nio.NettyCustomEncoder;
import com.baseknow.nio.NettyHandle;
import com.baseknow.nio.RemotingModel;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

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
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pip=ch.pipeline();
                       pip.addLast(new NettyCustomDecoder());
                       // pip.addLast(new IdleStateHandler(0, 0, 1));
                      //  pip.addLast(new NettyCustomEncoder());
                       pip.addLast(new NettyHandle());

                    }
                });
    }
    /**
     * nettyClient
     */
    protected void connection() {
        try {
            ChannelFuture connect = clientBootstrap.connect(host, port);

            channel = connect.sync().channel();


        }catch(Exception e){
            System.out.println("error");
        }

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

    public DefaultNettyFuture write(Invocations o){
        DefaultNettyFuture future= new DefaultNettyFuture(getChannel(),3000);
        o.setId(future.getId());
        channel.writeAndFlush(o);

        return future;
    }


    public void destory(){
        event.shutdownGracefully();
    }


    public static void main(String[] args) throws Exception{
         NettyClient client = new NettyClient("127.0.0.1", 9011);
         Thread.sleep(15000);
         RemotingModel model = new RemotingModel();
        model.setVersion("0.25");
        client.channel.writeAndFlush(model).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                System.out.println("success");
            }
        });

    }
}
