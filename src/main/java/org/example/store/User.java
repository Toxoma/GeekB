package org.example.store;
public abstract class User {
    private static int counter = 1000;
    protected int id;
    {
        id = ++counter;
    }

    public int getId() {
        return id;
    }
}