package model;

import java.util.ArrayList;

abstract public class MilitaryUnits {
    private TypeOfUnits type;
    private Grade speed;
    private Grade attackPower;
    private Grade defensePower;
    private Moods mood;
    private static ArrayList<MilitaryUnits> allTheMilitaryUnits;

    public MilitaryUnits(TypeOfUnits type, Grade speed, Grade attackPower, Grade defensePower) {
        this.type = type;
        this.speed = speed;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }



    abstract public void distanceShot();

    public void setMood(Moods mood) {
        this.mood = mood;
    }

    public TypeOfUnits getType() {
        return type;
    }

    public Grade getSpeed() {
        return speed;
    }

    public Grade getAttackPower() {
        return attackPower;
    }

    public Grade getDefensePower() {
        return defensePower;
    }

    public Moods getMood() {
        return mood;
    }

    public static ArrayList<MilitaryUnits> getAllTheMilitaryUnits() {
        return allTheMilitaryUnits;
    }
}
