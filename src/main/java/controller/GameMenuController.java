package controller;

import model.*;

import view.GameMenu;
import view.MainMenu;
import view.MapMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameMenuController {

    static ArrayList<String> users = new ArrayList<>();
    static Game game;
    static Player currentPlayer;
    static Player player;
    static int buildingX;
    static int buildingY;

    private static int x0;
    private static int y0;

    public static void showMap(Matcher matcher) {
        int x = Integer.parseInt(matcher.group("x"));
        int y = Integer.parseInt(matcher.group("y"));
        x0 = x;
        y0 = y;
        if (x < 0 || x > 20 || y < 0 || y > 20) {
            GameMenu.printMap(6, 0, 0);
        }
        for (int i = -1; i <= 1; i++) {
            int x1 = x + i;
            if (x1 < 0 || x1 > 20) {
                continue;
            }
            for (int j = -1; j <= 1; j++) {
                int y1 = y + j;
                if (y1 < 0 || y1 > 20) {
                    continue;
                } else {
                    if (!(Map.showApartOfMap(x1, y1).getAllUnit().isEmpty())) {
                        GameMenu.printMap(1, 0, 0);
                        break;
                    } else if (Map.showApartOfMap(x1, y1).getBuilding() != null) {
                        if (Map.showApartOfMap(x1, y1).getBuilding().) {
                            //TODO require "w" enum
                            GameMenu.printMap(2, 0, 0);
                            break;
                        } else {
                            GameMenu.printMap(3, 0, 0);
                            break;
                        }
                    } else if (Map.showApartOfMap(x, y).getTree() != null) {
                        GameMenu.printMap(4, 0, 0);
                        break;
                    } else {
                        GameMenu.printMap(5, x1, y1);
                    }
                }
            }
        }
    }

    public static Scanner input() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public static void mapMove(Matcher matcher) {
        String dir1 = matcher.group("dir1");
        String dir2 = matcher.group("dir2");
        String index;
        switch (dir1) {
            case "up":
                showMap(matcher);
                break;
            case "down":
                showMap(x, y - 1);
                break;
            case "left":
                showMap(x - 1, y);
                break;
            case "right":
                showMap(x + 1, y);
                break;
        }
        try {
            dir2 = matcher.group("dir2");

        } catch (NullPointerException ignored) {

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
    


    private static Sloldier currentSoldier;

    public Sloldier getCurrentSoldier() {
        return currentSoldier;
    }

    public static void setCurrentSoldier(Sloldier currentSoldier) {
        GameMenuController.currentSoldier = currentSoldier;
    }

    public static void selectUnit(int x, int y, Soldiers type) {
        Sloldier sloldier = new Sloldier(x, y, type);
        setCurrentSoldier(sloldier);
        currentSoldier.setPlayer(currentPlayer);
        GameMenu.print("unit selected successfully!");
    }

    public static void moveUnitTo(int x, int y) {
        int signX;
        int signY;
        if (currentSoldier.getX() < x) {
            signX = 1;
        } else {
            signX = -1;
        }
        if (currentSoldier.getY() < y) {
            signY = 1;
        } else {
            signY = -1;
        }
        while (true) {
            if (currentSoldier.getX() != x) {
                currentSoldier.setX(currentSoldier.getX() + signX);
                GameMenu.print("harkat ofoghi");
            }
            if (currentSoldier.getY() != y) {
                currentSoldier.setY(currentSoldier.getY() + signY);
                GameMenu.print("harkat amodi");
            }
            if (currentSoldier.getX() == x && currentSoldier.getY() == y) {
                GameMenu.print("arrived " + currentSoldier.getX() + " " + currentSoldier.getY());
                break;
            }
        }
    }

    public static void patrolUnit(int x1, int y1, int x2, int y2) {
        //TODO:checking if someone or something is on the way
        int signX;
        int signY;
        int i = 0;

        while (i <= 100) {
            if (i == 50) {
                GameMenu.print("soldiers are tired! you want them to continue?");
                String answer = MainMenu.getScanner().nextLine();
                if (answer.equals("no")) {
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
                GameMenu.print("harkat ofoghi");
            }
            if (currentSoldier.getY() != y2) {
                currentSoldier.setY(currentSoldier.getY() + signY);
                GameMenu.print("harkat amodi");
            }
            if (currentSoldier.getX() == x2 && currentSoldier.getY() == y2) {
                GameMenu.print("arrived " + currentSoldier.getX() + " " + currentSoldier.getY());

                tempX = x2;
                x2 = x1;
                x1 = tempX;

                tempY = y2;
                y2 = y1;
                y1 = tempY;

            }

            //TODO cheching if someone or something is on the way to attack


        }

    }


    public static void set(int x, int y, String mood) {
        currentSoldier.setMood(mood);
        GameMenu.print("mood set successfully!");
    }


    public static void attackEnemy(int enemyX, int enemyY) {
        //TODO fight with all soldiers
        if (Player.getSoldierByFeature(enemyX, enemyY) != null) {
            if (currentSoldier.getType().getAttackPower() >= Player.getSoldierByFeature(enemyX, enemyY)
                    .getType().getDefensePower()) {
                currentSoldier.setX(enemyX);
                currentSoldier.setY(enemyY);
                Player.getSoldierByFeature(enemyX, enemyY).setHealth(Player.getSoldierByFeature(enemyX, enemyY)
                        .getHealth() - 1);
                GameMenu.print("attacked successfully!!");
            } else
                GameMenu.print("you can not attack him! he is sooo strong");
        } else
            GameMenu.print("no one is here to kill!!");
    }


    public static void airAttack(int x, int y) {
        if (currentSoldier.getType().getName().equals("Archer") || currentSoldier.getType().getName().equals("Crossbowmen")
                || currentSoldier.getType().getName().equals("Archer Bow") ||
                currentSoldier.getType().getName().equals("Horse Archers")) {
            double distance = Math.sqrt(Math.pow(x - currentSoldier.getX(), 2) + Math.pow(y - currentSoldier.getY(), 2));
            if (distance <= currentSoldier.getType().getRange()) {
                if (Player.getSoldierByFeature(x, y) != null) {
                    Player.getSoldierByFeature(x, y).setHealth(Player.getSoldierByFeature(x, y).getHealth() - 1);
                    GameMenu.print("Good job Archer! You got the target");
                } else {
                    GameMenu.print("no one was there to kill");
                }
            } else {
                GameMenu.print("the target is too far from this Archer!");
            }
        } else {
            GameMenu.print("this unit can not do air attack!");
        }
    }

    public static void pourOil(String directions) {
        if (currentSoldier.getType().getName().equals("Engineer")) {
            switch (directions) {
                case "up":
                    GameMenu.print("Engineer: pouring oil upwards");
                case "down":
                    GameMenu.print("Engineer: pouring oil downwards");
                case "left":
                    GameMenu.print("Engineer: pouring oil leftwards");
                case "right":
                    GameMenu.print("Engineer: pouring oil rightwards");
            }
            //TODO go to oil station
        } else
            GameMenu.print("this unit can not pour oil!");
    }

    public static void digTunnel(int x, int y) {
        if (currentSoldier.getType().getName().equals("Tunneler")) {
            //TODO dig tunnel in thet part of map
            GameMenu.print("digging tunnel successfully!!");
        } else
            GameMenu.print("this unit can not dig tunnel!");
    }

    public static void build(String equipment) {
        if (currentSoldier.getType().getName().equals("Engineer")) {
            //TODO build equipment
            GameMenu.print("building equipment successfully!!");
        } else
            GameMenu.print("this unit can not dig tunnel!");
    }

    public static void disbandUnit() {
//        currentSoldier.setX();
//        currentSoldier.setY();
        GameMenu.print("this unit went to village!");
    }

    public void DFS() {

    }

    public void createGame() {
        game = new Game();
    }

    public static Player getPlayer() {
        return player;
    }

    public void addUserToGame(User user) {
        game.getPlayers().add((Player) user);
        player = (Player) user;
    }

    public String createBuilding(Matcher matcher) {
        int x = Integer.parseInt(matcher.group("x"));
        int y = Integer.parseInt(matcher.group("y"));
        String buildingType = matcher.group("buildingType");
        if (checkValidIndex(x, y).equals("success"))
            return checkCost(buildingType, x, y);
        else return checkValidIndex(x, y);

    }

    public String checkValidIndex(int x, int y) {
        if (x < 0 || y < 0 || x >= game.getMap().getMainMap().length || y > game.getMap().getMainMap().length)
            return "index not valid ";
        return "success";
    }

    public String checkCost(String buildingName, int x, int y) {
        String result = checkValidIndex(x, y);
        if (!result.equals("success"))
            return result;
        if (game.getMap().getMainMap()[x][y].getBuilding() != null)
            return "it is full";

        String pattern2 = "-(?<name>\\S+) (?<amount>[0-9]+)";
        String pattern3 = "\\((?<buildingType>\\S+)\\)";
        Pattern pattern = Pattern.compile(pattern2);
        String data = readFile(buildingName);
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            if (player.getCostByName(matcher.group("name")).getAmount() > Integer.parseInt
                    (matcher.group("amount"))) {
                return "doesn't have enough " + matcher.group("name");

            }
        }


        Pattern pattern1 = Pattern.compile(pattern3);
        Matcher matcher1 = pattern1.matcher(data);
        while (matcher1.find()) {
            switch (matcher1.group("buildingType")) {
                case "castle": {
                    if (game.getMap().getMainMap()[x][y].getGroundType() != GroundTypes.GROUND && game.getMap().getMainMap()[x][y]
                            .getGroundType() != GroundTypes.GARAVELGROUND && game.getMap().getMainMap()[x][y].getGroundType() != GroundTypes.GRASS)
                        return "you can't build here ";
                    CastleBuildings castleBuildings = new CastleBuildings(buildingName);
                    game.getMap().getMainMap()[x][y].setBuilding(castleBuildings);
                    while (matcher.find()) {
                        castleBuildings.getCosts().add(new Cost(matcher.group("name"), Integer.parseInt(matcher.group("amount"))));
                    }
                }
                case "farm": {
                    if (game.getMap().getMainMap()[x][y].getGroundType() != GroundTypes.GRASS && game.getMap().getMainMap()[x][y]
                            .getGroundType() != GroundTypes.DENSEGRASELAND)
                        return "you can't build here";
                    FarmBuildings farmBuildings = new FarmBuildings(buildingName);
                    game.getMap().getMainMap()[x][y].setBuilding(farmBuildings);
                    while (matcher.find()) {
                        farmBuildings.getCosts().add(new Cost(matcher.group("name"), Integer.parseInt(matcher.group("amount"))));
                    }
                }
                case "food processing" : {
                    if (game.getMap().getMainMap()[x][y].getGroundType() != GroundTypes.GROUND && game.getMap().getMainMap()[x][y]
                            .getGroundType() != GroundTypes.GARAVELGROUND && game.getMap().getMainMap()[x][y].getGroundType() != GroundTypes.GRASS)
                        return "you can't build here ";
                    FoodProcessingBuildingsAndWeaponBuildings foodProcessingBuildingsAndWeaponBuildings = new FoodProcessingBuildingsAndWeaponBuildings(buildingName);
                    game.getMap().getMainMap()[x][y].setBuilding(foodProcessingBuildingsAndWeaponBuildings);
                    while (matcher.find()) {
                        foodProcessingBuildingsAndWeaponBuildings.getCosts().add(new Cost(matcher.group("name"), Integer.parseInt(matcher.group("amount"))));
                    }
                }
                case "town": {
                    if (game.getMap().getMainMap()[x][y].getGroundType() != GroundTypes.GROUND && game.getMap().getMainMap()[x][y]
                            .getGroundType() != GroundTypes.GARAVELGROUND && game.getMap().getMainMap()[x][y].getGroundType() != GroundTypes.GRASS)
                        return "you can't build here ";
                    TownBuildings townBuildings = new TownBuildings(buildingName);
                    game.getMap().getMainMap()[x][y].setBuilding(townBuildings);
                    while (matcher.find()) {
                        townBuildings.getCosts().add(new Cost(matcher.group("name"), Integer.parseInt(matcher.group("amount"))));
                    }
                }
                case "industry": {
                    try {
                        if (!Industry.getGroundTypeByName(buildingName).getGroundTypes().equals(game.getMap().getMainMap()[x][y].getGroundType()))
                            return "you can't build here";
                    } catch (NullPointerException ignored) {

                    }
                    IndustryBuildings industryBuildings = new IndustryBuildings(buildingName);
                    game.getMap().getMainMap()[x][y].setBuilding(industryBuildings);
                    while (matcher.find()) {
                        industryBuildings.getCosts().add(new Cost(matcher.group("name"), Integer.parseInt(matcher.group("amount"))));
                    }
                }
            }

        }

        return "successful";
    }

    public String selectBuilding(Matcher matcher) {
        int x = Integer.parseInt(matcher.group("x"));
        int y = Integer.parseInt(matcher.group("y"));
        String result = checkValidIndex(x, y);
        if (!result.equals("success"))
            return result;
        else if (game.getMap().getMainMap()[x][y].getBuilding() == null)
            return "building is not exsits";
        else if (!game.getMap().getMainMap()[x][y].getBuilding().getPlayer().equals(player))
            return "this building isn't for you";
        buildingX = x;
        buildingY = y;
        return "building successfully selected";
    }

    public String createUnit(Matcher matcher) {
        String type = matcher.group("type");
        int count = Integer.parseInt(matcher.group("count"));
        String buildingName = game.getMap().getMainMap()[buildingX][buildingY].getBuilding().getBuildingName();
        if (game.getMap().getMainMap()[buildingX][buildingY].getBuilding().getClass().getName().equals("CastleBuilding")) {
            try {
                CastleBuildings castleBuildings = (CastleBuildings) game.getMap().getMainMap()[buildingX][buildingY].getBuilding();
                castleBuildings.setUnitCost(buildingName);
                int unitCost;
                int ladderManCost;
                int engineerCost;
                switch (buildingName) {
                    case "barracks":
                        unitCost = castleBuildings.getUnitCost();
                        break;
                    case "engineer guild":
                        ladderManCost = castleBuildings.getLadderManCost();
                        engineerCost = castleBuildings.getEngineerCost();
                        break;
                    default:
                        return "this building can't create unit";
                }
            } catch (NullPointerException ignord) {

            }


        }

        return "successful";
    }

    public String readFile(String startString) {
        String data = new String();
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                if (data.startsWith(startString)) {

                    break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }

}

