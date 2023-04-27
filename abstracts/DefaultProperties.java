package Java.GeekB.abstracts;

public abstract class DefaultProperties extends Identity {
    protected String name;

    protected int weight;

    public DefaultProperties(int gid, String name, int weight) {
        super(gid);
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }


    public int getWeight() {
        return weight;
    }
}
