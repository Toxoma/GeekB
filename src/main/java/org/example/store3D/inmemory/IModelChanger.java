package org.example.store3D.inmemory;

public interface IModelChanger {
    void notifyChange();

    void RegisterModelChanger(ModelChangedObserver o);
    void RemoveModelChanger(ModelChangedObserver o);
}
