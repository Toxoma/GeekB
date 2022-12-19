# Реализуйте алгоритм перемешивания списка. (рандомно поменять местами элементы списка между собой)
from random import randint
def Peremeshat(x):
    mas = [i for i in x]
    y = None
    r = None
    for i in range(len(mas)):
        r = randint(0, len(mas)-1)
        y = mas[r]
        mas[r] = mas[i]
        mas[i] = y
    return mas

x = [1,2,3,4,5,6,7,8,9,10]
x2 = Peremeshat(x)
print(f'{x}')
print(f'{x2}')

