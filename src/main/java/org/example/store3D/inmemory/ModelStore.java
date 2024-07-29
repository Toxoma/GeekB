package org.example.store3D.inmemory;

import org.example.store3D.models.Camera;
import org.example.store3D.models.Flash;
import org.example.store3D.models.PolygonModel;
import org.example.store3D.models.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger{
    private List<ModelChangedObserver> observers = new ArrayList<>();
    private List<PolygonModel> models = new ArrayList<>();
    private List<Scene> scenes = new ArrayList<>();;
    private List<Flash> flashes = new ArrayList<>();;
    private List<Camera> cameras = new ArrayList<>();;

    public Scene getScena(int id){
        return this.scenes.stream()
                .filter(scene -> scene.getId() == id)
                .findAny()
                .orElse(null);
    }

    public List<PolygonModel> getModels() {
        return models;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public List<Flash> getFlashes() {
        return flashes;
    }

    public List<Camera> getCameras() {
        return cameras;
    }

    public void add(PolygonModel model){
        models.add(model);
        notifyChange();
    }

    @Override
    public void notifyChange() {
        for (ModelChangedObserver observer : observers){
            observer.applyUpdateModel();
        }
    }

    @Override
    public void RegisterModelChanger(ModelChangedObserver o) {
        observers.add(o);
    }

    @Override
    public void RemoveModelChanger(ModelChangedObserver o) {
        observers.remove(o);
    }
}
