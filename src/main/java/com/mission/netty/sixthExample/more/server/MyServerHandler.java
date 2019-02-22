package com.mission.netty.sixthExample.more.server;

import com.mission.netty.sixthExample.protobuf.DataSomeInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author mission
 * @date 2019/2/21 0021-16:51
 */
public class MyServerHandler extends SimpleChannelInboundHandler<DataSomeInfo.MyMessage> {


  @Override
  protected void channelRead0(ChannelHandlerContext ctx, DataSomeInfo.MyMessage msg) throws Exception {
    DataSomeInfo.MyMessage.DataType  dataType=msg.getDataType();
    System.out.println(dataType);
    System.out.println(msg.toByteString().toString());
    if (dataType==DataSomeInfo.MyMessage.DataType.PersonType){
      DataSomeInfo.Person person =msg.getPerson();
      System.out.println(person.getName());
      System.out.println(person.getAge());
      System.out.println(person.getAddress());
    }else if (dataType==DataSomeInfo.MyMessage.DataType.DogType){
      DataSomeInfo.Dog dog =msg.getDog();
      System.out.println(dog.getName());
      System.out.println(dog.getAge());
    }else {
      DataSomeInfo.Cat cat =msg.getCat();
      System.out.println(cat.getName());
      System.out.println(cat.getAddress());
    }
  }

}
