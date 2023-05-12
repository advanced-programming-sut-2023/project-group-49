package model;

import java.util.ArrayList;

public class Map {
    private static Features[][] mainMap;
    private Player owner;


    public Map(Features [][] mainMap, Player owner) {
        this.mainMap = mainMap;
        this.owner = owner;
    }

    public void partsOfMap(Features[][] newMap){
        this.mainMap = newMap;
        for(int i = 0; i <= 100; i++){
            for (int j = 0; j <= 100 ; j++) {
                newMap[i][j] = new Features();
            }
        }
    }

    public  Features[][] getMainMap() {
        return mainMap;
    }

    public Player getOwner() {
        return owner;
    }

    public static Features showApartOfMap(int x, int y){
        return Map.mainMap[x][y];
    }

    public static boolean hasNotMilitary(int x, int y){
        return mainMap[x][y].getListOfUnits().isEmpty();
    }

    public static boolean hasNotBuilding(int x, int y){
        return mainMap[x][y].getListOfBuildings().isEmpty();
    }

    public static boolean hasNotTree(int x, int y){
        return mainMap[x][y].getTree().isEmpty();
    }


}
