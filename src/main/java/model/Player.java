package model;

import java.util.ArrayList;

public class Player {
    public static ArrayList<Sloldier> sloldiers;
    static {
        sloldiers= new ArrayList<>();
    }
    public static Sloldier getSoldierByFeature(int x,int y){
        if(sloldiers.size() == 0){
            return null;
        }
        for (Sloldier sloldier : sloldiers){
            if(sloldier.getX() == x && sloldier.getY() == y){
                return sloldier;
            }
        }
        return null;
    }
}
