/* 
Задача 27: Напишите программу, которая принимает на вход число и выдаёт сумму цифр в числе.

452 -> 11

82 -> 10

9012 -> 12
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

        if (int.TryParse(str, out int number) && number > 0)
        {
            result = number;
            break;
        }
        else
        {
            LogWrong("Ввели некорректное число! Повторите ввод.\n");
        }
    }

    return result;
}

void MakeSum(int x)
{
    int result = 0;
    int _x = x;

    for (int i = 0; i < x.ToString().Length; i++)
    {
        result += _x % 10;
        _x /= 10;
    }

    Console.WriteLine(result);
}

int x = GetConsole("Введите число > 0: ");
MakeSum(x);