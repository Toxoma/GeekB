/* 
Задача 62. Напишите программу, которая заполнит спирально массив 4 на 4.
Например, на выходе получается вот такой массив:
01 02 03 04
12 13 14 05
11 16 15 06
10 09 08 07
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

string[,] InitArray(int size)
{
    string[,] arr = new string[size, size];
    int m = 0;
    int n = 0;
    int k = 1; //перебор присваиваемых значений
    int maxCount = arr.GetLength(0) * arr.GetLength(1);
    int side = 0; //0 - право, 1-низ, 2-лево, 3-верх

    string GenerateValue()
    {
        string result = "";
        if (Convert.ToString(k).Length < 2) result += "0" + k;
        else result += k;
        k++;
        return result;
    }

    // stepBack = fasle - если в ячейке есть значение и необходимо продолжить отрисовку, а не вернутся на последнюю заполненную ячейку (иначе зацикливание происходит)
    void InitValues(int i, int j, int _side, bool stepBack = true)
    {
        if (string.IsNullOrEmpty(arr[i, j]))
        {
            arr[i, j] = GenerateValue();
            m = i;
            n = j;
        }
        else if(stepBack)
        {
            if (k < maxCount)
            {
                side = _side;
                InitValues(m, n, side, false);
            }
            return;
        }

        if (side == 0)
        {
            if (j < size - 1) InitValues(i, j + 1, 1);
            else side = 1;
        }
        if (side == 1)
        {
            if (i < size - 1) InitValues(i + 1, j, 2);
            else side = 2;
        }
        if (side == 2)
        {
            if (j > 0) InitValues(i, j - 1, 3);
            else side = 3;
        }
        if (side == 3)
        {
            if (i > 0) InitValues(i - 1, j, 0);
            else side = 0;
        }
    }
    InitValues(m, n, side);

    return arr;
}

void Vivod(string[,] arr)
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
}

string[,] arr = InitArray(GetConsole("Введите размерность массива: ", 1));
Vivod(arr);