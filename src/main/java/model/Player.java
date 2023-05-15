package model;

import java.util.ArrayList;

public class Player extends User {
    private ArrayList<Cost>costs;
    public static ArrayList<Sloldier> sloldiers;
    static {
        sloldiers= new ArrayList<>();
    }
    public Player(String username, String password, String nickname, String email) {
        super(username, password, nickname, email);
        this.costs=new ArrayList<>();
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
    public ArrayList<Cost> getCosts() {
        return costs;
    }

    public Cost getCostByName(String name){
        for(Cost cost:this.costs){
            if(cost.getName().equals(name)){
                return cost;
            }
        }
        return null;
    }
}
