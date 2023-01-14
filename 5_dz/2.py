# Создайте программу для игры с конфетами человек против человека.

# Условие задачи: На столе лежит 2021 конфета. Играют два игрока делая ход друг после друга. Первый ход определяется жеребьёвкой. За один ход можно забрать не более чем 28 конфет. Все конфеты оппонента достаются сделавшему последний ход. Сколько конфет нужно взять первому игроку, чтобы забрать все конфеты у своего конкурента?

# a) Добавьте игру против бота

# b) Подумайте как наделить бота ""интеллектом""

import random

candies = 51 # 2021
max = 28
currentPlayer = random.randint(1, 2) # 1 - игрок, 2 - комп

def playerMove():
    global candies
    y = False
    while not y:
        move = input('Возьми не больше 28 конфет: ')
        try:
            move = int(move)
            if move > 0 and move <= max and move <= candies:
                print(f'Игрок взял {move} конфет')
                candies -= move
                print(f'Осталось {candies} конфет')
                y = True
            else:
                print(f'Некорректный ввод, нужно число от 1 до 28 и <= {candies}')
        except:
            print('Необходимо ввести целое число.')

def compMove():
    global candies
    move = random.randint(1, max) if candies >= max else random.randint(1, candies)
    print(f'Комп забрал {move} конфет')
    candies -= move
    print(f'Осталось {candies} конфет')

def smartCompMove():
    global candies, smart
    move = candies % (max + 1)
    if move == 0:
        move = random.randint(1, max) if candies >= max else candies
    print(f'Бот забрал {move} конфет')
    candies -= move
    print(f'Осталось {candies} конфет')

print(f'Всего конфет {candies}')
if (currentPlayer == 1):
    print(f'Первым ходит игрок')
else:
    print(f'Первым ходит комп')

while (candies > 0):
    if (currentPlayer == 1):
        playerMove()
        currentPlayer = 2
    else:
        compMove() # задача а
        # smartCompMove()  # задача б
        currentPlayer = 1

print(f'Победил {"игрок" if currentPlayer == 2 else "комп"}!!!')