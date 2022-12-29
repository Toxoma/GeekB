# Напишите программу, которая будет преобразовывать десятичное число в двоичное.
# Пример:
# - 45 -> 101101
# - 3 -> 11
# - 2 -> 10

def proverka(x):
    dvoika = ''
    while x//2 > 0:
        dvoika = str(x%2) + dvoika
        x = x//2
    dvoika = '1' + dvoika
    print(f' - {x} -> {int(dvoika)}')

x1 = 45
x2 = 3
x3 = 2

proverka(x1)
proverka(x2)
proverka(x3)


