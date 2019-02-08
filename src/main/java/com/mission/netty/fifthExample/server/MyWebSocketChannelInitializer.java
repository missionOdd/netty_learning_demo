package com.mission.netty.fifthExample.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author mission
 * @date 2019/2/8 0008-15:46
 */
public class MyWebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {
  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ChannelPipeline pipeline =ch.pipeline();
    pipeline.addLast(new HttpServerCodec())//http变译码器
        .addLast(new ChunkedWriteHandler())//以"块"来写处理器
        .addLast(new HttpObjectAggregator(8192))//将多个块或多个段进行聚合
        .addLast(new WebSocketServerProtocolHandler("/webs"))
        /*  /webs是协议路径
        一般websocket
        ws://server:port/context_path
        ws://localhost:8899/webs
         */
        .addLast(new MyWebServerHandler() );
  }
}
