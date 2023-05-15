package controller;

import model.Buildings;
import model.Map;
import model.Materials;
import model.MilitaryUnits;
import org.omg.CORBA.Request;
import view.GameMenu;
import view.MapMenu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

public class GameMenuController {
    public Game game;
    private Game currentGame;
    private ArrayList<Request> requests=new ArrayList<Request>();
    // TODO what is request class
    private ArrayList<Request> requestAcceptedAndSent=new ArrayList<Request>();
    private static int x0;
    private static int y0;
    public static void showMap(Matcher matcher){
        int x = Integer.parseInt(matcher.group("x"));
        int y = Integer.parseInt(matcher.group("y"));
         x0 = x;
         y0 = y;
        if(x<0 || x>20 || y<0 || y>20){
            GameMenu.printMap(6,0,0);
        }
        for(int i=-1; i<=1; i++){
            int x1=x+i;
            if(x1<0 || x1>20){
                continue;
            }
            for(int j=-1; j<=1; j++){
                int y1=y+j;
                if(y1<0 || y1>20){
                    continue;
                } 
                else{
                    if(!(Map.showApartOfMap(x1,y1).getAllUnit().isEmpty())){
                        GameMenu.printMap(1,0,0);
                        break;
                    } else if (Map.showApartOfMap(x1,y1).getBuilding() != null) {
                        if(Map.showApartOfMap(x1,y1).getBuilding().) {
                            //TODO require "w" enum
                            GameMenu.printMap(2, 0, 0);
                            break;
                        } 
                        else{
                            GameMenu.printMap(3, 0, 0);
                            break;  
                        }
                    } else if (Map.showApartOfMap(x,y).getTree() != null) {
                        GameMenu.printMap(4,0,0);
                        break;
                    }
                    else {
                        GameMenu.printMap(5,x1,y1);
                    }
                }
            }
        }
    }

    public static Scanner input(){
        Scanner scanner=new Scanner(System.in);
        return scanner;
    }

    public static void mapMove(Matcher matcher){
        String dir1 = matcher.group("dir1");
        String dir2 = matcher.group("dir2");
        String index ;
        switch (dir1){
            case "up":
                showMap(matcher);
                break;
            case "down":
                showMap(x,y-1);
                break;
            case"left":
                showMap(x-1,y);
                break;
            case "right":
                showMap(x+1,y);
                break;
        }
        try{
             dir2= matcher.group("dir2");

        }
        catch (NullPointerException ignored){

        }
    }


    /*public static void showDetails(int x, int y) {
        ArrayList<MilitaryUnits> allSoldiers = new ArrayList<>();
        ArrayList<Buildings> allBuildings = new ArrayList<>();
        for () {
            if(Map.showApartOfMap(x,y).getMilitaryUnit() != null){
                allSoldiers.add(Map.showApartOfMap(x,y).getMilitaryUnit());
                System.out.println(Map.showApartOfMap(x,y).getMilitaryUnit());
            }
            if(Map.showApartOfMap(x,y).getBuilding() != null){
                allBuildings.add(Map.showApartOfMap(x,y).getBuilding());
                System.out.println(Map.showApartOfMap(x,y).getBuilding());
            }
            if(!(Materials.valueOf("gold").equals(0))){
                System.out.println("gold" + ":" + Materials.valueOf("gold"));
            }
            System.out.println(Map.showApartOfMap(x,y).getGroundType());
            ;

        }
    }*/

    public static int showFoodRate(){
        return null;
    }
}
