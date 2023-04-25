package model;

import java.util.ArrayList;

public class CastleBuildings extends Buildings {
    private ArrayList<People> buildingMembers;
    private int capacity;


    public CastleBuildings(int x, int y, int health) {
        super(x, y, health);
    }

    public int defenseForce(BuildingTypeCastle castle){

    }

    public int buildingPopulation(BuildingTypeCastle castle){

    }

    public void changeTheTaxRate(BuildingTypeCastle castle){

    }

    public void addBuildingMembers(People people){

    }

    public void addArmourAndWeapon(WeaponWithArmor weapon){

    }

    public ArrayList<People> getBuildingMembers() {

        return buildingMembers;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
