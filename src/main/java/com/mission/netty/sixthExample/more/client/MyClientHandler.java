package com.mission.netty.sixthExample.more.client;

import com.mission.netty.sixthExample.protobuf.DataSomeInfo;
import com.mission.netty.sixthExample.protobuf.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

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
    int random =new  Random().nextInt(3)+1;

    DataSomeInfo.MyMessage myMessage =null;
    if (0 ==random){
      /*选择Person*/
       myMessage =DataSomeInfo.MyMessage.newBuilder().setDataType(DataSomeInfo.MyMessage.DataType.PersonType)
          .setPerson(

              DataSomeInfo.Person.newBuilder()
                  .setName("人")
                  .setAge(11)
                  .setAddress("上海")
                  .build()

          ).build();
    }else if (1==random){

      myMessage =DataSomeInfo.MyMessage.newBuilder().setDataType(DataSomeInfo.MyMessage.DataType.DogType)
          .setDog(

              DataSomeInfo.Dog.newBuilder()
                  .setName("狗")
                  .setAge(11)
                  .build()

          ).build();

    }else {

      myMessage =DataSomeInfo.MyMessage.newBuilder().setDataType(DataSomeInfo.MyMessage.DataType.CatType)
          .setCat(

              DataSomeInfo.Cat.newBuilder()
                  .setName("猫")
                  .setAddress("屋子")
                  .build()

          ).build();
    }


    ctx.channel().writeAndFlush(myMessage);
  }
}
