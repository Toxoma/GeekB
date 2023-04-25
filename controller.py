# -*- coding: utf-8 -*-
import view, model

def start():
    options = [
        {
            'name': 'Закончить работу',
            'func': exitProg,
        },
        {
            'name': 'Вывести все заметки',
            'func': showAll,
        },
        {
            'name': 'Вывести заметку по id',
            'func': showById,
        },
        {
            'name': 'Добавить заметку',
            'func': addNote,
        },
        {
            'name': 'Удалить заметку',
            'func': removeNote,
        },
        {
            'name': 'Изменить заметку',
            'func': changeNote,
        },
        {
            'name': 'Вывести все заметки в интервале',
            'func': readAllBetweenDates,
        },
    ]
    return options[view.showMenu(options)]['func']()

# OPTIONS
def exitProg():
    return 0

def showAll():
    view.showAll(model.getAllNotes())
    return 1

def showById():
    model.showById(view.showById())
    return 1

def addNote():
    model.addNote(view.addNote())
    return 1

def removeNote():
    model.removeNote(view.removeNote())
    return 1

def changeNote():
    id = view.changeNote()
    if(model.checkExist(id)):
        model.changeNote(id, view.changeNoteData())
    return 1

def readAllBetweenDates():
    model.readAllBetweenDates(view.readAllBetweenDates())
    return 1
