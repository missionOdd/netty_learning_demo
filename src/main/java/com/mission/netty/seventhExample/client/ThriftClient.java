package com.mission.netty.seventhExample.client;
import com.mission.netty.seventhExample.thrift.generated.Person;
import com.mission.netty.seventhExample.thrift.generated.PersonService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @author mission
 * @date 2019/2/22 0022-8:47
 */
public class ThriftClient {

  public static void main(String[] args) {
    TTransport transport =new TFastFramedTransport(new TSocket("localhost",8899),600);
    TProtocol protocol = new TCompactProtocol(transport);

    PersonService.Client client = new PersonService.Client(protocol);


    try {
      transport.open();
    } catch (TTransportException e) {
      e.printStackTrace();
    }
    try {
      Person person =client.getPersonByUsername("张三");
      System.out.println(person.toString());

      Person person1 =new Person();
      person1.setUsername("李四");
      person1.setUsernameIsSet(false);
      person1.setAge(23);

      person1.setMarried(true);

      client.savePerson(person);

    } catch (TException e) {
      e.printStackTrace();
    }
transport.close();

  }
}
