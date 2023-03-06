package org.example;

public class Category extends Goods {
    private String name;
    public Category(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printAllGoods() {
        System.out.printf("Название категории - %s:\n",this.getName());
        super.printAllGoods();
    }
}
