package com.baseknow.netty;

import com.baseknow.netty.ChatClientMyHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * 构建自己的Initializer,继承ChannelInitializer
 * @author cys
 *
 */
public class ChatClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {


        ChannelPipeline pip=ch.pipeline();

        pip.addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()));
        pip.addLast(new StringDecoder(CharsetUtil.UTF_8));
        pip.addLast(new StringEncoder(CharsetUtil.UTF_8));
        pip.addLast(new ChatClientMyHandler());

    }

}
