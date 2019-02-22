package com.mission.netty.sixthExample.more.server;

import com.mission.netty.sixthExample.protobuf.DataSomeInfo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * @author mission
 * @date 2019/2/21 0021-16:48
 */

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {


  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ChannelPipeline pipeline =ch.pipeline();
    pipeline.addLast(new ProtobufVarint32FrameDecoder()) //译码
             .addLast(new ProtobufDecoder(DataSomeInfo.MyMessage.getDefaultInstance())) //译码 实现多选一
            .addLast(new ProtobufVarint32LengthFieldPrepender())
            .addLast(new ProtobufEncoder()) //编码

            .addLast(new MyServerHandler());

  }
}
