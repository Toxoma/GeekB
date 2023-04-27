package Java.GeekB;

public class Main {
    public static void main(String[] args) {
        Shop shop1 = new Shop();

        shop1.getLottery().spinWheel();

        shop1.addToyByName("Тигр3");
        shop1.addToyType("Тигр1", 5, 30);
        shop1.addToyType("Тигр1", 5, 30);
        shop1.addToyType("Тигр2", 0, 30);
        shop1.addToyType("Тигр2", 4, 40);
        shop1.addToyType("Тигр3", 100);
        shop1.addToyByName("Тигр3");
        shop1.setWeight("Тигр4", 1000);
        shop1.setWeight("Тигр3", 10000);

        shop1.getLottery().getPrize();
        shop1.getLottery().spinWheel();

        shop1.setWeight("Тигр3", 100);

        shop1.getLottery().spinWheel();
        shop1.getLottery().getPrize();
        shop1.getLottery().getPrize();
        shop1.getLottery().getPrize();
//        shop1.getLottery().spinWheel();
//        shop1.getLottery().spinWheel();
//        shop1.getLottery().spinWheel();
//        shop1.getLottery().spinWheel();

        shop1.getLottery().showPrizes();
        shop1.showStock();
    }
}