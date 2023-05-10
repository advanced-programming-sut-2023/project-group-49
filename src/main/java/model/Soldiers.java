package model;


public enum Soldiers {
    //very low=2
    //low=4
    //average=8
    //much=16
    //very much=32
    ARCHER("Archer", "much", "low", "low", "16",
            "european", "bow"),
    SPEARMEN("Spearmen", "average", "average", "very low", "8",
            "european", "spear"),
    TUNNELER("Tunneler", "much", "average", "very low", "16",
            "european", "pick axe"),
    LADDERMEN("Laddermen", "much", "null", "very low", "16",
            "european", "null"),
    ENGINEER("Engineer", "average", "null", "very low", "8",
            "european", "null"),
    BLACK_MONCK("Black Monk", "low", "average", "average", "4",
            "european", "staff"),
    ARCHER_BOW("Archer Bow", "much", "low", "low", "16",
            "arabian", "bow"),
    SLAVES("Slaves", "much", "very very low", "very very low", "16",
            "arabian", "torch"),
    SLINGERS("Slingers", "much", "low", "very low", "16",
            "arabian", "sling"),
    ASSASSINS("Assassins", "average", "average", "average", "8",
            "arabian", "scimitar"),
    CROSSBOWMEN("Crossbowmen", "low", "low", "average", "4",
            "european", "crossbow"),
    PIKEMEN("Pikemen", "low", "average", "much", "4",
            "european", "pike"),
    MACEMEN("Macemen", "average", "much", "average", "8",
            "european", "mace"),
    SWORDSMEN("Swordsmen", "very very low", "very much", "very low", "1",
            "european", "sword"),
    KNIGHT("Knight", "very much", "very much", "much", "32",
            "european", "sword"),
    HORSE_ARCHERS("Horse Archers", "very much", "low", "average", "32",
            "arabian", "bow"),
    ARABIAN_SWORDSMEN("Arabian Swordsmen", "very much", "much", "much", "32",
            "arabian", "scimitar"),
    FIRE_THROWERS("Fire Throwers", "very much", "much", "low", "32",
            "arabian", "greek fire");


    private String name;
    private String speed;
    private String attackPower;
    private String defensePower;
    private String range;
    private String nationality;
    private String weapon;


    private Soldiers(String name, String speed, String attackPower, String defensePower, String range,
                     String nationality, String weapon) {
        this.name = name;
        this.speed = speed;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.range = range;
        this.nationality = nationality;
        this.weapon = weapon;

    }

    


}
