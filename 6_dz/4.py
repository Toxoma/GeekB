# Реализуйте RLE алгоритм: реализуйте модуль сжатия и восстановления данных.

import re 
import os
os.chdir('./2_Python/6_dz')

# encode
with open('4.txt', 'r') as data1:
    with open('4-res.txt', 'w') as data2:
        for line in data1:
            result = line
            mas = []
            length = 0
            myset = set([char for char in line if char != '\n'])
            for x in myset:
                mas += re.findall(rf'{x}+', line)
            for x in mas:
                length = len(x)
                if length>1:
                    result = re.sub(x, str(length)+x[0], result)
            data2.write(result)

# decode
with open('4-res.txt', 'r') as data1:
    with open('4-res-decode.txt', 'w') as data2:
        for line in data1:
            result = line
            mas = re.findall(r'\d+[a-zA-Z]', line)
            decodeLine = ''
            for x in mas:
                decodeLine = ''
                for y in range(int(x[:-1])):
                    decodeLine += x[-1]
                result = re.sub(x, decodeLine, result)
            data2.write(result)