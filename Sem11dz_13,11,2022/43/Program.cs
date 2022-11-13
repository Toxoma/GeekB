/* 
Задача 43: Напишите программу, которая найдёт точку пересечения двух прямых, заданных уравнениями y = k1 * x + b1, y = k2 * x + b2; значения b1, k1, b2 и k2 задаются пользователем.

b1 = 2, k1 = 5, b2 = 4, k2 = 9 -> (-0,5; -0,5)
*/

double GetConsole(string msg)
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
            result = number;
            break;
        }
        else
        {
            LogWrong($"Нужно число.\n");
        }
    }

    return result;
}

(double, double) GetLine(string msg1, string msg2)
{
    return (GetConsole(msg1), GetConsole(msg2));
}

(double x, double y) Find((double b, double k)line1, (double b, double k)line2)
{
    double x = Math.Round(((line2.b - line1.b)/(line1.k - line2.k)), 2);
    double y = Math.Round(line1.k*x+line1.b, 2);
    return (x,y);
}

var line1 = GetLine("Введите b1: ", "Введите k1: ");
var line2 = GetLine("Введите b2: ", "Введите k2: ");
var point = Find(line1, line2);
Console.Write($"({point.x}; {point.y})");
