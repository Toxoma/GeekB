package org.example;

public class Main {
    public static void main(String[] args) {
        Good good1 = new Good("Bread", 100, 4);
        Good good2 = new Good("Cheeze", 200, 3);
        Good good3 = new Good("Rum", 300, 5);

        Category category1 = new Category("Alco");
        category1.addGood(good3);
        Category category2 = new Category("Another");
        category2.addGood(good1);
        category2.addGood(good2);

        ListOfGoods catalog = new ListOfGoods();
        catalog.addGood(good1, 3);
        catalog.addGood(good2, 3);
        catalog.addGood(good3, 3);
        catalog.printAllGoods();

        System.out.println();

        User user1 = new User("Dan", "123");
        user1.basket.addGood(good3, catalog);
        user1.basket.addGood(good3, catalog);
        user1.basket.addGood(good3, catalog);
        user1.basket.addGood(good3, catalog);
        user1.printGoodsInBasket();
        User user2 = new User("Ann", "321");
        user2.basket.addGood(good2, catalog);
        user2.basket.addGood(good2, catalog);
        user2.basket.addGood(good1);
        user2.printGoodsInBasket();

        System.out.println();

        System.out.println("Остатки в магазине");
        catalog.printAllGoods();
    }
}