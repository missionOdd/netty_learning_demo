package com.mission.netty.sixthExample.server;

import com.mission.netty.sixthExample.protobuf.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author mission
 * @date 2019/2/21 0021-16:51
 */
public class MyServerHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {


  @Override
  protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Person msg) throws Exception {
    System.out.println(msg.getName());
    System.out.println(msg.getAge());
    System.out.println(msg.getAddress());
  }
}
