package model;

import java.util.ArrayList;

public class Map {
  private Features[][] newMap;
  private Player owner;

    public Map(Features [][] newMap, Player owner) {
        this.newMap = newMap;
        this.owner = owner;
    }

    public void partsOfMap(Features[][] newMap){
        this.newMap = newMap;
        for(int i = 0; i <= 100; i++){
            for (int j = 0; j <= 100 ; j++) {
                newMap[i][j] = new Features();
            }
        }
    }

    public Features[][] getNewMap() {
        return newMap;
    }

    public Player getOwner() {
        return owner;
    }
}
