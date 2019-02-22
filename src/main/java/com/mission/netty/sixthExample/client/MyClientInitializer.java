package com.mission.netty.sixthExample.client;

import com.mission.netty.sixthExample.protobuf.MyDataInfo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * 初始化器
 * @author mission
 * @date 2019/1/24 0024-15:07
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ChannelPipeline pipeline =ch.pipeline();
    pipeline.addLast(new ProtobufVarint32FrameDecoder()) //译码
        .addLast(new ProtobufDecoder(MyDataInfo.Person.getDefaultInstance())) //译码
        .addLast(new ProtobufVarint32LengthFieldPrepender())
        .addLast(new ProtobufEncoder()) //编码

    .addLast(new MyClientHandler());
  }
}
