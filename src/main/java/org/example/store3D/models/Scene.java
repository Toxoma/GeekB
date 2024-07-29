package org.example.store3D.models;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private int id;
    private List<PolygonModel> models;
    private List<Flash> flashes;

    public Scene(List<PolygonModel> models) {
        this.models = models;
    }

    public Scene(List<PolygonModel> models, List<Flash> flashes) {
        this.models = models;
        this.flashes = flashes;
    }

    public int getId() {
        return id;
    }

    public List<PolygonModel> getModels() {
        return models;
    }

    public List<Flash> getFlashes() {
        return flashes;
    }
}
