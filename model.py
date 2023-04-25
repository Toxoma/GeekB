# -*- coding: utf-8 -*-
import csv
from time import gmtime, strftime
from datetime import datetime

fileBD = 'F:/GeekBrains/GeekBrains/2_Python/NotebookProject/GeekB/database.csv'

# Все записи в БД
def getAllNotes():
    with open(fileBD, 'r', newline='', encoding='utf-8') as data:
        reader = csv.reader(data, delimiter=';', quotechar=',',
                        quoting=csv.QUOTE_MINIMAL)
        mas = []
        for line in reader:
            mas.append(line)
        return sorted(mas)

# Поиск по id
def showById(id):
    if(checkExist(id)):
        mas = getAllNotes()
        for line in mas:
            if int(id) == int(line[0]):
                print('Информация о заметке:')
                print(f'Идентификатор: {line[0]}; Заголовок: {line[1]}; Описание: {line[2]}; Дата: {line[3]}')
                return

# добавление заметки
def addNote( data ):
    try:
        title, desc = data
        with open(fileBD, 'a+', newline='', encoding='utf-8') as csv:
            mas = getAllNotes()
            id = 1
            # тк массив отсортированный можно сразу брать последний элемент
            if (len(mas) > 0):
                id = int(mas[len(mas)-1][0]) + 1
            date = strftime("%Y-%m-%d %H:%M:%S", gmtime())
            note = f'{id};{title};{desc};{date}\n'
            csv.write(note)
            print('Заметка была добавлена!')
    except:
        print('Что-то пошло не так при добавлении заметки... Попробуйте снова!')

# удаление заметки
def removeNote(id):
    try:
        if(checkExist(id)):
            mas = getAllNotes()
            with open(fileBD, 'w', newline='', encoding='utf-8') as data:
                for line in mas:
                    if id != int(line[0]):
                        data.write(f'{line[0]};{line[1]};{line[2]};{line[3]}\n')
    except:
        print('Что-то пошло не так при удалении заметки... Попробуйте снова!')

def changeNote(id, data):
    try:
        mas = getAllNotes()
        title, desc = data
        with open(fileBD, 'w', newline='', encoding='utf-8') as csv:
            for line in mas:
                if id != int(line[0]):
                    csv.write(f'{line[0]};{line[1]};{line[2]};{line[3]}\n')
                else:
                    date = strftime("%Y-%m-%d %H:%M:%S", gmtime())
                    csv.write(f'{id};{title};{desc};{date}\n')
            print('Заметка была обновлена!')
    except:
        print('Что-то пошло не так при обновлении заметки... Попробуйте снова!')

def readAllBetweenDates(data):
    # try:
        dateStart, dateEnd = data
        mas = sorted(getAllNotes(), key=lambda item: item[3])
        idx = 0
        format = "%Y-%m-%d %H:%M:%S"
        for line in mas:
            if(
                datetime.strptime(line[3], format) >= dateStart and 
                datetime.strptime(line[3], format) <= dateEnd 
                ):
                if (idx == 0):
                    print()
                    print(f'Вывод заметок в интервале {dateStart} - {dateEnd}')
                idx = idx + 1
                print(f'{idx}) Идентификатор: {line[0]}; Заголовок: {line[1]}; Описание: {line[2]}; Дата: {line[3]}')
    # except:
    #     print(f'Что-то пошло не так при выводе заметок в интервале: {dateStartStr} - {dateEndStr}. Попробуйте снова!')

# _______________________________
# METHODS
def checkExist(id):
    try:
        for line in getAllNotes():
            if int(id) == int(line[0]):
                return True
        print(f'Заметки с индексом: {id} не было найдено в базе!!!\nПопробуйте ещё раз...')
        return False
    except:
        print('Что-то пошло не так при поиске в БД... Попробуйте снова!')
