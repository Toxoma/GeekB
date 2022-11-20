/* 
Задача 58: Задайте две матрицы. Напишите программу, которая будет находить произведение двух матриц.
Например, даны 2 матрицы:
2 4 | 3 4
3 2 | 3 3
Результирующая матрица будет:
18 20
15 18
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
    Console.WriteLine();
}

int[,] Proizvedenie(int[,] arr1, int[,] arr2)
{
    void Error()
    {
        Console.Write("Число столбцов первой матрицы должно равняться числу строк второй!!!\n");
        System.Environment.Exit(1);
    }
    int GetValue(int m, int n)
    {
        int result = 0;

        for (int i = 0; i < arr1.GetLength(1); i++)
        {
            result += arr1[m, i] * arr2[i, n];
        }
        return result;
    }

    if (arr1.GetLength(1) != arr2.GetLength(0)) Error();
    int[,] result = new int[arr1.GetLength(0), arr2.GetLength(1)];
    for (int i = 0; i < result.GetLength(0); i++)
    {
        for (int j = 0; j < result.GetLength(1); j++)
        {
            result[i, j] = GetValue(i, j);
        }
    }
    return result;
}

int[,] arr1 = InitArray(GetConsole("Введите кол-во строк массива1: ", 0), GetConsole("Введите кол-во столбцов массива1: ", 0));
int[,] arr2 = InitArray(GetConsole("Введите кол-во строк массива2: ", 0), GetConsole("Введите кол-во столбцов массива2: ", 0));
Vivod(arr1);
Vivod(arr2);
int[,] result = Proizvedenie(arr1, arr2);
Vivod(result, "Результирующая матрица будет:\n");