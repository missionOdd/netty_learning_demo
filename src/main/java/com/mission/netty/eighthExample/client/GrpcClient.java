package com.mission.netty.eighthExample.client;

import com.mission.netty.eighthExample.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Iterator;

/**
 * @author mission
 * @date 2019/2/23 0023-16:13
 */
public class GrpcClient {

  public static void main(String[] args) throws InterruptedException {
    /*1.创建channel*/
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",8899)
      .usePlaintext(true)//无加密
      .build();

    /*2.获得stub装对象*/
    /*阻塞stub*/
    StudentServiceGrpc.StudentServiceBlockingStub blockingStub =StudentServiceGrpc.newBlockingStub(channel);

    /*非阻塞stub*/
    StudentServiceGrpc.StudentServiceStub stub =StudentServiceGrpc.newStub(channel);

    /*3.调用Service方法 ,异步*/

    MyResponse myResponse =null;

    long start= LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

    for (int i = 0; i < 11; i++) {
      myResponse =blockingStub.getRealNameByUsername(MyRequest.newBuilder().build().newBuilder().setUsername("刘强").build());
      System.out.println(myResponse.getRealname());
    }
    long end= LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

    System.out.println(end-start);

    System.out.println("----------------------------------");

    /*流返回的是迭代器*/
    new Thread(()->{
      Iterator<StudentResponse> studentresoponse =blockingStub.getStudentByAge(StudentRequest.newBuilder().setAge(21).build());

      studentresoponse.forEachRemaining(x-> System.out.println(x.getName()+","+x.getAge()+","+x.getCity()));
    }).start();


    System.out.println("----------------------------------");

    StreamObserver<StudentResponseList> studentResponseListStreamObserver = new StreamObserver<StudentResponseList>() {
      @Override
      public void onNext(StudentResponseList value) {
        value.getStudentResponseList().forEach(
          studentResponse -> {
            System.out.println(studentResponse.getName());
            System.out.println(studentResponse.getAge());
            System.out.println(studentResponse.getCity());
          }
        );
      }

      @Override
      public void onError(Throwable t) {
        System.out.println(t.getMessage());
      }

      @Override
      public void onCompleted() {
        System.out.println("completed!!!");
      }
    };
    /*流式请求一定是异步的stub ,返回的也是流*/
    StreamObserver<StudentRequest> studentRequestStreamObserver =stub.getStudentWrapperByAge(studentResponseListStreamObserver);

    studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(11).build());
    studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(13).build());
    studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(14).build());
    studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(16).build());
    studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(17).build());
    studentRequestStreamObserver.onCompleted();

    /*防止输出前关闭*/
    Thread.sleep(500000);

    System.out.println("----------------------------------");

    /*4.关闭channel*/
    channel.shutdown();
  }

}
