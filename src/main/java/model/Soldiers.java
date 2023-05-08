package model;

import view.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Soldiers {
    ARCHER("Archer", "much", "low", "low", "",
            "european", "bow"),
    SPEARMEN("Spearmen", "average", "average", "very low", "",
            "european", "spear"),
    TUNNELER("Tunneler", "much", "average", "very low", "",
            "european", "pick axe"),
    LADDERMEN("Laddermen", "much", "null", "very low", "",
            "european", "null"),
    ENGINEER("Engineer", "average", "null", "very low", "",
            "european", "null"),
    BLACK_MONCK("Black Monk", "low", "average", "average", "",
            "european", "staff"),
    ARCHER_BOW("Archer Bow", "much", "low", "low", "",
            "arabian", "bow"),
    SLAVES("Slaves", "much", "very very low", "very very low", "",
            "arabian", "torch"),
    SLINGERS("Slingers", "much", "low", "very low", "",
            "arabian", "sling"),
    ASSASSINS("Assassins", "average", "average", "average", "",
            "arabian", "scimitar"),
    CROSSBOWMEN("Crossbowmen", "low", "low", "average", "",
            "european", "crossbow"),
    PIKEMEN("Pikemen", "low", "average", "much", "",
            "european", "pike"),
    MACEMEN("Macemen", "average", "much", "average", "",
            "european", "mace"),
    SWORDSMEN("Swordsmen", "very very low", "very much", "very low", "",
            "european", "sword"),
    KNIGHT("Knight", "very much", "very much", "much", "",
            "european", "sword"),
    HORSE_ARCHERS("Horse Archers", "very much", "low", "average", "",
            "arabian", "bow"),
    ARABIAN_SWORDSMEN("Arabian Swordsmen", "very much", "much", "much", "",
            "arabian", "scimitar"),
    FIRE_THROWERS("Fire Throwers", "very much", "much", "low", "",
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

    public static Matcher getMatcher(String input, Commands command) {
        Matcher matcher = Pattern.compile(command.regex).matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }


}
