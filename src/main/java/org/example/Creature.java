package org.example;

abstract class Creature {
    private String name;
    private Boolean fail = false;
    private int maxRun;
    private int maxJump;

    public Creature(String name, int maxRun, int maxJump) {
        this.setName(name);
        this.setMaxRun(maxRun);
        this.setMaxJump(maxJump);
    }

    public void setFail() {
        System.out.printf("Участник %s выбывает!\n", this.getName());
        this.fail = true;
    }

    public void run(Obstacle road) {
        System.out.printf("Длина дорожки %d\n", road.getScale());
        System.out.printf("%s бежит... ", this.getName());
        if (this.maxRun < road.getScale()) {
            System.out.printf("%s устаёт...\n", this.getName());
            this.setFail();
        }else{
            System.out.println("Дистанция пройдена!");
        }
    }

    public void jump(Obstacle wall) {
        System.out.printf("Высота стены %d\n", wall.getScale());
        System.out.printf("%s прыгает... ", this.getName());
        if (this.maxJump < wall.getScale()) {
            System.out.println("Недолёт...");
            this.setFail();
        }else{
            System.out.println("Прыжок успешен");
        }
    }

    public void finish(){
        if (!this.getFail())
            System.out.printf("Участник %s заканчивает гонку! Поздравляем!!!\n", this.getName());
    }

//    _________________________
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFail() {
        return fail;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public void setMaxRun(int maxRun) {
        this.maxRun = maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public void setMaxJump(int maxJump) {
        this.maxJump = maxJump;
    }
}
