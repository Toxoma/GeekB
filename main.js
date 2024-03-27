/*
Написать функцию, преобразующую число в объект. Передавая на вход число от 0 до 999,
надо получить на выходе объект, в котором в соответствующих свойствах описаны единицы,
десятки и сотни. Например, для числа 245 надо получить следующий объект: {‘единицы’: 5,
‘десятки’: 4, ‘сотни’: 2}. Если число превышает 999, необходимо выдать соответствующее
сообщение с помощью console.log и вернуть пустой объект.
*/
console.log(`Написать функцию, преобразующую число в объект. Передавая на вход число от 0 до 999,
надо получить на выходе объект, в котором в соответствующих свойствах описаны единицы,
десятки и сотни. Например, для числа 245 надо получить следующий объект: {‘единицы’: 5,
‘десятки’: 4, ‘сотни’: 2}. Если число превышает 999, необходимо выдать соответствующее
сообщение с помощью console.log и вернуть пустой объект.`);
function parseIntToObj(number) {
    if (typeof number !== 'number') {
        console.log(`Это не число. Передано ${number}`);
        return null
    }
    if (!(number >= 0 && number <= 999)) {
        console.log(`Число должно быть от 0 до 999. Передано ${number}`);
        return {}
    }
    number+=''
    let a = 0
    switch (number.length) {
        case 3:
            return {
                'сотни': number[a++],
                'десятки': number[a++],
                'единицы': number[a++],
            }
        case 2:
            return {
                'десятки': number[a++],
                'единицы': number[a++],
            }
        default:
            return {
                'единицы': number[a++],
            }
    }
}
console.log(parseIntToObj('245'));
console.log(parseIntToObj(9999));
console.log(parseIntToObj(245));
console.log(parseIntToObj(25));
console.log(parseIntToObj(5));

/*
Продолжить работу с интернет-магазином:
a. В прошлом домашнем задании вы реализовали корзину на базе массивов. Какими
объектами можно заменить их элементы?
b. Реализуйте такие объекты.
c. Перенести функционал подсчета корзины на объектно-ориентированную базу.
*/
console.log(`Продолжить работу с интернет-магазином:
a. В прошлом домашнем задании вы реализовали корзину на базе массивов. Какими
объектами можно заменить их элементы?
b. Реализуйте такие объекты.
c. Перенести функционал подсчета корзины на объектно-ориентированную базу.`);
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
        let result = {
            'price': 0,
            'goods': [],
        }
        let good = null
        this.items.forEach(element => {
            result.price+=element.price
            good = result.goods.find(good => good.name === element.name)
            if (good) {
                good.amount++
                good.price += element.price
            }else{
                result.goods.push({
                    'name': element.name,
                    'amount': 1,
                    'price': element.price,
                })
            }

            good = null
        });
        return result
    }
}

let b1 = new Bucket()
b1.addGood('apple', 100)
b1.addGood('apple', 100)
b1.addGood('apple', 100)
b1.addGood('orange', 200)

console.log(`а) товары в корзине`);
console.log(`б) сделано`);
console.log(`в) сделано`);

console.log(`Корзина:`);
console.log(b1.countBasketPrice());

/*
* Подумать над глобальными сущностями. К примеру, сущность «Продукт» в
интернет-магазине актуальна не только для корзины, но и для каталога. Стремиться нужно к
тому, чтобы объект «Продукт» имел единую структуру для различных модулей сайта, но в
разных местах давал возможность вызывать разные методы.

*/

productId = 0
class Product{
    id = 0
    constructor(name) {
        this.id = ++productId;
        this.name = name;
    }
}
goodId = 0
class Good extends Product{
    id = 0
    constructor(name, price) {
        super(name)
        this.id = ++goodId;
        this.price = price;
    }
}



