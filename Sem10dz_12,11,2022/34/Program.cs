/* 
Задача 34: Задайте массив заполненный случайными положительными трёхзначными числами. Напишите программу, которая покажет количество чётных чисел в массиве.

[345, 897, 568, 234] -> 2
*/

int GetConsole(string msg)
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

        if (int.TryParse(str, out int number) && number > 0)
        {
            result = number;
            break;
        }
        else
        {
            LogWrong("Нужно число > 0.\n");
        }
    }

    return result;
}

int[] InitArray()
{
    int length = GetConsole("Количество элементов: ");
    int[] result = new int[length];
    Random rnd = new Random();

    for (int i = 0; i < result.Length; i++)
    {
        result[i] = rnd.Next(100,1000);
    }

    return result;
}

(int, int[]) CountChet(int[] mas)
{
    int result = 0;
    for (int i = 0; i < mas.Length; i++)
    {
        if (mas[i] % 2 == 0)
        {
            result+=1;
        }
    }
    return (result, mas);
}

void Vivod(int x, int[] mas)
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
    Console.Write($"{x}");
}


(int x, int[] mas) = CountChet(InitArray());
Vivod(x, mas);
