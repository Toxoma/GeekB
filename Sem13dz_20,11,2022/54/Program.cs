/* 
Задача 54: Задайте двумерный массив. Напишите программу, которая упорядочит по убыванию элементы каждой строки двумерного массива.
Например, задан массив:
1 4 7 2
5 9 2 3
8 4 2 4
В итоге получается вот такой массив:
7 4 2 1
9 5 3 2
8 4 4 2
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

void Vivod(int[,] arr, string msg = "")
{
    if (!string.IsNullOrEmpty(msg)) Console.Write($"{msg}");
    for (int i = 0; i < arr.GetLength(0); i++)
    {
        for (int j = 0; j < arr.GetLength(1); j++)
        {
            if (j != arr.GetLength(1) - 1)
            {
                Console.Write($"{arr[i, j]} ");
            }
            else
            {
                Console.Write($"{arr[i, j]}\n");
            }
        }
    }
}

void Sortirovka(int[,] arr)
{
    int x = 0;
    for (int stroka = 0; stroka < arr.GetLength(0); stroka++)
    {
        for (int i = 1; i < arr.GetLength(1); i++)
        {
            for (int j = 0; j < arr.GetLength(1) - i; j++)
            {
                if (arr[stroka, j] < arr[stroka, j+1])
                {
                    x = arr[stroka, j];
                    arr[stroka, j] = arr[stroka, j+1];
                    arr[stroka, j+1] = x;
                }
            }
        }

    }
}

int[,] arr = InitArray(GetConsole("Введите кол-во строк: ", 0), GetConsole("Введите кол-во столбцов: ", 0));
Vivod(arr, "Задан массив:\n");
Sortirovka(arr);
Vivod(arr, "В итоге получается вот такой массив:\n");