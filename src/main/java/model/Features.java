package model;

import java.util.ArrayList;

public class Features {
    private static ArrayList<MilitaryUnits> listOfUnits;
    private ArrayList<Buildings> listOfBuildings;
    private GroundTypes groundType;
    private String tree;


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

    public  ArrayList<MilitaryUnits> getListOfUnits() {
        return listOfUnits;
    }

    public ArrayList<Buildings> getListOfBuildings() {
        return listOfBuildings;
    }

    public GroundTypes getGroundType() {
        return groundType;
    }

    public String getTree() {
        return tree;
    }

    public void setTree(String tree) {
        this.tree = tree;
    }
}
