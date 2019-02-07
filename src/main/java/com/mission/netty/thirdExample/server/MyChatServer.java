package com.mission.netty.thirdExample.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.io.IOException;

/**
 * @author mission
 * @date 2019/2/4 0004-17:26
 */
public class MyChatServer {

  public static void main(String[] args) throws InterruptedException, IOException {
    EventLoopGroup bossGroup =new NioEventLoopGroup();
    EventLoopGroup workerGroup =new NioEventLoopGroup();

    try {
      ServerBootstrap serverBootstrap =new ServerBootstrap();
      serverBootstrap.group(bossGroup,workerGroup)
          .channel(NioServerSocketChannel.class)
          .childHandler(new MyChatServetInitializer());
      ChannelFuture channelFuture =serverBootstrap.bind(8899).sync();
      channelFuture.channel().closeFuture().sync();
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }
}
