/* 
Задача 25: Напишите цикл, который принимает на вход два числа (A и B) и возводит число A в натуральную степень B.

3, 5 -> 243 (3⁵)

2, 4 -> 16
*/
double GetConsole(string msg, bool notNull = false)
{
    double result;

    while (true)
    {
        void LogWrong(string err)
        {
            Console.WriteLine(err);
        }

        Console.Write(msg);

        string str = Console.ReadLine() ?? "";

        if (double.TryParse(str, out double number))
        {
            if (notNull && number == 0)
            {
                LogWrong("Введите число != 0! Повторите ввод.\n");
                continue;
            }

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

void MakeDegree(double x, double y)
{
    Console.WriteLine(Math.Pow(x, y));
}

double x = GetConsole("Введите число != 0: ", true);
double y = GetConsole("Введите степень: ");
MakeDegree(x, y);