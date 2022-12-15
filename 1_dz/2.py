# Напишите программу для. проверки истинности утверждения ¬(X ⋁ Y ⋁ Z) = ¬X ⋀ ¬Y ⋀ ¬Z (расшифровка этого выражения not (x[0] or x[1] or x[2] = not x[0] and not x[1] and not x[2]) для всех значений предикат.

def proverka():
    x = True
    y = True
    z = True
    
    if not(x or y or z) == (not x and not y and not z):
        print('правда')
    else:
        print('неправда')

proverka()

