package org.example;

public class Good {
    private String name;
    private int price;
    private int raiting;

    public Good(String name, int price, int raiting) {
        this.setName(name);
        this.setPrice(price);
        this.setRaiting(raiting);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        if (raiting > 0 && raiting < 6)
            this.raiting = raiting;
        else
            System.out.println("Введён неверный рейтинг!!!");
    }
}
