package Java.GeekB;

import Java.GeekB.abstracts.DefaultProperties;

import java.util.LinkedList;

public class ToyTypes extends DefaultProperties {
    private static int GLOBAL_ID = 0;
    private int amount;
    protected int lotteryMin = 0;
    protected int lotteryMax = 0;

    protected LinkedList<Toy> toys = new LinkedList<>();

    public ToyTypes(String name, int weight, int amount) {
        super(++GLOBAL_ID, name, weight);
        this.amount = amount;
        for (int i = 0; i < amount; i++) {
            this.toys.add(new Toy(name, weight));
        }
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAmount() {
        return amount;
    }

    protected void setAmount(int amount) {
        this.amount = amount;
    }

    protected void addToy() {
        this.toys.add(new Toy(this.getName(), this.getWeight()));
        this.setAmount(this.getAmount() + 1);
    }
}
