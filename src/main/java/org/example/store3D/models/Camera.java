package org.example.store3D.models;

public class Camera {
    private Point3D location;
    private Angle3D angle;

    public Camera(Point3D location, Angle3D angle) {
        this.location = location;
        this.angle = angle;
    }

    public Camera() {
    }

    public void rotate(Angle3D angle){
        this.angle = angle;
    }
    public void move(Point3D point3D){
        this.location = point3D;
    }
}
