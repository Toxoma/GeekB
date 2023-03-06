package org.example;

public class Basket extends Goods {
    @Override
    public void printAllGoods() {
        System.out.println("Товары в корзине:");
        super.printAllGoods();
    }

    @Override
    public void addGood(Good good) {
        System.out.println("Необходимо ввести каталог!!!");
    }

    public void addGood(Good good, ListOfGoods catalog) {
        if (catalog.goods.contains(good)){
            catalog.removeGood(good);
            super.addGood(good);
        }else{
            System.out.printf("Товара - %s больше нет!\n", good.getName());
        }
    }
}
