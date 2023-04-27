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
        System.out.println("Добавление типа товара ("+name+")...");
        if (this.nameExist(name)) return;

        if (amount > 0) {
            ToyTypes toyType = new ToyTypes(name, weight, amount);
            this.goodsTypes.add(toyType);
            this.uniqNames.add(name);
        }else{
            System.out.println("Введённое кол-во товара должно быть > 0!");
            System.out.println();
            return;
        }
        System.out.println("Добавление прошло успешно!");
        System.out.println();
    }

    public void addToyType(String name, int weight) {
        System.out.println("Добавление типа товара...");
        if (this.nameExist(name)) return;

        ToyTypes toyType = new ToyTypes(name, weight, 1);
        this.goodsTypes.add(toyType);
        this.uniqNames.add(name);
        System.out.println("Добавление прошло успешно!");
        System.out.println();
    }

    public void addToyByName(String name) {
        System.out.println("Добавление товара "+name+" на склад...");
        ToyTypes toyType = this.getToyType(name);
        if (toyType != null) {
            toyType.addToy();
            System.out.println("Добавление прошло успешно!");
        }
        System.out.println();
    }

    private boolean nameExist(String name) {
        if (this.uniqNames.contains(name)) {
            System.out.println("Позиция с таким именем ("+name+") уже существует!");
            System.out.println();
            return true;
        }
        return false;
    }

    private ToyTypes getToyType(String name) {
        ToyTypes toyTypes = this.goodsTypes.stream().filter(type -> type.getName() == name).findFirst().orElse(null);
        if (toyTypes != null){
            return toyTypes;
        }else {
            System.out.println("Позиции с таким названием ("+name+") не существует!");
            return null;
        }
    }

    public void showStock() {
        System.out.println("Остатки товаров:");
        for (ToyTypes toyType : this.goodsTypes) {
            for (Toy toy : toyType.getToys()) {
                System.out.printf(toy.getId() + ", " + toy.getName() + ", " + toy.getWeight()+"\n");
            }
        }
        System.out.println();
    }

    public void setWeight(String name, int weight) {
        System.out.println("Изменение веса позиции "+name+"...");
        ToyTypes toyTypes = this.getToyType(name);
        if (toyTypes != null){
            toyTypes.setWeight(weight);
            System.out.println("Успех!");
        }
        System.out.println();
    }
}
