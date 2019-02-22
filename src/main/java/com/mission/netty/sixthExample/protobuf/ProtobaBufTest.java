package com.mission.netty.sixthExample.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author mission
 * @date 2019/2/21 0021-16:32
 */
public class ProtobaBufTest {

  public static void main(String[] args) throws InvalidProtocolBufferException {
    //ProtobaBuf EXample

    //A机器
    /*创建实体*/
    MyDataInfo.Person person =MyDataInfo.Person.newBuilder().setName("张三").setAge(20).setAddress("广东").build();

    /*转换为字符数组*/
    byte[] student2ByteArray =person.toByteArray();

    //student2ByteArray 字符数组 网络传输TODO

    //B机器
    /*接收字符数组*/
    MyDataInfo.Person person1 =MyDataInfo.Person.parseFrom(student2ByteArray);

    System.out.println(person1.getName());
    System.out.println(person1.getAge());
    System.out.println(person1.getAddress());
  }
}
