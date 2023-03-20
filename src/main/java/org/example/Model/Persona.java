package org.example.Model;

abstract class Persona extends Identification {
    protected String name;

    public Persona(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
