// Задача 15: Напишите программу, которая принимает на вход цифру, обозначающую день недели, и проверяет, является ли этот день выходным.
// 6 -> да
// 7 -> да
// 1 -> нет
Console.Write("Введите число от 1 до 7: ");
int number = int.Parse(Console.ReadLine());
if(number > 0 && number < 8){
    switch (number)
    {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
            Console.WriteLine("нет");
            break;
        default:
            Console.WriteLine("да");
            break;
    }
}else{
    Console.Write("Некорректное число!");
}