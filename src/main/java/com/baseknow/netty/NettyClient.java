package com.baseknow.netty;

import com.baseknow.netty.service.DefaultNettyFuture;
import com.baseknow.netty.service.Invocations;
import com.baseknow.netty.service.ResultResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

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
                        pip.addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));//解码，定长域，避免tcp 拆包粘包
                        pip.addLast(new ObjectEncoder());//outbound 处理器进行编码
                        pip.addLast(new ChatClientMyHandler());

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
         NettyClient client = new NettyClient("localhost", 9011);


    }
}
