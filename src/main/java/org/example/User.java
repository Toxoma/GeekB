package org.example;

public class User {
    private String login;
    private String password;
    public Basket basket = new Basket();

    public User(String login, String password) {
        this.setLogin(login);
        this.setPassword(password);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void printGoodsInBasket() {
        System.out.printf("Пользователь - %s. ", this.getLogin());
        this.basket.printAllGoods();
    }
}
