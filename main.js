/*
Почему код дает именно такие результаты?
*/
var a = 1, b = 1, c, d;
c = ++a; 
// alert(c); // 2
d = b++; 
// alert(d); // 1
c = (2+ ++a); 
// alert(c); // 5
d = (2+ b++); 
// alert(d); // 4
// alert(a); // 3
// alert(b); 

// x=++y - сначало происходит увеличение y потом присвоение
// x=y++ - сначало происходит присвоение y потом увеличение y

/*
Чему будет равен x?
*/
var a = 2;
var x = 1 + (a *= 2); //5

/*
Объявить две целочисленные переменные — a и b и задать им произвольные начальные
значения. Затем написать скрипт, который работает по следующему принципу:
o если a и b положительные, вывести их разность;
o если а и b отрицательные, вывести их произведение;
© geekbrains.ru 11
o если а и b разных знаков, вывести их сумму;
Ноль можно считать положительным числом.
*/
a = -2
b = -5
if(a>=0 && b>= 0){
    alert(a-b)
}else if(a<0 && b<0){
    alert(a*b)
}else{
    alert(a+b)
}

/*
Присвоить переменной а значение в промежутке [0..15]. С помощью оператора switch
организовать вывод чисел от a до 15.
*/
a = Math.floor(Math.random() * 15)
console.log(`A = ${a}`);
switch (a) {
    case 0:
        console.log(a++);
    case 1:
        console.log(a++);
    case 2:
        console.log(a++);
    case 3:
        console.log(a++);
    case 4:
        console.log(a++);
    case 5:
        console.log(a++);
    case 6:
        console.log(a++);
    case 7:
        console.log(a++);
    case 8:
        console.log(a++);
    case 9:
        console.log(a++);
    case 10:
        console.log(a++);
    case 11:
        console.log(a++);
    case 12:
        console.log(a++);
    case 13:
        console.log(a++);
    case 14:
        console.log(a++);
    case 15:
        console.log(a++);
}

/*
Реализовать четыре основные арифметические операции в виде функций с двумя
параметрами. Обязательно использовать оператор return
*/
function convert(x, y){
    return [+x,+y]
}
function summ(x, y){
    [x,y]=convert(x,y)
    return x+y
}
function subtract(x, y){
    [x,y]=convert(x,y)
    return x-y
}
function divide(x, y){
    try {
        [x,y]=convert(x,y)
        if(y === 0) throw new Error('y cannot be 0')
        return x/y
    } catch (e) {
        console.error(e);
    }
}
function multiply(x, y){
    [x,y]=convert(x,y)
    return x*y
}
console.log(`divide = ${divide(2,'0')}`);
console.log(`summ = ${summ(2,'2')}`);

/*
Реализовать функцию с тремя параметрами: function mathOperation(arg1, arg2, operation),
где arg1, arg2 — значения аргументов, operation — строка с названием операции. В
зависимости от переданного значения выполнить одну из арифметических операций
(использовать функции из пункта 5) и вернуть полученное значение (применить switch).
*/
function mathOperation(arg1, arg2, operation){
    switch (operation) {
        case 'summ':
            return summ(arg1, arg2)
        case 'subtract':
            return subtract(arg1, arg2)
        case 'divide':
            return divide(arg1, arg2)
        case 'multiply':
            return multiply(arg1, arg2)
    }
}
console.log(mathOperation(2,'0','divide'));
console.log(mathOperation(2,'0','summ'));
/*
* Сравнить null и 0. Объяснить результат.
*/
console.log('Сравнить null и 0. Объяснить результат');
console.log(null == 0);
console.log(null === 0);
console.log(null > 0);
console.log(null >= 0); // Операторы относительного сравнения подразумевают числовой контекст поэтому null преобразуется в 0

/*
* С помощью рекурсии организовать функцию возведения числа в степень. Формат: function
power(val, pow), где val — заданное число, pow –— степень.
*/
function power(val, pow){
    [val, pow]=convert(val, pow)
    if (pow === 0) {
        return 1
    }
    return val*power(val, --pow)
}
console.log(`power 2^6 = ${power(2,'6')}`);
console.log(`power 2^0 = ${power(2,'0')}`);