package controller;

import model.Map;
import view.MapMenu;

import java.util.ArrayList;

public class GameMenuController {
    public Game game;
    private Game currentGame;
    private ArrayList<Request> requests=new ArrayList<Request>();
    private ArrayList<Request> requestAcceptedAndSent=new ArrayList<Request>();

    public void showMap(int x, int y){
        MapMenu.run();
        for(){
            Map.showApartOfMap(x,y);
            if(Map.hasNotMilitary(x, y)==false){
                System.out.println("S");
                break;
            } else if (Map.hasNotBuilding(x, y)==false){
                if(Map.showApartOfMap(x,y).getListOfBuildings().contains(BuildingTypeCastle){
                    System.out.println("w");
                    break;
                }
                System.out.println("B");
                break;
            } else if (Map.hasNotTree(x,y)==false) {
                System.out.println("T");
                break;
            } else {
                System.out.println(Map.showApartOfMap(x,y).getGroundType());
            }
        }

    }
    public static int showFoodRate(){
        return null;
    }
}
