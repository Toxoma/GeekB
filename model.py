# -*- coding: utf-8 -*-
import csv
import view
import controller as c

# Все записи в БД
def getAllNotes():
    with open('database.csv', 'r', newline='', encoding='utf-8') as data:
        reader = csv.reader(data, delimiter=';', quotechar=',',
                        quoting=csv.QUOTE_MINIMAL)
        mas = []
        for line in reader:
            mas.append(line)
        return mas


# __________________

def showError(id):
    print(f'Индекс {id} не был найден в базе!!!\nПопробуйте ещё раз...')



# def newPerson(userData):
#     surname, name, role, phone, money = userData
#     with open('database.csv', 'a+', newline='', encoding='utf-8') as data:
#         id = 1
#         for line in getDataBase():
#             innerId = int(line.split(';')[0])
#             if innerId >= id:
#                 id = innerId + 1
            
#         member = f'{id};{surname};{name};{role};{phone};{money};\n'
#         data.write(member)

def deletePerson(userData):
    id, mas = userData
    err = True
    with open('database.csv', 'w', newline='', encoding='utf-8') as data:
        for line in mas:
            if int(id) != int(line.split(';')[0]): 
                data.write(line)
            else:
                err = False
    if err:
        showError(id)

def findPerson(id):
    err = True
    with open('database.csv', 'r', newline='', encoding='utf-8') as data:
        for line in data:
            if int(id) == int(line.split(';')[0]):
                print('Данные о пользователе:')
                print(line.strip())
                err = False
    if err:
        showError(id)

def updatePerson(userData):
    err = True
    id, mas = userData
    surname, name, role, phone, money = view.addNewPerson()
    with open('database.csv', 'w', newline='', encoding='utf-8') as data:
        for line in mas:
            if int(id) != int(line.split(';')[0]): 
                data.write(line)
            else:
                data.write(f'{id};{surname};{name};{role};{phone};{money};\n')
                err = False
    if err:
        showError(id)

def getRoles():
    roles = set()
    for line in getDataBase():
        roles.add(line.split(';')[3])
    return list(roles)

# def showRoles(roles=getRoles()):
#     print()
#     print('Имеющиеся должности:')
#     for idx,line in enumerate(roles, 1):
#         print(f'{idx}. {line.strip()}')
#     print('__________________')

def sortRole(role):
    print()
    print('Отфильтрованные сотрудники:')
    for line in getDataBase():
        if line.split(';')[3] == role:
            print(line.strip())