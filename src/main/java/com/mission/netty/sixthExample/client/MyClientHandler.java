package com.mission.netty.sixthExample.client;

import com.mission.netty.sixthExample.protobuf.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 处理器
 * @author mission
 * @date 2019/1/24 0024-15:13
 */
public class MyClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Person msg) throws Exception {

  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    MyDataInfo.Person person =MyDataInfo.Person.newBuilder().setName("狗子").setAge(20).setAddress("广东").build();

    ctx.channel().writeAndFlush(person);
  }
}
