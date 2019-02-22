# -*- coding:utf-8 -*-
from thrift.protocol import TCompactProtocol
from thrift.server import TServer
from thrift.transport import TSocket, TTransport

from thrift import Thrift
from PersonServiceImpl import PersonServiceImpl
from py.thrift.generated import PersonService

__author__ = 'Missionary'
__time__ = '2019/2/22 0022 18:40'


try:
    personServiceHandler = PersonServiceImpl()
    processor = PersonService.Processor(personServiceHandler)

    serverSocket = TSocket.TServerSocket(host="localhost",port=8899)
    transportFactory = TTransport.TFramedTransportFactory()
    protocolFactory = TCompactProtocol.TCompactProtocolFactory()

    server = TServer.TSimpleServer(processor, serverSocket, transportFactory, protocolFactory)

    server.serve()

except Thrift.TException as ex:
    print("%s " % ex.message)
