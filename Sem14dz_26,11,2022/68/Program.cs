/* 
Задача 68: Напишите программу вычисления функции Аккермана с помощью рекурсии. Даны два неотрицательных числа m и n.
m = 2, n = 3 -> A(m,n) = 9
m = 3, n = 2 -> A(m,n) = 29
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

        if (int.TryParse(str, out int number) && number >= 0)
        {
            result = number;
            break;
        }
        else
        {
            LogWrong($"Нужно число >= 0.\n");
        }
    }

    return result;
}

int Akerman(int m, int n)
{
    if (m == 0)
        return n + 1;
    else
        if ((m != 0) && (n == 0))
            return Akerman(m - 1, 1);
    else
        return Akerman(m - 1, Akerman(m, n - 1));
}

int m = GetConsole("Введите число m: ");
int n = GetConsole("Введите число n: ");
int result = Akerman(m, n);
Console.WriteLine($"M = {m}; N = {n} -> A({m},{n}) = {result}");