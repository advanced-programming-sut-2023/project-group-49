package model;

import java.util.ArrayList;

public class IndustryBuildings extends Buildings{
    private String buildingName;
    public IndustryBuildings(String buildingName){
        this.buildingName=buildingName;
        this.costs=new ArrayList<>();
    }
}
