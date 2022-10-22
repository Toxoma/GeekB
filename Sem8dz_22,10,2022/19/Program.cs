/* 
Задача 19

Напишите программу, которая принимает на вход пятизначное число и проверяет, является ли оно палиндромом.

14212 -> нет

12821 -> да

23432 -> да
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

        string str = Console.ReadLine();

        if (int.TryParse(str, out int number))
        {
            if (number < 0 && str.Length == 6 || number > 0 && str.Length == 5)
            {
                result = number;
                break;
            }
            LogWrong("Введённая длина не 5! Повторите ввод.\n");
            continue;
        }
        else
        {
            LogWrong("Ввели некорректное число! Повторите ввод.\n");
        }
    }

    return result;
}

void IsPoilynom(int x)
{
    int Reverse(int x)
    {

        bool hasMinus = x < 0;
        int length = hasMinus ? x.ToString().Length - 1 : x.ToString().Length;
        string result = hasMinus ? "-" : "";

        if (hasMinus) x *= -1;

        for (int i = 1; i <= length; i++)
        {
            result += x % 10;
            x = x / 10;
        }

        return int.Parse(result);
    }

    if (x == Reverse(x))
    {
        Console.WriteLine("да");
    }
    else
    {
        Console.WriteLine("нет");
    }
}

int x = GetConsole("Введите пятизначное число: ");
IsPoilynom(x);