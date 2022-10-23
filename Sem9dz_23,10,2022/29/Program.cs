/* 
Задача 29: Напишите программу, которая задаёт массив из 8 элементов и выводит их на экран.

1, 2, 5, 7, 19 -> [1, 2, 5, 7, 19]

6, 1, 33 -> [6, 1, 33]
*/
int length = GetConsole("Введите длину массива: ");
int max = GetConsole("Введите разброс значений в массиве [от 0; до x): ");

int[] mas = new int[length];
Random rnd = new Random();

for (int i = 0; i < mas.Length; i++)
{
    mas[i] = rnd.Next(max);
}

Vivod(mas);

void Vivod(int[] mas)
{
    for (int i = 0; i < mas.Length; i++)
    {
        if (i == 0)
        {
            Console.Write($"[{mas[i]}, ");
            continue;
        }
        if (i == length - 1)
        {
            Console.Write($"{mas[i]}]");
            continue;
        }
        Console.Write($"{mas[i]}, ");
    }
}

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
            LogWrong("Ввели некорректное число! Повторите ввод.\n");
        }
    }

    return result;
}