/* 
Задача 66: Задайте значения M и N. Напишите программу, которая найдёт сумму натуральных элементов в промежутке от M до N.

M = 1; N = 15 -> 120
M = 4; N = 8. -> 30
*/

int GetConsole(string msg, int x = -1)
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

        if (int.TryParse(str, out int number) && number > 0)
        {
            if (x != -1)
            {
                if (number != x)
                {
                    result = number;
                    break;
                }
                else
                {
                    LogWrong($"Нужно натуральное число не совпадающее с {x}.\n");
                }
            }
            else
            {
                result = number;
                break;
            }
        }
        else
        {
            LogWrong($"Нужно натуральное число.\n");
        }
    }

    return result;
}

int GetSumm(int m, int n)
{
    int result = 0;

    void Rekursia(int m, int n)
    {
        result += m;

        if (m > n)
            m--;
        else if (m < n)
            m++;
        else
            return;

        Rekursia(m, n);
    }
    Rekursia(m, n);

    return result;
}

int m = GetConsole("Введите число m: ");
int n = GetConsole("Введите число n: ", m);
int sum = GetSumm(m, n);
Console.WriteLine($"M = {m}; N = {n} -> {sum}");
