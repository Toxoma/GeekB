package org.example.store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static int counter = 100;
    private int id;

    private LocalDateTime orderdate;
    private String address;
    private String phone;
    private Buyer buyer;
    private List<OrderItem> items = new ArrayList<>();

    {
        id = ++counter;
    }

    public Order(LocalDateTime orderdate, String address, String phone, Buyer buyer, List<OrderItem> items) {
        if (buyer == null){
            throw new RuntimeException("User not exist!");
        }
        if (items == null || items.size() == 0){
            throw new RuntimeException("Order items > 0!");
        }
        this.orderdate = orderdate;
        this.address = address;
        this.phone = phone;
        this.buyer = buyer;
        this.items = items;
    }
}