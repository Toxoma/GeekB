/* 
Задача 36: Задайте одномерный массив, заполненный случайными числами. Найдите сумму элементов, стоящих на нечётных позициях.

[3, 7, 23, 12] -> 19

[-4, -6, 89, 6] -> 0
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
    int length = GetConsole("Длина массива: ");
    int[] result = new int[length];
    Random rnd = new Random();

    for (int i = 0; i < result.Length; i++)
    {
        result[i] = rnd.Next(-999, 1000);
    }

    return result;
}

(int, int[]) CountSum(int[] mas)
{
    int result = 0;
    for (int i = 0; i < mas.Length; i+=2)
    {
        result+=mas[i];
    }
    return (result, mas);
}

void Vivod(int sum, int[] mas)
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

(int x, int[] mas) = CountSum(InitArray());
Vivod(x, mas);
