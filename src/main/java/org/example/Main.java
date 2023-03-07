package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Creature> sprinters = new ArrayList<>();
        sprinters.add(new Cat("Тим", 100, 100));
        sprinters.add(new Robot("Оптимус", 200, 200));
        sprinters.add(new Human("Ден", 300, 300));

        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Road(100));
        obstacles.add(new Wall(100));
        obstacles.add(new Road(200));
        obstacles.add(new Wall(200));
        obstacles.add(new Wall(300));
        obstacles.add(new Road(300));

        for (Creature sprinter : sprinters) {
            for (Obstacle obstacle : obstacles) {
                if (sprinter.getFail()) break;

                if (obstacle.getName() == "Wall") {
                    sprinter.jump(obstacle);
                }else{
                    sprinter.run(obstacle);
                }
            }

            sprinter.finish();
            System.out.println();
        }
    }
}