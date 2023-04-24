# -*- coding: utf-8 -*-
import controller as c
import model

def showMenu(options):
    print()
    print('Выберите необходимое действие')
    for idx, option in enumerate(options):
        print(f'{idx}. {option["name"]}')
    print()
    return c.chooseAction('Введите номер необходимого действия: ', len(options))

def showAll(mas):
    print()
    print('Все заметки:')
    for idx, line in enumerate(mas):
        print(f'{idx+1}) Идентификатор: {line[0]}; Заголовок: {line[1]}; Описание: {line[2]}; Дата: {line[3]}')
    print('__________________')

# ____________________________________


def addNewPerson():
    surname = input('Surname: ')
    name = input('Name: ')
    role = input('Role: ')
    phone = input('Phone: ')
    money = input('Money: ')
    
    return surname, name, role, phone, money

def deletePerson():
    mas = model.getDataBase()
    model.showDataBase(mas)
    return c.chooseAction('Выберите пункт для удаления: ', start=1), mas

def findPerson():
    mas = model.getDataBase()
    model.showDataBase(mas)
    return c.chooseAction('Выберите пункт для отображения: ', start=1)

def updatePerson():
    mas = model.getDataBase()
    model.showDataBase(mas)
    return c.chooseAction('Выберите пункт для обновления данных: ', start=1), mas

def exportJson():
    return input('Введите названия файла для экспорта: ')

def exportCsv():
    x = input('Введите названия файла для экспорта: ')
    if x == 'database':
        print('Название не должно совпадать с названием базы данных!!!\nПопробуйте снова...')
        return exportJson()
    return x

def sortRole():
    roles = model.getRoles()
    model.showRoles(roles)
    return roles[c.chooseAction('Выберите номер должности для отображения списка: ', len(roles) + 1) - 1]

def sortMoney():
    print()
    print('1. Сумма больше или равна заданной')
    print('2. Сумма меньше или равна заданной')
    print('3. Сумма в промежутке')

    rule = c.chooseAction('Выберите правило для фильтрации: ', 4, 1)
    if rule == 3:
        sumStart = c.inputFloat('Введите начало промежутка: ', 0)
        sumEnd =  c.inputFloat('Введите конец промежутка: ', sumStart)
        return rule, sumStart, sumEnd
    return rule, c.inputFloat('Введите заданную сумму: ', 0), ''