package com.mission.netty.secondExample.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author mission
 * @date 2019/1/24 0024-14:43
 */
public class MyServer {

  public static void main(String[] args) throws InterruptedException {
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      ServerBootstrap serverBootstrap =new ServerBootstrap();
      serverBootstrap.group(bossGroup,workerGroup)
          .channel(NioServerSocketChannel.class)
          .childHandler(null);
      ChannelFuture channelFuture =serverBootstrap.bind(8899).sync();
      channelFuture.channel().close();
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }


  }
}
