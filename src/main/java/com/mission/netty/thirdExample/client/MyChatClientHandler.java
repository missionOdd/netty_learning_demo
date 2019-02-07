package com.mission.netty.thirdExample.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author mission
 * @date 2019/2/7 0007-14:25
 */
public class MyChatClientHandler extends SimpleChannelInboundHandler<String> {
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    System.out.println(msg);
  }

}
