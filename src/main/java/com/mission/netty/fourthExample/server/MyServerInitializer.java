package com.mission.netty.fourthExample.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author mission
 * @date 2019/1/24 0024-14:48
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ChannelPipeline pipeline =ch.pipeline();
    pipeline.addLast(new IdleStateHandler(5,7,10, TimeUnit.SECONDS))
        /*空闲状态检测处理器
         readerIdleTime：每隔多少时间检测读
         writerIdleTime：每隔多少时间检测写
           allIdleTime：每隔多少时间检测读或写
             unit：时间单位
             */
        .addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4))
    .addLast(new LengthFieldPrepender(4))
   .addLast(new StringDecoder(CharsetUtil.UTF_8))
    .addLast(new StringEncoder(CharsetUtil.UTF_8))
    .addLast(new MyServerHandler());
  }
}
