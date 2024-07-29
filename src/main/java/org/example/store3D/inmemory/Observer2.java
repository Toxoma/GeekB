package org.example.store3D.inmemory;

public class Observer2 implements ModelChangedObserver{
    @Override
    public void applyUpdateModel() {
        System.out.println("Observer2");
    }
}
