// Задача 13: Напишите программу, которая выводит третью цифру заданного числа или сообщает, что третьей цифры нет.
// 645 -> 5
// 78 -> третьей цифры нет
// 32679 -> 6
Console.Write("Введите число: ");
int number = Math.Abs(int.Parse(Console.ReadLine()));
if(number > 99){
    while (number > 999)
    {
        number = number / 10;
    }
    Console.Write(number%10);
}else{
    Console.Write("Третьей цифры нет!");
}