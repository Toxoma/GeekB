# Задайте натуральное число N. Напишите программу, которая составит список простых множителей числа N.

def proverka():
    # N = int(input('Задайте натуральное число N: '))
    n = 1702
    if(n<1):
        print('Вы ввели неверное число, попробуйте ещё раз!')
        proverka()
        return
    print(n)

    prostie = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
    list = []

    def raz(n):
        if n == 1:
            return
        for item in prostie:
            if n%item == 0:
                list.append(item)
                n = n//item
                raz(n)
                return
        list.append(n)
    
    raz(n)
    print(list)

proverka()



