package com.baseknow.netty.httpService;

import com.baseknow.concurrent.Exc;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

public class HttpService {

    private String address;
    private int port;
    private volatile NioEventLoopGroup bossGroup;
    private volatile  NioEventLoopGroup workGroup;
    private volatile ServerBootstrap serverBootstrap;

    public HttpService(String address,int port){
        this.address=address;
        this.port=port;
        this.bossGroup =new NioEventLoopGroup();
        this.workGroup =new NioEventLoopGroup(1<<2);
        this.serverBootstrap =new ServerBootstrap();

    }

    public void openConnetion(){
        try {
            serverBootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decode",new HttpRequestDecoder())
                                    .addLast("encode",new HttpResponseEncoder())

                                    .addLast("myself",new MyHttpHandler());

                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();
        }
        catch (Exception e){

            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }


    public static void main(String[] args) {
        HttpService service=new HttpService("127.0.0.1",8011);
        service.openConnetion();
    }
}
