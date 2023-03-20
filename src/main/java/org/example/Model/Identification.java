package org.example.Model;

abstract class Identification {
    public Identification() {
        this.id = ID_COUNTER++;
    }

    protected static int ID_COUNTER = 1;

    protected int id;

    public int getId() {
        return id;
    }
}
