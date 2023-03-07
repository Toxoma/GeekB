package org.example;

public class Road extends Obstacle{

    public Road(int length) {
        this.setScale(length);
        super.name = "Road";
    }
}
