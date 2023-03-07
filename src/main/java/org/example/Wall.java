package org.example;

public class Wall extends Obstacle{

    public Wall(int height) {
        this.setScale(height);
        super.name = "Wall";
    }
}
