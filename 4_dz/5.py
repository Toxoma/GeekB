# Даны два файла, в каждом из которых находится запись многочлена. Задача - сформировать файл, содержащий сумму многочленов.

def vivod(data):
    for line in data:
        return line.split('=')[0].strip()

with open('5-result.txt', 'w') as dataRes:
    with open('5-1.txt', 'r') as data1:
        with open('5-2.txt', 'r') as data2:
            dataRes.write(f"{vivod(data1)} = {vivod(data2)}")