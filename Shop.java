package Java.GeekB;

import Java.GeekB.abstracts.Identity;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Identity {
    private static int GLOBAL_ID = 0;
    private List<ToyTypes> goodsTypes = new ArrayList<>();
    private List<String> uniqNames = new ArrayList<>();
    private Lottery lottery = new Lottery(goodsTypes);

    public Shop() {
        super(++GLOBAL_ID);
    }

    public Lottery getLottery() {
        return lottery;
    }

    public void addToyType(String name, int amount, int weight) {
        if (this.nameExist(name)) return;

        if (amount > 0) {
            ToyTypes toyType = new ToyTypes(name, weight, amount);
            this.goodsTypes.add(toyType);
            this.uniqNames.add(name);
        }
    }

    public void addToyType(String name, int weight) {
        if (this.nameExist(name)) return;

        ToyTypes toyType = new ToyTypes(name, weight, 1);
        this.goodsTypes.add(toyType);
        this.uniqNames.add(name);
    }

    public void addToyByName(String name) {
        ToyTypes toyType = this.getToyType(name);
        if (toyType != null) {
            toyType.addToy();
        }
    }

    private boolean nameExist(String name) {
        if (this.uniqNames.contains(name)) {
            System.out.println("Позиция с таким именем уже существует!");
            return true;
        }
        return false;
    }

    public ToyTypes getToyType(String name) {
        return this.goodsTypes.stream().filter(type -> type.getName() == name).findFirst().orElse(null);
    }

    //    TODO DELETE
    public void showStock() {
        System.out.println("Остатки:");
        for (ToyTypes toyType : this.goodsTypes) {
            for (Toy toy : toyType.toys) {
                System.out.printf(toy.getId() + ", " + toy.getName() + ", " + toy.getWeight()+"\n");
            }
        }
    }
}
