# Напишите программу, которая принимает на вход координаты двух точек и находит расстояние между ними в 2D пространстве.
# Пример:
# - A (3,6); B (2,1) -> 5,09
# - A (7,-5); B (1,-1) -> 7,21

from collections import namedtuple
from math import sqrt

def vvodFloat(msg):
    return round(float(input(msg)))

def proverka(pt1, pt2):
    return sqrt((pt1.x - pt2.x)**2 + (pt1.y - pt2.y)**2)

Point = namedtuple('Point' , 'x y')
pt1 = Point(vvodFloat('Введите x1: '), vvodFloat('Введите y1: '))
pt2 = Point(vvodFloat('Введите x2: '), vvodFloat('Введите y2: '))

length = round(proverka(pt1, pt2), 2)
print(f' - A ({pt1.x},{pt1.y}); B ({pt2.x},{pt2.y}) -> {length}')