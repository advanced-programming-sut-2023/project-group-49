package model;

import java.util.ArrayList;

public class Features {
   private ArrayList<MilitaryUnits> listOfUnits;
    private ArrayList<Buildings> listOfBuildings;
    private GroundTypes groundType;

    public Features() {

    }

    public void setListOfUnits(ArrayList<MilitaryUnits> listOfUnits) {
        this.listOfUnits = listOfUnits;
    }

    public void setListOfBuildings(ArrayList<Buildings> listOfBuildings) {
        this.listOfBuildings = listOfBuildings;
    }

    public void setGroundType(GroundTypes groundType) {
        this.groundType = groundType;
    }

    public ArrayList<MilitaryUnits> getListOfUnits() {
        return listOfUnits;
    }

    public ArrayList<Buildings> getListOfBuildings() {
        return listOfBuildings;
    }

    public GroundTypes getGroundType() {
        return groundType;
    }
}
