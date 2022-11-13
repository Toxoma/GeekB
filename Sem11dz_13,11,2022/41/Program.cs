/* 
Задача 41: Пользователь вводит с клавиатуры M чисел. Посчитайте, сколько чисел больше 0 ввёл пользователь.

0, 7, 8, -2, -2 -> 2

1, -7, 567, 89, 223-> 3
*/

(int, bool) GetConsole(string msg)
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

        if (int.TryParse(str, out int number))
        {
            result = number;
            break;
        }
        else if(str.Equals("exit")){
            return (0, true);
        }
        else
        {
            LogWrong("\nНужно число.");
        }
    }

    return (result, false);
}

List<int> VvodChisel(){
    List<int> mas = new List<int>();
    while (true)
    {
        var vvod = GetConsole("Введите число (для выхода введите 'exit'): ");
        if(vvod.Item2) {
            Console.WriteLine("Конец ввода!\n");
            break;
        }
        mas.Add(vvod.Item1);
    }

    return mas;
}

void Schet(List<int> mas){
    int x = 0;
    for (int i = 0; i < mas.Count; i++)
    {
        if(mas[i] > 0) x+=1;

        if(i == mas.Count-1){
            Console.Write($"{mas[i]} -> {x}");
            return;
        }
        
        Console.Write($"{mas[i]}, ");
    }
}

Schet(VvodChisel());
