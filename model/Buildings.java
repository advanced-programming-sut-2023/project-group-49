package model;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.Stack;

 public class Buildings {
    private int x;
    private int y;
   /* private BuildingTypes buildingType;*/ // TODO
    private int cost;
    private int numberOfWorkers;
    private int health;
    private Map map;
    private int popularityRate;
    private int constants;
    private static ArrayList<Buildings> allTheBuildings;

    public Buildings(int x, int y, int health) {
        this.x = x;
        this.y = y;
        this.health = health;
    }


    public static void addBuilding(int x, int y, int health){
        allTheBuildings.add(new Buildings(x, y, health));
    }

    public int getCost() {
        return cost;
    }

    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public Map getMap() {
        return map;
    }

    public int getPopularityRate() {
        return popularityRate;
    }

    public int getConstants() {
        return constants;
    }

    public static ArrayList<Buildings> getAllTheBuildings() {
        return allTheBuildings;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setNumberOfWorkers(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setPopularityRate(int popularityRate) {
        this.popularityRate = popularityRate;
    }

    public void setConstants(int constants) {
        this.constants = constants;
    }
}
