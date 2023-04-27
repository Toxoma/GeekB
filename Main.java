package Java.GeekB;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Shop shop1 = new Shop();
        shop1.addToyType("Тигр1", 5, 30);
        shop1.addToyType("Тигр2", 4, 40);
        shop1.addToyType("Тигр3", 100);
        shop1.addToyByName("Тигр3");
        shop1.getLottery().spinWheel();
        shop1.getLottery().spinWheel();

        shop1.getLottery().showPrizes();
        shop1.showStock();
//        System.out.println( shop1.goodsTypes.get(2).getAmount() );
    }
}