package controller;

import model.Buildings;
import model.Map;
import model.Materials;
import model.MilitaryUnits;

import model.Player;
import model.Sloldier;
import model.Soldiers;
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


    private static Sloldier currentSoldier;

    public Sloldier getCurrentSoldier() {
        return currentSoldier;
    }

    public static void setCurrentSoldier(Sloldier currentSoldier) {
        GameMenuController.currentSoldier = currentSoldier;
    }

    public static void selectUnit(int x, int y, Soldiers type){
        Sloldier sloldier = new Sloldier(x,y,type);
        setCurrentSoldier(sloldier);

    }
    public static void moveUnitTo(int x,int y){
        int signX;
        int signY;
        if(currentSoldier.getX()<x){
            signX=1;
        }else {
            signX=-1;
        }
        if(currentSoldier.getY()<y){
            signY=1;
        }else {
            signY=-1;
        }
        while (true){
            if(currentSoldier.getX()!=x){
                currentSoldier.setX(currentSoldier.getX()+signX);
                System.out.println("harkat ofoghi");
            }
            if(currentSoldier.getY()!=y){
                currentSoldier.setY(currentSoldier.getY()+signY);
                System.out.println("harkat amodi");
            }
            if(currentSoldier.getX()==x && currentSoldier.getY()==y){
                System.out.println("arrived " + currentSoldier.getX()+" " + currentSoldier.getY());
                break;
            }
        }
    }
    public static void patrolUnit(int x1,int y1,int x2,int y2){
        //TODO:checking if someone or something is on the way
        int signX;
        int signY;
        int i=0;

        while (i<=100) {
            if(i==50){
                System.out.println("soldiers are tired! you want them to continue?");
                String answer= GameMenu.getScanner().nextLine();
                if(answer.equals("no")){
                    break;
                }
            }
            try {
                Thread.sleep(1 / (currentSoldier.getType().getSpeed()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
            if (x1 < x2) {
                signX = 1;
            } else {
                signX = -1;
            }
            if (y1 < y2) {
                signY = 1;
            } else {
                signY = -1;
            }


            int tempX = 0;
            int tempY = 0;
            currentSoldier.setX(x1);
            currentSoldier.setY(y1);
            if (currentSoldier.getX() != x2) {
                currentSoldier.setX(currentSoldier.getX() + signX);
                System.out.println("harkat ofoghi");
            }
            if (currentSoldier.getY() != y2) {
                currentSoldier.setY(currentSoldier.getY() + signY);
                System.out.println("harkat amodi");
            }
            if (currentSoldier.getX() == x2 && currentSoldier.getY() == y2) {
                System.out.println("arrived " + currentSoldier.getX()+" " + currentSoldier.getY());

                tempX = x2;
                x2 = x1;
                x1 = tempX;

                tempY = y2;
                y2 = y1;
                y1 = tempY;

            }
            if(currentSoldier.getX() ==  && currentSoldier.getY() == ){
                //TODO cheching if someone or something is on the way to attack
            }

        }

    }


    public static void set(int x,int y,String mood){
        currentSoldier.setMood(mood);
    }


    public static void attackEnemy(int enemyX,int enemyY){
        //TODO fight with all soldiers
        if(Player.getSoldierByFeature(enemyX,enemyY)!= null) {
            if (currentSoldier.getType().getAttackPower() >= Player.getSoldierByFeature(enemyX, enemyY)
                    .getType().getDefensePower()) {
                currentSoldier.setX(enemyX);
                currentSoldier.setY(enemyY);
                Player.getSoldierByFeature(enemyX, enemyY).setHealth(Player.getSoldierByFeature(enemyX, enemyY)
                        .getHealth() - 1);
                System.out.println("attacked successfully!!");
            } else
                System.out.println("you can not attack him! he is sooo strong");
        }else
            System.out.println("no one is here to kill!!");
    }


    public static void airAttack(int x,int y){
        if(currentSoldier.getType().getName().equals("Archer")||currentSoldier.getType().getName().equals("Crossbowmen")
                ||currentSoldier.getType().getName().equals("Archer Bow")||
                currentSoldier.getType().getName().equals("Horse Archers")){
            double distance= Math.sqrt(Math.pow(x-currentSoldier.getX(),2)+Math.pow(y-currentSoldier.getY(),2));
            if(distance<=currentSoldier.getType().getRange()){
                if(Player.getSoldierByFeature(x,y)!=null){
                    Player.getSoldierByFeature(x,y).setHealth(Player.getSoldierByFeature(x,y).getHealth()-1);
                    System.out.println("Good job Archer! You got the target");
                }else {
                    System.out.println("no one was there to kill");
                }
            }else{
                System.out.println("the target is too far from this Archer!");
            }
        }
        else {
            System.out.println("this unit can not do air attack!");
        }
    }
    public void pourOil(String directions){
        if(currentSoldier.getType().getName().equals("Engineer")){
            switch (directions){
                case "up":
                    System.out.println("Engineer: pouring oil upwards");
                case "down":
                    System.out.println("Engineer: pouring oil downwards");
                case "left":
                    System.out.println("Engineer: pouring oil leftwards");
                case "right":
                    System.out.println("Engineer: pouring oil rightwards");
            }
            //TODO go to oil station
        }else
            System.out.println("this unit can not pour oil!");
    }
    public void digTunnel(int x,int y){
        if(currentSoldier.getType().getName().equals("Tunneler")){
            //TODO dig tunnel in thet part of map
            System.out.println("digging tunnel successfully!!");
        }else
            System.out.println("this unit can not dig tunnel!");
    }
    public void build(String equipment){
        if(currentSoldier.getType().getName().equals("Engineer")) {
            //TODO build equipment
            System.out.println("building equipment successfully!!");
        }else
            System.out.println("this unit can not dig tunnel!");
    }

    public void disbandUnit(){
        currentSoldier.setX();
        currentSoldier.setY();
        System.out.println("this unit went to village!");
    }

    public void DFS(){

    }

}

