# -*- coding: utf-8 -*-

# Создать телефонный справочник с возможностью импорта и экспорта данных в нескольких форматах.
# добавлять, удалять, конвертировать json/csv

import json, csv
import os
os.chdir('./2_Python/7_dz')

def start():
    msg = 'Если вы хотите добавить запись в файл введите\t1\nЕсли вы хотите удалить запись из файла введите\t2\nЕсли вы хотите конвертировать файл введите\t3\nВыход 0\n-->Ваш выбор: '
    x = chooseAction(msg, 4)
    if x == 0:
        return 0
    if x == 1:
        addLine()
    if x == 2:
        deleteLine()
    if x == 3:
        convertFile()
    start()

def chooseAction(msg, length = 0):
    try:
        x = int(input(msg))
        if x == 0:
            return 0
        if length != 0:
            if x not in range(1, length):
                print('\nВы ввели некорректное число! Повторите попытку.\n')
                return chooseAction(msg, length)
    except:
        print('\nВы пытались ввести не число! Повторите попытку.\n')
        return chooseAction(msg, length)
    return x

def addLine():
    with open('1.txt', 'a', encoding="utf-8") as data1:
        print('\nДобавление контакта в справочник!!!')
        phone = input('Введите номер телефона: ')
        fio = input('Введите ФИО: ')
        addr = input('Введите адресс: ')
        data1.write(f'\n{phone}/{fio}/{addr}')
    readFile()

def deleteLine():
    mas = readFile()
    with open('1.txt', 'w', encoding="utf-8") as data1:
        msg = 'Введите номер строки для удаления: '
        x = chooseAction(msg, len(mas)+1)
        for idx, line in enumerate(mas, 1):
            if idx == x: continue
            data1.write(line)

def readFile(name = '1.txt'):
    with open(name, 'r', encoding="utf-8") as data1:
        print()
        print('_____________')
        mas = []
        for idx, line in enumerate(data1, 1):
            print(f'{idx}. {line}')
            mas.append(line)
        print('_____________')
        print()
        return mas

def convertFile():
    def convertToJson():
        with open('1.json', 'w', encoding="utf-8") as data1:
            jsonStr = json.dumps(readFile(), ensure_ascii=False)
            data1.write(jsonStr)

    def convertToCsv():
        with open('1.csv', 'w') as data1:
            writer = csv.writer(data1)
            writer.writerow(['Phone', 'FIO', 'Address'])

            lines = [line.strip().split('/') for line in readFile()]
            for line in lines:
                writer.writerow(line)

    msg = '\nВыберите формат конвертации!\nВ json\t1\nВ csv\t2\n Ваш выбор: '
    x = chooseAction(msg, 3)
    if x == 1:
        convertToJson()
    if x == 2:
        convertToCsv()

start()