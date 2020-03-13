package com.baseknow.nio;

import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

public class JavaNioServerSocket {

    public static void main(String[] args)throws Exception {
         SelectorProvider provider = SelectorProvider.provider();
        Selector selector = provider.openSelector();
         ServerSocketChannel serverSocketChannel = provider.openServerSocketChannel();
        serverSocketChannel.bind(new InetSocketAddress(9011));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT,"123");

        while (true){
             int select = selector.select();
             Set<SelectionKey> selectionKeys = selector.selectedKeys();
             Iterator<SelectionKey> iterator = selectionKeys.iterator();
            if(iterator.hasNext()){
                 SelectionKey next = iterator.next();
                if(next.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel)next.channel();
                     SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);
                    SelectionKey register = accept.register(selector, SelectionKey.OP_READ);
                     System.out.println("connection");
                    iterator.remove();

                }
            }

        }


    }
}
