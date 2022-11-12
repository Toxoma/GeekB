/* 
Задача 38: Задайте массив вещественных чисел. Найдите разницу между максимальным и минимальным элементов массива.

[3 7 22 2 78] -> 76
*/

int GetConsole(string msg, int x)
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

        if (int.TryParse(str, out int number) && number > x)
        {
            result = number;
            break;
        }
        else
        {
            LogWrong($"Нужно число > {x}.\n");
        }
    }

    return result;
}

(double[], int) InitArray()
{
    int length = GetConsole("Длина массива: ", 1);
    int dlina = GetConsole("Кол-во цифр после запятой: ", -1);
    double[] result = new double[length];
    Random rnd = new Random();
    double a;
    int b;

    for (int i = 0; i < result.Length; i++)
    {
        a = rnd.NextDouble();
        b = rnd.Next(-999, 1000);
        result[i] = Convert.ToDouble(Convert.ToString(b)+','+Convert.ToString(a).Substring(Convert.ToString(a).Length-dlina));
    }

    return (result, dlina);
}

(double, double[]) CountSum(double[] mas, int x)
{
    double min = mas[0];
    double max = mas[0];
    for (int i = 0; i < mas.Length; i++)
    {
        if(min > mas[i]) min = mas[i];
        if(max < mas[i]) max = mas[i];
    }
    Console.WriteLine(min + " -> min");
    Console.WriteLine(max + " -> max");
    return (Math.Round(max - min, x), mas);
}

void Vivod(double sum, double[] mas)
{
    Console.Write("[");
    for (int i = 0; i < mas.Length; i++)
    {
        if(i == mas.Length-1){
            Console.Write($"{mas[i]}] -> ");
            continue;
        }
        Console.Write($"{mas[i]}, ");
    }
    Console.Write($"{sum}");
}

var first = InitArray();
var second = CountSum(first.Item1, first.Item2);
Vivod(second.Item1, second.Item2);