/*
Создать функцию, генерирующую шахматную доску. Можно использовать любые html-теги.
Доска должна быть верно разлинована на черные и белые ячейки. Строки должны
нумероваться числами от 1 до 8, столбцы — латинскими буквами A, B, C, D, E, F, G, H.
*/

$(document).ready(()=>{
    function createBoard(mas = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']) {
        let container = $('.board')
        let row, col
        let flag = false
        for (let i = 0; i < mas.length+1; i++) {
            row = $("<div class='row'></div>")
            for (let j = 0; j < mas.length+1; j++) {
                if (i===0) {
                    if (j === 0) {
                        col = $(`<div class='col'></div>`)
                    }else{
                        col = $(`<div class='col head'></div>`).text(mas[j-1])
                    }
                }else{
                    if (j===0) {
                        col = $(`<div class='col'></div>`).text(i)
                    }else{
                        col = $(`<div class='col ${(flag ? 'white' : 'black')}'></div>`)
                    }
                }
                flag=!flag
                row.append(col)
            }
            container.append(row)
        }
    }
    createBoard()
})

/*
Сделать генерацию корзины динамической: верстка корзины не должна находиться в
HTML-структуре. Там должен быть только div, в который будет вставляться корзина,
сгенерированная на базе JS:
a. Пустая корзина должна выводить строку «Корзина пуста»;
b. Наполненная должна выводить «В корзине: n товаров на сумму m рублей».

*/
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
    countGoods(){
        return this.items.length
    }
}

let b1 = new Bucket()

$(document).ready(()=>{
    let basket = $('.basket')

    b1.addGood('apple', 100)
    b1.addGood('apple', 100)
    b1.addGood('apple', 100)
    b1.addGood('orange', 200)
    
    if(b1.countBasketPrice().goods.length > 0){
        basket.append(`<p>«В корзине: ${b1.countGoods()} товаров на сумму ${b1.countBasketPrice().price} рублей»</p>`)
    }else{
        basket.append('<p>«Корзина пуста»</p>')
    }
})

/*
* Сделать так, чтобы товары в каталоге выводились при помощи JS:
a. Создать массив товаров (сущность Product);
b. При загрузке страницы на базе данного массива генерировать вывод из него.
HTML-код должен содержать только div id=”catalog” без вложенного кода. Весь вид
каталога генерируется JS.

*/
productId = 0
class Product{
    id = 0
    items = []
    constructor() {
        this.id = ++productId;
    }
    addProduct(name){
        this.items.push({
            name,
        })
    }
}
let product = new Product()
product.addProduct('яблоки')
product.addProduct('груши')
product.addProduct('смартфоны')
product.addProduct('туалетная бумага')

$(document).ready(()=>{
    let catalog = $('#catalog')

    catalog.append('<p><b>Каталог:</b></p>')
    for (let i = 0; i < product.items.length; i++) {
        catalog.append(`<p>${i+1}) ${capitalizeFirstLetter(product.items[i].name)}</p>`)
    }

    function capitalizeFirstLetter(string) {
        return string.charAt(0).toUpperCase() + string.slice(1);
    }
})