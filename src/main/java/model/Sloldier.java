package model;

public class Sloldier {
    Soldiers type;
    int health=10;//mizan salamati fard ro az 10 dar nazar gereftim!

    public Sloldier(Soldiers type) {
        this.type=type;
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
