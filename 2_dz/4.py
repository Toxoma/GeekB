# Задайте список из N элементов, заполненных числами из промежутка [-N, N]. Найдите произведение элементов на указанных позициях. Позиции хранятся в отдельном списке( пример n=4, lst1=[4,-2,1,3] - списко на основе n, а позиции элементов lst2=[3,1].
from random import randint
def vvodInt(msg):
    return int(input(msg))

def proverka(x, y):
    sum = 1
    for i in y:
        sum*= x[i]
    return sum

poisk = [3,1]
max = max([abs(i) for i in poisk])
x = 0 # наше n
while  x <= 0 or x>max:
    x = vvodInt(f'Введите число > 0 и < {max}: ')
    if x <= 0 or x>max:
        print('Вы ввели некорректное число')

mas = [randint(-x, x) for i in range(-x, x+1)]
print(f'{mas}')
print(f'{proverka(mas, poisk)}')


