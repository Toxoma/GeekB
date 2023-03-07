package org.example;

abstract class Obstacle {
    private int scale;
    protected String name;

    public String getName() {
        return name;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int length) {
        this.scale = length;
    }
}
