/* 
Задача 21

Напишите программу, которая принимает на вход координаты двух точек и находит расстояние между ними в 3D пространстве.

A (3,6,8); B (2,1,-7), -> 15.84

A (7,-5, 0); B (1,-1,9) -> 11.53
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

        string str = Console.ReadLine();

        if (double.TryParse(str, out double number))
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

void GetDistance(double x1, double y1, double z1, double x2, double y2, double z2)
{
    Console.WriteLine(Math.Round(Math.Sqrt(Math.Pow((x1 - x2), 2) + Math.Pow((y1 - y2), 2) + Math.Pow((z1 - z2), 2)), 2));
}

double x1 = GetConsole("Введите координату x1: ");
double y1 = GetConsole("Введите координату y1: ");
double z1 = GetConsole("Введите координату z1: ");
double x2 = GetConsole("Введите координату x2: ");
double y2 = GetConsole("Введите координату y2: ");
double z2 = GetConsole("Введите координату z2: ");
GetDistance(x1, y1, z1, x2, y2, z2);