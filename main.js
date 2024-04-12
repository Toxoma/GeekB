
function createBucket() {
    bucketId = 0
    class Bucket {
        id = 0
        items = []
        constructor() {
            this.id = ++bucketId;
        }
        addGood(name, price) {
            this.items.push({
                name,
                price
            })
            renderBasket()
        }
        countBasketPrice() {
            let result = {
                'price': 0,
                'goods': [],
            }
            let good = null
            this.items.forEach(element => {
                result.price += element.price
                good = result.goods.find(good => good.name === element.name)
                if (good) {
                    good.amount++
                    good.price += element.price
                } else {
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
        countGoods() {
            return this.items.length
        }
        removeGood(item) {
            let idx = this.items.findIndex(el => el.name === item.name)
            this.items.splice(idx, 1);
            renderBasket()
        }
    }

    function renderBasket() {
        Alpine.store('busket').renderBusket(b1)

        let basket = $('.basket')
        basket.text('')
        if (b1.countBasketPrice().goods.length > 0) {
            basket.append(`<p>«В корзине: ${b1.countGoods()} товаров на сумму ${b1.countBasketPrice().price} рублей»</p>`)
        } else {
            basket.append('<p>«Корзина пуста»</p>')
        }
    }

    return new Bucket()
}

let b1 = createBucket()
$(document).ready(() => {
    b1.addGood('ads', 100)
    b1.addGood('ads', 100)
    b1.addGood('ads', 100)
    b1.addGood('ads2', 1000)
    b1.addGood('ads2', 1000)
    b1.addGood('ads3', 5000)

})


function buyGood() {
    let name = $('#name').val()
    let price = +$('#price').val()
    if (!name || !price || typeof (price) !== 'number') {
        $('.err-msg').removeClass('d-none')
        return
    } else {
        $('.err-msg').addClass('d-none')
    }

    b1.addGood(name, price)
}

document.addEventListener('alpine:init', () => {
    Alpine.store('busket', {
        items: [],
        renderBusket(obj) {
            this.items = [...obj.countBasketPrice().goods]
        },
    })
    Alpine.data('busket', () => ({
        expanded: 1,
        removeGood(item) {
            b1.removeGood(item)
        },
        addGood(item) {
            b1.addGood(item.name, (item.price / item.amount))
        },
        toggle(val) {
            this.expanded = this.expanded === val ? 0 : val
        },
    }))
})

/*
1. Продумать, где можно применить замыкания для практикума из седьмого урока.

bucketId и renderBasket + class Bucket обернуть в функцию возвращающую экземпляр класса Bucket

*/

/*
2. Не выполняя код, ответить, что выведет браузер и почему:

a.
if (!("a" in window)) {
var a = 1;
}
alert(a); Тк if = true , то в alert будет undefined


b.
var b = function a(x) {
x && a(--x);
};
alert(a); Тк a не определено, то будет ошибка


c.
function a(x) {
return x * 2;
}
var a;
alert(a); сначала объявляется все переменные, затем объявляются функции


d.
function b(x, y, a) {
arguments[2] = 10;
alert(a);
}
b(1, 2, 3); вывод 10. arguments это псевдомассив со всеми аргументами функции


e. *
function a() {
alert(this);
}
a.call(null); в non-strict моде this не может быть null и заменяется на глобальный объекст window


*/
