/* 
Задача 23

Напишите программу, которая принимает на вход число (N) и выдаёт таблицу кубов чисел от 1 до N.

3 -> 1, 8, 27
5 -> 1, 8, 27, 64, 125
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

        string str = Console.ReadLine();

        if (int.TryParse(str, out int number) && number != 0)
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

void GetCube(int x)
{
    void Run(int i)
    {
        if (i != x)
        {
            Console.Write(Math.Pow(i, 3) + ", ");
        }
        else
        {
            Console.Write(Math.Pow(i, 3));
        }
    }

    if (x > 0)
    {
        for (int i = 1; i <= x; i++)
        {
            Run(i);
        }
    }
    else
    {
        for (int i = -1; i >= x; i--)
        {
            Run(i);
        }
    }

}

int x = GetConsole("Введите число отличное от 0: ");
GetCube(x);