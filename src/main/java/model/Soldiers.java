package model;


public enum Soldiers {
    //very low=2
    //low=4
    //average=8
    //much=16
    //very much=32
    ARCHER("Archer", 16, 4, 4, 16,
            "european", "bow"),
    SPEARMEN("Spearmen", 8, 8, 2, 8,
            "european", "spear"),
    TUNNELER("Tunneler", 16, 8, 2, 16,
            "european", "pick axe"),
    LADDERMEN("Laddermen", 16, 0, 2, 16,
            "european", "null"),
    ENGINEER("Engineer", 8, 0, 2, 8,
            "european", "null"),
    BLACK_MONCK("Black Monk", 4, 8, 8, 4,
            "european", "staff"),
    ARCHER_BOW("Archer Bow", 16, 4, 4, 16,
            "arabian", "bow"),
    SLAVES("Slaves", 16, 1, 1, 16,
            "arabian", "torch"),
    SLINGERS("Slingers", 16, 4, 2, 16,
            "arabian", "sling"),
    ASSASSINS("Assassins", 8, 8, 8, 8,
            "arabian", "scimitar"),
    CROSSBOWMEN("Crossbowmen", 4, 4, 8, 4,
            "european", "crossbow"),
    PIKEMEN("Pikemen", 4, 8, 16, 4,
            "european", "pike"),
    MACEMEN("Macemen", 8, 16, 8, 8,
            "european", "mace"),
    SWORDSMEN("Swordsmen", 1, 32, 2, 1,
            "european", "sword"),
    KNIGHT("Knight", 32, 32, 16, 32,
            "european", "sword"),
    HORSE_ARCHERS("Horse Archers", 32, 4, 8, 32,
            "arabian", "bow"),
    ARABIAN_SWORDSMEN("Arabian Swordsmen", 32, 16, 16, 32,
            "arabian", "scimitar"),
    FIRE_THROWERS("Fire Throwers", 32, 16, 4, 32,
            "arabian", "greek fire");


    private String name;
    private int speed;
    private int attackPower;
    private int defensePower;
    private int range;
    private String nationality;
    private String weapon;


    private Soldiers(String name, int speed, int attackPower, int defensePower, int range,
                     String nationality, String weapon) {
        this.name = name;
        this.speed = speed;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.range = range;
        this.nationality = nationality;
        this.weapon = weapon;

    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public int getRange() {
        return range;
    }

    public String getNationality() {
        return nationality;
    }

    public String getWeapon() {
        return weapon;
    }
}
