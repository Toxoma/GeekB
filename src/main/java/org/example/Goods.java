package org.example;

import java.util.ArrayList;
import java.util.List;

abstract class Goods {
    protected List<Good> goods = new ArrayList<>();

    public void addGood(Good good, int count) {
        if (count > 0){
            for (int i = 0; i < count; i++){
                this.goods.add(good);
            }
        }
    }

    public void addGood(Good good) {
        this.goods.add(good);
    }

    public void printAllGoods() {
        for (Good good : goods){
            System.out.printf("Название: %s, Цена: %d, Рейтинг: %d.\n",good.getName(),good.getPrice(), good.getRaiting());
        }
    }
}
