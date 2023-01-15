# -*- coding: utf-8 -*-

# Напишите программу, удаляющую из текста все слова, содержащие ""абв"".

import os
os.chdir('./2_Python/6_dz')

with open('1.txt', 'r', encoding="utf-8") as data1:
    with open('1-res.txt', 'w', encoding="utf-8") as data2:
        mas = []
        for line in data1:
            mas += list(line.split())
        mas = ' '.join(list(filter(lambda x: "абв" not in x, mas)))
        data2.write(mas)