package org.example.store3D.models;

import java.awt.*;

public class Flash {
    private Point3D location;
    private Angle3D angle;
    private Color color;
    private float power;

    public Flash() {
    }

    public Flash(Point3D location, Angle3D angle, Color color, float power) {
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }

    public void rotate(Angle3D angle){
        this.angle = angle;
    }
    public void move(Point3D point3D){
        this.location = point3D;
    }

    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public Color getColor() {
        return color;
    }

    public float getPower() {
        return power;
    }

    public void setLocation(Point3D location) {
        this.location = location;
    }

    public void setAngle(Angle3D angle) {
        this.angle = angle;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPower(float power) {
        this.power = power;
    }
}
