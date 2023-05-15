package model;

public class Cost {
    private String name;
    private int amount;
    public Cost(String name, int amount){
        this.name=name;
        this.amount=amount;

    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }
}
