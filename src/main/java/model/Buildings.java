package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Buildings {
    private int x;
    private int y;
    private int numberOfWorkers;
    private int health;
    private Map map;
    private int popularityRate;
    private int constants;
    private static ArrayList<Buildings> allTheBuildings;
    ArrayList<Cost>costs;
    private Player player;
    private String buildingName;
    public void setNumberOfWorkers(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public ArrayList<Cost> getCosts() {
        return this.costs;
    }
    public Cost getCostByName(String name){
        for(Cost cost:this.costs){
            if(cost.getName().equals(name)){
                return cost;
            }
        }
        return null;
    }

    public Player getPlayer() {
        return player;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setUnitCost(String buildingName){

    }
}
