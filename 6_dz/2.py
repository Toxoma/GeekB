# Создайте программу для игры с конфетами человек против человека.

# Условие задачи: На столе лежит 2021 конфета. Играют два игрока делая ход друг после друга. Первый ход определяется жеребьёвкой. За один ход можно забрать не более чем 28 конфет. Все конфеты оппонента достаются сделавшему последний ход. Сколько конфет нужно взять первому игроку, чтобы забрать все конфеты у своего конкурента?

# a) Добавьте игру против бота

# b) Подумайте как наделить бота ""интеллектом""

import random

candies = 51 # 2021
max = 28
maxPlayers = 2
currentPlayer = random.randint(1, maxPlayers) # 1 - игрок, 2 - комп, .... дальше компы

def switchPlayer():
    global currentPlayer
    currentPlayer = currentPlayer + 1 if currentPlayer + 1 <= maxPlayers else 1

def playerMove():
    global candies
    canTake = lambda: max if candies >= max else candies
    y = False
    while not y:
        move = input(f'Возьми не больше {canTake()} конфет: ')
        try:
            move = int(move)
            if move > 0 and move <= max and move <= candies:
                print(f'Игрок взял {move} конфет')
                candies -= move
                print(f'Осталось {candies} конфет')
                y = True
            else:
                print(f'Некорректный ввод, нужно число от 1 до {canTake()}')
        except:
            print('Необходимо ввести целое число.')

def compMove():
    global candies
    move = random.randint(1, max) if candies >= max else random.randint(1, candies)
    print(f'Комп{currentPlayer} забрал {move} конфет')
    candies -= move
    print(f'Осталось {candies} конфет')

def smartCompMove():
    global candies
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
    print(f'Первым ходит комп{currentPlayer}')

while (candies > 0):
    playerMove() if currentPlayer == 1 else compMove()
    # playerMove() if currentPlayer == 1 else smartCompMove()
    switchPlayer()

print(f'Победил {"игрок" if currentPlayer == 2 else "комп"+str(currentPlayer)}!!!')