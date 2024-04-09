
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
        renderBasket()
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
    removeGood(item){
        let idx = this.items.findIndex(el=>el.name === item.name)
        this.items.splice(idx, 1);
        renderBasket()
    }
}


let b1 = new Bucket()
$(document).ready(()=>{
    b1.addGood('ads', 100)
    b1.addGood('ads', 100)
    b1.addGood('ads', 100)
    b1.addGood('ads2', 1000)
    b1.addGood('ads2', 1000)
    b1.addGood('ads3', 5000)

})


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
}

function renderBasket() {
    Alpine.store('busket').renderBusket(b1)

    let basket = $('.basket')
    basket.text('')
    if(b1.countBasketPrice().goods.length > 0){
        basket.append(`<p>«В корзине: ${b1.countGoods()} товаров на сумму ${b1.countBasketPrice().price} рублей»</p>`)
    }else{
        basket.append('<p>«Корзина пуста»</p>')
    }
}

document.addEventListener('alpine:init', () => {
    Alpine.store('busket', {
        items: [],
        renderBusket(obj){
            this.items = [...obj.countBasketPrice().goods]
        },
    })
    Alpine.data('busket', () => ({
        expanded: 1,
        removeGood(item){
            b1.removeGood(item)
        },
        addGood(item){
            b1.addGood(item.name, (item.price/item.amount))
        },
        toggle(val){
            this.expanded = this.expanded === val ? 0 : val
        },
    }))
})

/*
Реализовать страницу корзины:
a. Добавить возможность не только смотреть состав корзины, но и редактировать его,
обновляя общую стоимость или выводя сообщение «Корзина пуста».

*/


/*
На странице корзины:
a. Сделать отдельные блоки «Состав корзины», «Адрес доставки», «Комментарий»;
b. Сделать эти поля сворачиваемыми;
c. Заполнять поля по очереди, то есть давать посмотреть состав корзины, внизу которого
есть кнопка «Далее». Если нажать ее, сворачивается «Состав корзины» и открывается
«Адрес доставки» и так далее.
*/