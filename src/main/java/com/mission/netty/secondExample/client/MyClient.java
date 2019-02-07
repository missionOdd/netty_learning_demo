package com.mission.netty.secondExample.client;

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
     Bootstrap bootstrap=new Bootstrap();//这里是Bootstrap ,有别于ServerBootstrap
     bootstrap.group(eventLoopGroup)
         .channel(NioSocketChannel.class)//这里是NioSocketChannel,有别于NioServerSocketChannel
         .handler(new MyClientInitializer()) //线程处理,这里也可以使用childHandler
          ;

      ChannelFuture channelFuture =bootstrap.connect("localhost",8899).sync();
      channelFuture.channel().closeFuture().sync();
    } finally {
      eventLoopGroup.shutdownGracefully();
    }
  }
}
