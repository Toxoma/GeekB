# Создайте программу для игры в ""Крестики-нолики"".

pole = [1,2,3,
        4,5,6,
        7,8,9]

wins = [[0,1,2],
[3,4,5],
[6,7,8],
[0,3,6],
[1,4,7],
[2,5,8],
[0,4,8],
[2,4,6]]

def vivod():
    print(f'{pole[0]} {pole[1]} {pole[2]}')
    print(f'{pole[3]} {pole[4]} {pole[5]}')
    print(f'{pole[6]} {pole[7]} {pole[8]}')

def setStep(step,symbol):
    ind = pole.index(step)
    pole[ind] = symbol

def result():
    for i in wins:
        if pole[i[0]] == "X" and pole[i[1]] == "X" and pole[i[2]] == "X":
            return "Игрок 1 (X)"
        if pole[i[0]] == "O" and pole[i[1]] == "O" and pole[i[2]] == "O":
            return "Игрок 2 (O)"
    return ''

end = False
player = True # Игрок 1

while end == False:
    vivod()

    if player == True:
        setStep(int(input("Игрок 1, делает ход: ")),"X")
    else:
        setStep(int(input("Игрок 2, делает ход: ")),"O")

    win = result()
    if win != "":
        end = True

    player = not(player)

vivod()
print("Победил", win) 