package com.mission.netty.thirdExample.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author mission
 * @date 2019/2/4 0004-17:36
 */
public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {

  private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    Channel channel =ctx.channel();

    //遍历,如果是别人,则发送消息,如果是自己,则显示自己的消息
    channelGroup.forEach(ch->{
      if (channel!=ch){
        ch.writeAndFlush(channel.remoteAddress()+" 发送的消息:"+msg+"\n");
      }else {
        ch.writeAndFlush("【自己】"+msg+"\n");
      }
    });
  }

  @Override
  public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
    //获得当前channel对象
    Channel channel =ctx.channel();
    //进行广播 ,遍历每一个channel
    channelGroup.writeAndFlush("【服务器】-"+ channel.remoteAddress()+ "加入\n");

    channelGroup.add(channel);

    channelGroup.writeAndFlush("【服务器】 当前人数："+ channelGroup.size()+"\n");

  }


  @Override
  public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    //获得当前channel对象
    Channel channel =ctx.channel();

    channelGroup.writeAndFlush("【服务器】-"+ channel.remoteAddress()+ " 离开\n");

    channelGroup.writeAndFlush("【服务器】 当前人数："+ channelGroup.size()+"\n");
    //断掉后会自动移除
    //channelGroup.remove(channel);
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    Channel channel =ctx.channel();
    System.out.println(channel.remoteAddress()+" 上线");
    System.out.println("【服务器】 当前人数："+ channelGroup.size());
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    Channel channel =ctx.channel();
    System.out.println(channel.remoteAddress()+" 下线");
    System.out.println("【服务器】 当前人数："+ channelGroup.size());
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
  //cause.printStackTrace();
  ctx.close();
  }


}
