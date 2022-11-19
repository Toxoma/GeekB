/* 
Задача 52. Задайте двумерный массив из целых чисел. Найдите среднее арифметическое элементов в каждом столбце.

Например, задан массив:
1 4 7 2
5 9 2 3
8 4 2 4
Среднее арифметическое каждого столбца: 4,6; 5,6; 3,6; 3.
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

int[,] InitArray(int m, int n)
{
    int[,] arr = new int[m, n];
    Random rnd = new Random();
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            arr[i, j] = rnd.Next(0, 10);
        }
    }

    return arr;
}

double[] GetMid(int[,] arr)
{
    double[] result = new double[arr.GetLength(1)];
    for (int j = 0; j < arr.GetLength(1); j++)
    {
        result[j] = 0;
        for (int i = 0; i < arr.GetLength(0); i++)
        {
            result[j] += arr[i, j];
        }
        result[j] = Math.Round(result[j] / arr.GetLength(0), 2);
    }

    return result;
}

void Vivod(int[,] arr, double[] arrWithMid)
{
    int m = arr.GetLength(0);
    int n = arr.GetLength(1);
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (j != n - 1)
            {
                Console.Write($"{arr[i, j]} ");
            }
            else
            {
                Console.Write($"{arr[i, j]}\n");
            }
        }
    }

    n = arrWithMid.GetLength(0);
    Console.Write("Среднее арифметическое каждого столбца: ");
    for (int j = 0; j < n; j++)
    {
        if (j != n - 1)
        {
            Console.Write($"{arrWithMid[j]}; ");
        }
        else
        {
            Console.Write($"{arrWithMid[j]}.");
        }
    }
}

int[,] arr = InitArray(GetConsole("Введите кол-во строк: ", 0), GetConsole("Введите кол-во столбцов: ", 0));
double[] arrWithMid = GetMid(arr);
Vivod(arr, arrWithMid);
