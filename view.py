# -*- coding: utf-8 -*-
from datetime import datetime
from time import gmtime, strftime

def showMenu(options):
    print()
    print('Выберите необходимое действие')
    for idx, option in enumerate(options):
        print(f'{idx}. {option["name"]}')
    print()
    return chooseAction('Введите номер необходимого действия: ', len(options))

def showAll(mas):
    print()
    print('Все заметки:')
    for idx, line in enumerate(mas):
        print(f'{idx+1}) Идентификатор: {line[0]}; Заголовок: {line[1]}; Описание: {line[2]}; Дата: {line[3]}')
    print('__________________')

def showById():
    try:
        print()
        x = int(input('Введите идентификатор заметки: '))
        print()
        return x
    except:
        print()
        print('Вы пытались ввести не число! Повторите попытку.')
        return showById()
    
def addNote():
    print()
    print('Создане заметки...')
    title = input('Введите заголовок: ')
    desc = input('Введите описание: ')
    return title, desc

def removeNote():
    try:
        print()
        x = int(input('Введите идентификатор заметки для удаления: '))
        print()
        return x
    except:
        print()
        print('Вы пытались ввести не число! Повторите попытку.')
        return removeNote()

def changeNote():
    try:
        print()
        x = int(input('Введите идентификатор заметки для изменения: '))
        print()
        return x
    except:
        print()
        print('Вы пытались ввести не число! Повторите попытку.')
        return changeNote()
    
def changeNoteData():
    print('Изменение заметки...')
    title = input('Введите заголовок: ')
    desc = input('Введите описание: ')
    return title, desc

def readAllBetweenDates():
    try:
        format = "%Y-%m-%d %H:%M:%S"
        now = strftime("%Y-%m-%d %H:%M:%S", gmtime())
        dateStart = datetime.strptime(input(f'Введите дату начала (в следубщем формате {now}): '), format)
        dateEnd = datetime.strptime(input(f'Введите дату конца (в следубщем формате {now}): '), format)
        return dateStart, dateEnd
    except:
        print()
        print('Введена дата неверного формата! Повторите попытку.')
        print()
        return readAllBetweenDates()

def chooseAction(msg, length='', start = 0):
    try:
        x = int(input(msg))
        if length != '' and x not in range(start, length):
                print()
                print('Вы ввели некорректное число! Повторите попытку.')
                print()
                return chooseAction(msg, length, start)
    except:
        print()
        print('Вы пытались ввести не число! Повторите попытку.')
        print()
        return chooseAction(msg, length, start)
    return x