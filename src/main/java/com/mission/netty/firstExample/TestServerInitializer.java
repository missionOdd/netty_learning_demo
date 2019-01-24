package com.mission.netty.firstExample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 初始化器
 * @author mission
 * @date 2019/1/24 0024-10:13
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {


  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    //管道,相当于拦截链
    ChannelPipeline pipeline =ch.pipeline();

    pipeline.addLast("httpServerCodec",new HttpServerCodec());
    pipeline.addLast("testHttpServerHandler",new TestHttpServerHandler());

  }
}
