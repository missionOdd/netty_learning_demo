package com.mission.netty.secondExample.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @author mission
 * @date 2019/1/24 0024-14:53
 */
public class MyServerHandler extends SimpleChannelInboundHandler<String> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    System.out.println(ctx.channel().remoteAddress()+","+msg);

    //输出并把缓冲内容推出
    ctx.channel().writeAndFlush("form server"+ UUID.randomUUID());
  }


  /**
   * 如果出现异常
   * @param ctx
   * @param cause
   * @throws Exception
   */
  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
