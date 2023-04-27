package Java.GeekB;

import Java.GeekB.abstracts.Identity;

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
        int k = 0;
        for (ToyTypes toyType : this.goodsTypes) {
            toyType.lotteryMin = k;
            k += toyType.getWeight() * toyType.getAmount();
            toyType.lotteryMax = k;
        }
        int r = this.random.nextInt(0, k);
        for (ToyTypes toyType : this.goodsTypes) {
            if (toyType.getAmount() > 0 && r >= toyType.lotteryMin && r < toyType.lotteryMax) {
                Toy toy = toyType.toys.pop();
                this.prizes.add(toy);
                toyType.setAmount(toyType.getAmount() - 1);
                return;
            }
        }
        System.out.println("Гача пошла не по плану");
    }


//    TODO DELETE
    public void showPrizes() {
        System.out.println("Призы:");
        for (Toy toy : this.prizes) {
            System.out.printf(toy.getId() + ", " + toy.getName() + ", " + toy.getWeight()+"\n");
        }
    }
}
