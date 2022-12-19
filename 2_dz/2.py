# Напишите программу, которая принимает на вход число N и выдает набор произведений чисел от 1 до N.
# Пример:
# - пусть N = 4, тогда [ 1, 2, 6, 24 ] (1, 1*2, 1*2*3, 1*2*3*4)

def vvodInt(msg):
    return int(input(msg))

def proverka(x):
    sum = 1
    for i in range(2, x+1):
        sum*= i
    return sum

x = 0
while x < 1:
    x = vvodInt('Введите число > 0: ')
    if x < 1:
        print('Вы ввели некорректное число')

print(f'{proverka(x)}')

