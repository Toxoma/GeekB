/* 
Задача 64: Задайте значение N. Напишите программу, которая выведет все натуральные числа в промежутке от N до 1. Выполнить с помощью рекурсии.

N = 5 -> "5, 4, 3, 2, 1"
N = 8 -> "8, 7, 6, 5, 4, 3, 2, 1"
*/

int GetConsole(string msg)
{
    int result;

    while (true)
    {
        void LogWrong(string err)
        {
            Console.WriteLine(err);
        }

        Console.Write(msg);

        string str = Console.ReadLine() ?? "";

        if (int.TryParse(str, out int number) && number>0)
        {
            result = number;
            break;
        }
        else
        {
            LogWrong($"Нужно натуральное число.\n");
        }
    }

    return result;
}

// тут немного излишне т.к. не увидел что нужны ток натуральные
void Vivod(int x)
{
    void Rekursia(int y)
    {
        if(y == 1){
            Console.Write($"{y}\"");
            return;
        }
        Console.Write($"{y}, ");
        if (y > 1)
            y--;
        else
            y++;

        Rekursia(y);
    }

    Console.Write($"N = {x} -> \"");
    Rekursia(x);
}

int x = GetConsole("Введите число: ");
Vivod(x);