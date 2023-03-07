package org.example;

abstract class Obstacle {
    private int scale;
    protected String name;

    public Obstacle(int scale) {
        this.setScale(scale);
    }

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
