package com.mission.netty.eighthExample.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author mission
 * @date 2019/2/23 0023-16:06
 */
public class GrpcServer {

  private Server server;

  private void start() throws IOException {
    //ServerBuilder or NettyServerBuilder
    this.server = ServerBuilder.forPort(8899)
      .addService(new StudentServiceImpl())
      .build().start();

    System.out.println("server started!!!");

    /*回调钩子*/
    Runtime.getRuntime().addShutdownHook(new Thread(()->{
      System.out.println("关闭jvm");

      GrpcServer.this.stop();

    })
    );

    System.out.println("server go here!!!");
  }

  private void stop(){
    if (null!=this.server){
      this.server.shutdown();
    }
  }

  /**
   * 使服务器阻塞,避免服务器启动后立马退出
   * @throws InterruptedException
   */
  private void awaitTermination() throws InterruptedException {
    if (null!=this.server){
      this.server.awaitTermination(1, TimeUnit.HOURS);
    }
  }
  public static void main(String[] args) throws IOException, InterruptedException {
    GrpcServer server= new GrpcServer();
    server.start();
    server.awaitTermination();

  }
}
