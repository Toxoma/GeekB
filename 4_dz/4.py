# Задана натуральная степень k. Сформировать случайным образом список коэффициентов (значения от 0 до 100) многочлена и записать в файл многочлен степени k.

# Пример:

# - k=2 => 2*x² + 4*x + 5 = 0 или x² + 5 = 0 или 10*x² = 0

from random import randint

def proverka():
    k = int(input('Введите натуральное число: '))
    if k < 1:
        print('Это не натуральное число! Ещё раз...')
        proverka()
        return

    def rnd():
        return randint(0, 100)

    def nullkoef(x, msg='', sign=' + '):
        if x == 0:
            return ''
        else: 
            return sign+str(x)+msg

    x = rnd()
    with open('4.txt', 'w') as data:
        data.writelines(f'k={k} => {nullkoef(rnd(),"*x^"+str(k))}{nullkoef(rnd(),"*x")}{nullkoef(rnd())} = 0\n')
        data.writelines(f'k={k} =>  + x^{k}{nullkoef(rnd())} = 0\n')
        data.writelines(f'k={k} => {nullkoef(rnd(),"*x^"+str(k))} = 0')

proverka()

