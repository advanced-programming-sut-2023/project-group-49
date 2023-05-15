package model;

public class Sloldier {
    Soldiers type;
    int x;
    int y;
    String mood;
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    int health=7;//mizan salamati fard ro az 10 dar nazar gereftim!

    public Sloldier(int x,int y,Soldiers type) {
        this.type=type;
        this.x=x;
        this.y=y;
    }



    public Soldiers getType() {
        return type;
    }

    public void setType(Soldiers type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}