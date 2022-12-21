# Задайте список из нескольких чисел. Напишите программу, которая найдёт сумму элементов списка, стоящих на нечётной позиции.
# Пример:
# - [2, 3, 5, 9, 3] -> на нечётных позициях элементы 3 и 9, ответ: 12

def proverka(x):
    sum = 0
    for i in range(1, len(x), 2):
        sum+=x[i]
    print(f' - {x} -> ответ: {sum}')

x = [2, 3, 5, 9, 3]
proverka(x)