// Задача 10: Напишите программу, которая принимает на вход трёхзначное число и на выходе показывает вторую цифру этого числа.
// 456 -> 5
// 782 -> 8
// 918 -> 1
Console.Write("Введите число: ");
int number = int.Parse(Console.ReadLine());
if(number>99 && number<1000 || number<-99 && number>-1000){
    number = number/10;
    number = number%10;
    number = Math.Abs(number);
    Console.Write($"{number}");
}else{
    Console.Write("Некорректное число!");
}