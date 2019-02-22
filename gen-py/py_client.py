import sys
from importlib import reload

from thrift.protocol import TCompactProtocol

from py.thrift.generated import PersonService, ttypes

__author__ = '作者'

from thrift import Thrift
from thrift.transport import TSocket, TTransport

reload(sys)


try:
    tSocket = TSocket.TSocket("localhost", 8899)
    tSocket.setTimeout(600)
    transport = TTransport.TFramedTransport(tSocket)
    protocal = TCompactProtocol.TCompactProtocol(transport)
    client = PersonService.Client(protocal)
    transport.open()

    person = client.getPersonByUsername("哈哈")

    print(person.username)
    print(person.age)
    print(person.married)

    print('----------------')

    newPerson = ttypes.Person()
    newPerson.username = "李四"
    newPerson.age = 30
    newPerson.married = True

    client.savePerson(newPerson)

    transport.close()
except Thrift.TException as tx:
    print("%s" % tx.message)
