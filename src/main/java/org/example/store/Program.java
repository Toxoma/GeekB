package org.example.store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Store store = new Store();
        Product product1 = new Product("A", 100);
        Product product2 = new Product("B", 200);
        Buyer buyer1 = new Buyer("Buyer1");
        OrderItem orderItem1 = new OrderItem(product1);
        OrderItem orderItem2 = new OrderItem(product2, 5);
        List<OrderItem> items = new ArrayList<>();
        items.add(orderItem1);
        items.add(orderItem2);
        Order order1 = new Order(LocalDateTime.now(), "Address", "+896596", buyer1, items);
        store.addOrder(order1);
    }
}