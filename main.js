/*
С помощью цикла while вывести все простые числа в промежутке от 0 до 100.
*/
console.log("С помощью цикла while вывести все простые числа в промежутке от 0 до 100")
let a = 0
let flag = true
while (a <= 100) {
    if (a < 2) {
        flag = false
    }
    for (let i = 2; i < a; i++) {
        if (a % i == 0) {
            flag = false
            break
        }

    }
    if (flag) {
        console.log(a);
    }
    flag = true
    a++
}

/*
С этого урока начинаем работать с функционалом интернет-магазина. Предположим, есть
сущность корзины. Нужно реализовать функционал подсчета стоимости корзины в
зависимости от находящихся в ней товаров.

Товары в корзине хранятся в массиве. Задачи:
a. Организовать такой массив для хранения товаров в корзине;
b. Организовать функцию countBasketPrice, которая будет считать стоимость корзины.
*/
console.log('С этого урока начинаем работать с функционалом интернет-магазина. Предположим, есть сущность корзины. Нужно  еализовать функционал подсчета стоимости корзины в зависимости от находящихся в ней товаров. Товары в корзине хранятся в массиве. Задачи: a. Организовать такой массив для хранения товаров в корзине; b. Организовать функцию countBasketPrice, которая будет считать стоимость корзины.')
bucketId = 0
class Bucket {
    id = 0
    items = []
    constructor() {
        this.id = ++bucketId;
    }
    addGood(name, price){
        this.items.push({
            name,
            price
        })
    }
    countBasketPrice(){
        let result = 0
        this.items.forEach(element => {
            result+=element.price
        });
        return result
    }
}
let b1 = new Bucket()
b1.addGood('apple', 100)
b1.addGood('apple', 100)
b1.addGood('apple', 100)
console.log(b1.countBasketPrice());


/*
* Вывести с помощью цикла for числа от 0 до 9, не используя тело цикла. Выглядеть это
должно так:
for(...){// здесь пусто}
*/
console.log('Вывести с помощью цикла for числа от 0 до 9, не используя тело цикла. Выглядеть это');
for (let i = 0; console.log(i),i < 10; i++) {
}

/*
 * Нарисовать пирамиду с 20 рядами с помощью console.log, как показано на рисунке:
x
xx
xxx
xxxx
xxxxx
*/
console.log('Нарисовать пирамиду с 20 рядами с помощью console.log, как показано на рисунке:');
let str = ''
for (let i = 1; i <= 20; i++) {
    for (let j = i; j > 0; j--) {
        str+='x'
    }
    console.log(str);
    str=''
}