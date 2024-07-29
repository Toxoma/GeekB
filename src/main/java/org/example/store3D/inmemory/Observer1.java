package org.example.store3D.inmemory;

public class Observer1 implements ModelChangedObserver{
    @Override
    public void applyUpdateModel() {
        System.out.println("Observer1");
    }
}
