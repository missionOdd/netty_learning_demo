package com.mission.netty.secondExample.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * 处理器
 * @author mission
 * @date 2019/1/24 0024-15:13
 */
public class MyClientHandler extends SimpleChannelInboundHandler<String> {
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    System.out.println(ctx.channel().remoteAddress());
    System.out.println("client output :"+msg);
    ctx.writeAndFlush("from client :"+ LocalDateTime.now());
  }

  /**
   * 处理异常
   * @param ctx
   * @param cause
   * @throws Exception
   */
  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    ctx.writeAndFlush("来自客户的问候!!");
  }
}
