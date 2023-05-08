package model;


public class People {
    private  int cost;
    //private final Map destination;
    private int health;
    private int x;
    private int y;


    public People(int health, int x, int y) {
        this.health = health;
        this.x = x;
        this.y = y;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

}
