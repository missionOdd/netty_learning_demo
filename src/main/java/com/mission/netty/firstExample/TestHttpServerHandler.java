package com.mission.netty.firstExample;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * 处理器
 * @author mission
 * @date 2019/1/24 0024-10:18
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
   if (msg instanceof HttpRequest) {
     System.out.println("执行了channelRead0");

     System.out.println(msg.getClass());

     System.out.println(ctx.channel().remoteAddress());

     Thread.sleep(3000);

     HttpRequest httpRequest =(HttpRequest)msg;
     System.out.println("请求方法名字:"+httpRequest.method().name());
     URI uri =new URI(httpRequest.uri());
     if ("/favicon.ico".equals(uri.getPath())){
       System.out.println("请求favicon.ico");
       return;
     }


     ByteBuf content = Unpooled.copiedBuffer("Hello world", CharsetUtil.UTF_8);

     FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
     response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
     response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

     ctx.writeAndFlush(response);
     ctx.channel().close();
   }
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    System.out.println("channel Active");
    super.channelActive(ctx);
  }

  @Override
  public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
    System.out.println("channel registered");
    super.channelRegistered(ctx);
  }

  @Override
  public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
    System.out.println("handler added");
    super.handlerAdded(ctx);
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    System.out.println("channel Inactive");
    super.channelInactive(ctx);
  }

  @Override
  public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
    System.out.println("channel unregistered");
    super.channelUnregistered(ctx);
  }
}
