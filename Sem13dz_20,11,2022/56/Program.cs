/* 
Задача 56: Задайте прямоугольный двумерный массив. Напишите программу, которая будет находить строку с наименьшей суммой элементов.

Например, задан массив:

1 4 7 2

5 9 2 3

8 4 2 4

5 2 6 7

Программа считает сумму элементов в каждой строке и выдаёт номер строки с наименьшей суммой элементов: 1 строка
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

int[,] InitArray(int m)
{
    int[,] arr = new int[m, m];
    Random rnd = new Random();
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < m; j++)
        {
            arr[i,j] = rnd.Next(0, 10);
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

void FindMinStrInArray(int[,] arr){
    Console.Write("Программа считает сумму элементов в каждой строке и выдаёт номер строки с наименьшей суммой элементов: ");

    var kortez = (stroka: 0, value: 0, first: true);
    int value = 0;
    for (int i = 0; i < arr.GetLength(0); i++)
    {
        value = 0;
        for (int j = 0; j < arr.GetLength(1); j++)
        {
            value+= arr[i,j];
        }
        if(kortez.first || kortez.value > value){
            kortez.first = false;
            kortez.value = value;
            kortez.stroka = i;
        }
    }

    Console.Write($"{kortez.stroka+1} строка");
}

int[,] arr = InitArray(GetConsole("Введите размерность массива: ", 0));
Vivod(arr, "Задан массив:\n");
FindMinStrInArray(arr);