package com.baseknow.netty;

import com.baseknow.netty.service.DefaultNettyFuture;
import com.baseknow.netty.service.Invocations;
import com.baseknow.netty.service.ResultResponse;
import io.netty.channel.ChannelFuture;
import io.netty.channel.socket.nio.NioSocketChannel;


public class NettyDoc {

    public static void main(String[] args)throws Exception {
        NettyClient client = new NettyClient("127.0.0.1", 9077);

    new Thread(() -> {
        for(;;) {
            try {
                //Thread.sleep(100);
            } catch (Exception e) {
            }
            DefaultNettyFuture future = client.write(new Invocations("陈岳松", "去那买了"));
            ResultResponse o = (ResultResponse) future.get();
            System.err.println(o.id);
        }
    }).start();

    new Thread(() -> {
        for(;;) {
            try {
               // Thread.sleep(100);
            } catch (Exception e) {
            }
            DefaultNettyFuture future2 = client.write(new Invocations("陈岳松bb", "去那买了"));
            ResultResponse o2 = (ResultResponse) future2.get();
            System.err.println(o2.id);
        }
    }).start();






    }




}



