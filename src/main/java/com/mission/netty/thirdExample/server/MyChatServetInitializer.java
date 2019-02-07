package com.mission.netty.thirdExample.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author mission
 * @date 2019/2/4 0004-17:31
 */
public class MyChatServetInitializer extends ChannelInitializer<SocketChannel> {
  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ChannelPipeline channelPipeline =ch.pipeline();
    channelPipeline.addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()))
        .addLast(new StringDecoder(CharsetUtil.UTF_8))
        .addLast(new StringEncoder(CharsetUtil.UTF_8))
        .addLast(new MyChatServerHandler());
  }


}
