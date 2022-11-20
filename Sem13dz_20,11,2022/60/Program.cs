/* 
Задача 60. ...Сформируйте трёхмерный массив из неповторяющихся двузначных чисел. Напишите программу, которая будет построчно выводить массив, добавляя индексы каждого элемента.
Массив размером 2 x 2 x 2
66(0,0,0) 25(0,1,0)
34(1,0,0) 41(1,1,0)
27(0,0,1) 90(0,1,1)
26(1,0,1) 55(1,1,1)
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

int[,,] InitArray(int m, int n, int o)
{
    Dictionary<int, int> znach = new Dictionary<int, int>();
    Random rnd = new Random();
    int NePovtor()
    {
        int result = 0;
        while (true)
        {
            result = rnd.Next(10, 100);
            if (!znach.ContainsKey(result))
            {
                znach.Add(result, 1);
                return result;
            }
        }
    }

    int[,,] arr = new int[m, n, o];
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            for (int k = 0; k < o; k++)
            {
                arr[i, j, k] = NePovtor();
            }
        }
    }

    return arr;
}

void Vivod(int[,,] arr)
{
    int m = arr.GetLength(0);
    int n = arr.GetLength(1);
    int o = arr.GetLength(2);
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            for (int z = 0; z < o; z++)
            {
                Console.WriteLine($"{arr[i, j, z]}({i},{j},{z})");
            }
        }
    }
}



int[,,] arr = InitArray(
    GetConsole("Введите кол-во строк: ", 0),
    GetConsole("Введите кол-во столбцов: ", 0),
    GetConsole("Введите глубину: ", 0)
    );

Vivod(arr);