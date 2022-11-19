/* 
Задача 47. Задайте двумерный массив размером m×n, заполненный случайными вещественными числами.

m = 3, n = 4.

0,5 7 -2 -0,2

1 -3,3 8 -9,9

8 7,8 -7,1 9
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

double[,] InitArray(int m, int n)
{
    int dlina = GetConsole("Кол-во цифр после запятой: ", -1);
    double[,] arr = new double[m, n];
    Random rnd = new Random();
    double a;
    int b;
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            a = rnd.NextDouble();
            b = rnd.Next(-9, 10);
            arr[i,j] = Convert.ToDouble(Convert.ToString(b) + ',' + Convert.ToString(a).Substring(Convert.ToString(a).Length - dlina));
        }
    }

    return arr;
}

void Vivod(double[,] arr)
{
    int m = arr.GetLength(0);
    int n = arr.GetLength(1);
    Console.WriteLine($"m = {m}, n = {n}.\n");
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
}

double[,] arr = InitArray(GetConsole("Введите m: ", 0), GetConsole("Введите n: ", 0));
Vivod(arr);