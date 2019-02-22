package com.mission.netty.seventhExample.thrift;

import com.mission.netty.seventhExample.thrift.generated.DataException;
import com.mission.netty.seventhExample.thrift.generated.Person;
import com.mission.netty.seventhExample.thrift.generated.PersonService;
import org.apache.thrift.TException;

/**
 * @author mission
 * @date 2019/2/22 0022-8:20
 */
public class PersonServiceImpl implements PersonService.Iface {
  @Override
  public Person getPersonByUsername(String username) throws DataException, TException {
    System.out.println("Got Client Param:::"+ username);

    Person person =new Person();
    person.setUsername(username);
    person.setAge(20);
    person.setMarried(false);

    return person;
  }

  @Override
  public void savePerson(Person person) throws DataException, TException {
    System.out.println("Got Client Param: ");

    System.out.println(person.getUsername());
    System.out.println(person.getAge());
    System.out.println(person.isMarried());
  }
}
