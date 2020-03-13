package com.baseknow.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;

public class JavaNioSocket {
    public static void main(String[] args)throws Exception {
        SelectorProvider provider = SelectorProvider.provider();
        Selector selector = provider.openSelector();
         SocketChannel socketChannel = provider.openSocketChannel();
        socketChannel.connect(new InetSocketAddress(9011));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }
}
