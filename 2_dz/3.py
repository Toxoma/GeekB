# Задайте список из n чисел последовательности (1+1/n)**n и выведите на экран их сумму.

def vvodInt(msg):
    return int(input(msg))

def proverka(x):
    sum = 0
    formula = (1+1/x)**x
    mas = [formula for i in range(x)]
    print(mas)
    for i in mas:
        sum+=i
    return sum

x = 0
while x < 1:
    x = vvodInt('Введите число > 0: ')
    if x < 1:
        print('Вы ввели некорректное число')

print(f'сумма = {proverka(x)}')

