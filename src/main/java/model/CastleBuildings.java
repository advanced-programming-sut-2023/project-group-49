package model;

import controller.GameMenuController;

import java.util.ArrayList;
import java.util.HashMap;

public class CastleBuildings extends Buildings {
    private int capacity;
    private String buildingName;
    private int unitCost;
    private int ladderManCost;
    private int engineerCost;
    public CastleBuildings(String buildingName){
        this.buildingName=buildingName;
        this.costs=new ArrayList<>();
    }
    @Override
    public void setUnitCost(String buildingName) {
        switch (buildingName){
            case "barracks":
                this.unitCost=1;
                break;
            case "mercenary post":
                this.unitCost=5;
                break;
            case "engineer guild":
                this.ladderManCost=2;
                this.engineerCost=5;
                break;
        }
    }

    public int getEngineerCost() {
        return this.engineerCost;
    }

    public int getLadderManCost() {
        return this.ladderManCost;
    }

    public int getUnitCost() {
        return this.unitCost;
    }

}
