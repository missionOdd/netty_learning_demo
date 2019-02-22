package com.mission.netty.seventhExample.server;

import com.mission.netty.seventhExample.thrift.PersonServiceImpl;
import com.mission.netty.seventhExample.thrift.generated.PersonService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @author mission
 * @date 2019/2/22 0022-8:26
 */
public class ThriftServer {

  public static void main(String[] args) throws TTransportException {

    TNonblockingServerSocket socket =new TNonblockingServerSocket(8899);
    THsHaServer.Args arg=new THsHaServer
        .Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
    PersonService.Processor<PersonServiceImpl> processor =new PersonService.Processor<>(new PersonServiceImpl());

    /*协议  压缩格式*/
    arg.protocolFactory(new TCompactProtocol.Factory());
    /*传输层  以frame为单位传输,并阻塞式服务中使用*/
    arg.transportFactory(new TFramedTransport.Factory());
    arg.processorFactory(new TProcessorFactory(processor));

    /*THsHa 引入线程池处理, 其模型把读写任务放到线程池去处理*/
    TServer server = new THsHaServer(arg);

    System.out.println("Server Started");

    /*死循环*/
    server.serve();
  }
}
