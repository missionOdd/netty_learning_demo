# -*- coding:utf-8 -*-
from py.thrift.generated import ttypes

__author__ = 'Missionary'
__time__ = '2019/2/22 0022 17:29'

class PersonServiceImpl:

    def getPersonByUsername(self, username):
        print("Got client param: " + username)

        person = ttypes.Person()
        person.username = username
        person.age = 20
        person.married = False
        return person

    def savePerson(self, person):
        print('Got client param: ')
        print(person.username)
        print(person.age)
        print(person.married)
