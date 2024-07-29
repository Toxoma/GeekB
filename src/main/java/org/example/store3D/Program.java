package org.example.store3D;

import org.example.store3D.inmemory.ModelStore;
import org.example.store3D.inmemory.Observer1;
import org.example.store3D.models.Polygon;
import org.example.store3D.models.PolygonModel;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Observer1 observer1 = new Observer1();
        ModelStore store = new ModelStore();
        store.RegisterModelChanger(observer1);
        Polygon p1 = new Polygon();
        List<Polygon> polygons = new ArrayList<>();
        polygons.add(p1);
        PolygonModel polygonModel = new PolygonModel(polygons);
        store.add(polygonModel);
    }
}