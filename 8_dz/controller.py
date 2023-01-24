# -*- coding: utf-8 -*-
import view, model, json,csv

def chooseAction(msg, length='', start = 0):
    try:
        x = int(input(msg))
        if length != '' and x not in range(start, length):
                print('Вы ввели некорректное число! Повторите попытку.')
                return chooseAction(msg, length, start)
    except:
        print('Вы пытались ввести не число! Повторите попытку.')
        return chooseAction(msg, length, start)
    return x

def getAllData(data):
    mas = []
    print(data)
    for line in data:
        mas.append(line)
    return mas

def start():
    options = [exitProg, findMember,sortRole,sortMoney,addMember,deleteMember,updateMember,exportJson,exportCsv]
    return options[view.showMenu()]()

def findMember():
    model.findPerson(view.findPerson())
    return 1

def sortRole():
    model.sortRole(view.sortRole())
    return 1

def sortMoney():
    rule, sumStart, sumEnd = view.sortMoney()
    print()
    print('Отфильтрованные сотрудники:')
    if rule == 1:
        for line in model.getDataBase():
            if float(line.split(';')[5]) >= sumStart:
                print(line.strip())
    elif rule == 2:
        for line in model.getDataBase():
            if float(line.split(';')[5]) <= sumStart:
                print(line.strip())
    elif rule == 3:
        for line in model.getDataBase():
            if sumStart <= float(line.split(';')[5]) <= sumEnd:
                print(line.strip())
    return 1

def addMember():
    model.newPerson(view.addNewPerson())
    return 1

def deleteMember():
    model.deletePerson(view.deletePerson())
    return 1

def updateMember():
    model.updatePerson(view.updatePerson())
    return 1

def exportJson():
    fname = view.exportJson()
    mas = model.getDataBase()
    with open(f'{fname}.json', 'w', encoding="utf-8") as data:
            jsonStr = json.dumps(mas, ensure_ascii=False)
            data.write(jsonStr)
    return 1

def exportCsv():
    fname = view.exportCsv()
    mas = model.getDataBase()
    with open(f'{fname}.csv', 'w', encoding="utf-8") as data:
        for line in mas:
            data.write(line.strip()+'\n')
    return 1

def exitProg():
    return 0

def inputFloat(msg, min = '', max = ''):
    try:
        x = float(input(msg))
        if min != '' and x < min:
            print(f'Введено число меньше {min}, нужно больше!\nПопробуйте снова...')
            return inputFloat(msg, min, max)
        if max != '' and x > max:
            print(f'Введено число больше {max}, нужно меньше!\nПопробуйте снова...')
            return inputFloat(msg, min, max)
    except:
        print('Введено не число!\nПопробуйте снова...')
        return inputFloat(msg, min, max)
    return x