package com.mission.netty.sixthExample.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * @author mission
 * @date 2019/1/24 0024-15:00
 */
public class MyClient {

  public static void main(String[] args) throws InterruptedException {
    //客户端只需要一个线程组
    EventLoopGroup eventLoopGroup =new NioEventLoopGroup();
    try {
     Bootstrap bootstrap=new Bootstrap();
     bootstrap.group(eventLoopGroup)
         .channel(NioSocketChannel.class)
         .handler(new MyClientInitializer())
          ;

      ChannelFuture channelFuture =bootstrap.connect("localhost",8899).sync();
      channelFuture.channel().closeFuture().sync();
    } finally {
      eventLoopGroup.shutdownGracefully();
    }
  }
}
