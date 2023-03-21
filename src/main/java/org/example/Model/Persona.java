package org.example.Model;

/*
Interface Segregation Principle
Liskov’s Substitution Principle
LearnGroup не нужнен String name, поэтому выносим в отдельный класс
 */
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
