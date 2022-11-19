/* 
Задача 50. Напишите программу, которая на вход принимает позиции элемента в двумерном массиве, и возвращает значение этого элемента или же указание, что такого элемента нет.

Например, задан массив:

1 4 7 2

5 9 2 3

8 4 2 4

17 -> такого числа в массиве нет
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
            arr[i,j] = rnd.Next(-9, 10);
        }
    }

    return arr;
}

void Vivod(int[,] arr, (int x, int y)position)
{
    int m = arr.GetLength(0);
    int n = arr.GetLength(1);
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if(j!=n-1){
                Console.Write($"{arr[i,j]} ");
            }else{
                Console.Write($"{arr[i,j]}\n");
            }
        }
    }

    if(position.x > m-1 || position.y > n-1){
        Console.WriteLine($"{{{position.x};{position.y}}} -> такого числа в массиве нет");
    }else{
        Console.WriteLine($"{{{position.x};{position.y}}} -> {arr[position.x,position.y]}");
    }
}

int[,] arr = InitArray(GetConsole("Введите кол-во строк: ", 0), GetConsole("Введите кол-во столбцов: ", 0));
var position = (
    x:GetConsole("Введите позицию x (первая 0): ", 0), 
    y:GetConsole("Введите позицию y (первая 0): ", 0)
    );
Vivod(arr, position);