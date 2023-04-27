package Java.GeekB;

import Java.GeekB.abstracts.Identity;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Lottery extends Identity {
    private static int GLOBAL_ID = 0;
    private Random random = new Random();
    private List<ToyTypes> goodsTypes;
    private LinkedList<Toy> prizes = new LinkedList<>();

    public Lottery(List<ToyTypes> goodsTypes) {
        super(++GLOBAL_ID);
        this.goodsTypes = goodsTypes;
    }

    public void spinWheel() {
        System.out.println("Рулетка крутиться, ожидайте...");
        int k = 0;
        if (this.goodsTypes.size() == 0) {
            System.out.println("Товарв для розыгрыша НЕТ!");
            System.out.println();
            return;
        }
        for (ToyTypes toyType : this.goodsTypes) {
            toyType.lotteryMin = k;
            k += toyType.getWeight() * toyType.getAmount();
            toyType.lotteryMax = k;
            System.out.print(toyType.getName() + " [" + toyType.lotteryMin + ".." + toyType.lotteryMax + "); ");
        }
        System.out.println();
        int r = this.random.nextInt(0, k);
        for (ToyTypes toyType : this.goodsTypes) {
            if (toyType.getAmount() > 0 && r >= toyType.lotteryMin && r < toyType.lotteryMax) {
                Toy toy = toyType.getToys().pop();
                this.prizes.add(toy);
                toyType.setAmount(toyType.getAmount() - 1);
                System.out.println("Поздравляем вы выбили: " + toy.getName());
                System.out.println();
                return;
            }
        }
        System.out.println("Гача пошла не по плану");
        System.out.println();
    }

    public Toy getPrize() {
        System.out.println("Попытка обналичить выйгрыш...");
        if (this.prizes.size() == 0) {
            System.out.println("Никаких призов нет!");
            System.out.println();
            return null;
        }
        Toy toy = this.prizes.pop();
        System.out.println("Вы получили: " + toy.getName() + " Вес: " + toy.getWeight());
        System.out.println("Оставшихся призов для выдачи: " + this.prizes.size() + " шт");
        try {
            FileWriter file = new FileWriter("prizes.txt", true);
            file.write("Был выйгран: " + toy.getName() + ";\n");
            file.close();
            System.out.println("Информация о выйграше записана в файл!");
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл!");
            e.printStackTrace();
        }
        return toy;
    }


    //    TODO DELETE
    public void showPrizes() {
        System.out.println("Призы на складе:");
        for (Toy toy : this.prizes) {
            System.out.printf(toy.getId() + ", " + toy.getName() + ", " + toy.getWeight() + "\n");
        }
        System.out.println();
    }
}
