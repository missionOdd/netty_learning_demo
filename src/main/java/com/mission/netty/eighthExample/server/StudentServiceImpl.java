package com.mission.netty.eighthExample.server;

import com.mission.netty.eighthExample.proto.*;
import io.grpc.stub.StreamObserver;

/**
 * @author mission
 * @date 2019/2/23 0023-15:52
 */
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase{

  /**
   * getRealNameByUsername
   * @param request 传递进来的信息
   * @param responseObserver 用于返回
   */
  @Override
  public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
    System.out.println("接受客户端信息:  "+ request.getUsername());

    //TODO处理逻辑

    //发送返回
    try {
      responseObserver.onNext(
        MyResponse.newBuilder().setRealname("张三丰").build()
      );

      //返回结束
      responseObserver.onCompleted();
    } catch (Exception e) {

      responseObserver.onError(new Exception("服务端发生错误"));
    }
  }

  @Override
  public void getStudentByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
    System.out.println("接受客户端信息:  "+ request.getAge());

    responseObserver.onNext(StudentResponse.newBuilder().setName("渣渣辉").setAge(21).setCity("香港").build());
    responseObserver.onNext(StudentResponse.newBuilder().setName("古天乐").setAge(22).setCity("香港").build());
    responseObserver.onNext(StudentResponse.newBuilder().setName("张学友").setAge(31).setCity("香港").build());
    responseObserver.onNext(StudentResponse.newBuilder().setName("周润发").setAge(41).setCity("香港").build());
  }

  @Override
  public StreamObserver<StudentRequest> getStudentWrapperByAge(StreamObserver<StudentResponseList> responseObserver) {

    System.out.println("接收客户端请求getStudentWrapperByAge ");
    /*返回流,并实现其中方法*/
    return new StreamObserver<StudentRequest>() {
      @Override
      public void onNext(StudentRequest value) {
        System.out.println("onNext"+value.getAge());
      }

      @Override
      public void onError(Throwable t) {
        System.out.println(t.getMessage());
      }

      @Override
      public void onCompleted() {
        StudentResponse studentResponse=StudentResponse.newBuilder().setName("赵火龙").setAge(23).setCity("深圳").build() ;
        StudentResponse studentResponse1=StudentResponse.newBuilder().setName("赵日天").setAge(24).setCity("深圳").build() ;

        StudentResponseList studentResponseList = StudentResponseList.newBuilder()
          .addStudentResponse(studentResponse).addStudentResponse(studentResponse1).build();

        responseObserver.onNext(studentResponseList);
        responseObserver.onCompleted();
      }
    };
  }
}
