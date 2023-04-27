package Java.GeekB;


import Java.GeekB.abstracts.DefaultProperties;

public class Toy extends DefaultProperties {
    private static int GLOBAL_ID = 0;

    public Toy(String name, int weight) {
        super(++GLOBAL_ID, name, weight);
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
