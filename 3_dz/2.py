# Напишите программу, которая найдёт произведение пар чисел списка. Парой считаем первый и последний элемент, второй и предпоследний и т.д.
# Пример:
# - [2, 3, 4, 5, 6] => [12, 15, 16];
# - [2, 3, 5, 6] => [12, 15]
from math import ceil
def proverka(x):
    mas = []
    length = len(x) - 1
    for i in range(ceil(len(x)/2)):
        mas.append(x[i]*x[length-i])
    print(f' - {x} => {mas}')

x1 = [2, 3, 4, 5, 6]
x2 = [2, 3, 5, 6]

proverka(x1)
proverka(x2)

