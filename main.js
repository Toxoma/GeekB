
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
    renderBasket()
})


/*
1. Продолжаем реализовывать модуль корзины:
a. Добавлять в объект корзины выбранные товары по клику на кнопке «Купить» без
перезагрузки страницы;
b. Привязать к событию покупки товара пересчет корзины и обновление ее внешнего
вида.

*/
function buyGood(){
    let name = $('#name').val()
    let price = +$('#price').val()
    if (!name || !price || typeof(price) !== 'number') {
        $('.err-msg').removeClass('d-none')
        return
    }else{
        $('.err-msg').addClass('d-none')
    }
    
    b1.addGood(name, price)
    renderBasket()
}

function renderBasket() {
    let basket = $('.basket')
    basket.text('')
    if(b1.countBasketPrice().goods.length > 0){
        basket.append(`<p>«В корзине: ${b1.countGoods()} товаров на сумму ${b1.countBasketPrice().price} рублей»</p>`)
    }else{
        basket.append('<p>«Корзина пуста»</p>')
    }
}