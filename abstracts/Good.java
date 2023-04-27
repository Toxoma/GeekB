package Java.GeekB.abstracts;

public abstract class Good extends Identity {
    private static int GLOBAL_ID = 0;
    protected String name;
    protected int weight;
    protected int amount;

    public Good(String name, int weight, int amount) {
        super(++GLOBAL_ID);
        this.name = name;
        this.weight = weight;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    protected void setAmount(int amount) {
        this.amount = amount;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
