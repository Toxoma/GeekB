# Задайте последовательность чисел. Напишите программу, которая выведет список неповторяющихся элементов исходной последовательности.

def proverka(listC):
    newList = set(listC)
    for item in newList.copy():
        if listC.count(item) > 1:
            newList.discard(item)
    print( list(newList) )

listC = [1,5,6,8,9,10,2,5,10,8]
proverka(listC)
