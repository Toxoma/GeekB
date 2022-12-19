# Напишите программу, которая принимает на вход вещественное число и показывает сумму его цифр.
# Пример:
# - 6782 -> 23
# - 0,56 -> 11

def vvodFloat(msg):
    return float(input(msg))

def proverka(x):
    sum = 0
    for i in str(x):
        if i == '.' or i =='-':
            continue
        sum+=int(i)
    return sum

x = None
while type(x) != float:
    x = vvodFloat('Введите число: ')
    if type(x) != float:
        print('Вы ввели некорректное число')

print(f' - {x} -> {proverka(x)}')

