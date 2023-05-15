package view;


import controller.GameMenuController;
import model.Map;


import model.Sloldier;
import model.Soldiers;

import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GameMenu {

    static int x;
    static int y;
    static int X;
    static int Y;
    static String mood;
    static int enemyX;
    static int enemyY;
    static String direction;
    static String equipment;
    static Soldiers type;
    static String typeName;


    public static void run(String command1) {
        GameMenuController.separatorUsers(command1);
        while (true) {
            String command = MainMenu.getScanner().nextLine();
            Matcher matcher;
            if (command.equals("user logout")) {
                System.out.println("user logged out successfully!");
                break;

            } else if ((matcher = Commands.getMatcher(command, Commands.SHOW_MAP)) != null)
                GameMenuController.showMap(matcher);
            else if ((matcher = Commands.getMatcher(command, Commands.MOVE_MAP)) != null)
                GameMenuController.mapMove(matcher);
            else if (Commands.getMatcher(command, Commands.SELECTUNIT) != null)
                selectUnit(command);
            else if (Commands.getMatcher(command, Commands.MOVEUNITTO) != null)
                moveUnitTo(command);
            else if (Commands.getMatcher(command, Commands.PATROL_UNIT) != null)
                patrolUnit(command);
            else if (Commands.getMatcher(command, Commands.SET) != null)
                set(command);
            else if (Commands.getMatcher(command, Commands.ATTACK_ENEMY) != null)
                attackEnemy(command);
            else if (Commands.getMatcher(command, Commands.AIR_ATTACK) != null)
                airAttack(command);
            else if (Commands.getMatcher(command, Commands.POUR_OIL) != null)
                pourOil(command);
            else if (Commands.getMatcher(command, Commands.DIG_TUNNEL) != null)
                digTunnel(command);
            else if (Commands.getMatcher(command, Commands.BUILD) != null)
                build(command);
            else if (Commands.getMatcher(command, Commands.DISBANDUNIT) != null)
                disbandUnit(command);
            else
                System.out.println("Invalid command!");
        }
    }


    public static void printMap(int num, int x, int y) {
        while (true) {
            if (num == 1) {
                System.out.println("S");
                break;
            } else if (num == 2) {
                System.out.println("w");
                break;
            } else if (num == 3) {
                System.out.println("B");
                break;
            } else if (num == 4) {
                System.out.println("T");
                break;
            } else if (num == 5) {
                System.out.println(Map.showApartOfMap(x, y).getGroundType());
                break;
            } else {
                System.out.println("can not move or show map!");
            }
        }
    }


    public static void selectUnit(String command) {
        separatorGaming(command);
        try {
            GameMenuController.selectUnit(x,y,type);
        }catch (NullPointerException ignored){

        }


    }

    public static void moveUnitTo(String command) {
        separatorGaming(command);
        GameMenuController.moveUnitTo(x,y);
    }

    public static void patrolUnit(String command) {
        separatorGaming(command);
        GameMenuController.patrolUnit(x,y,X,Y);
    }

    public static void set(String command) {
        separatorGaming(command);
        GameMenuController.set(x,y,mood);
    }

    public static void attackEnemy(String command) {
        separatorGaming(command);
        GameMenuController.attackEnemy(x,y);
    }

    public static void airAttack(String command) {
        separatorGaming(command);
        GameMenuController.airAttack(x,y);
    }

    public static void pourOil(String command) {
        separatorGaming(command);
        GameMenuController.pourOil(direction);
    }

    public static void digTunnel(String command) {
        separatorGaming(command);
        GameMenuController.digTunnel(x,y);
    }

    public static void build(String command) {
        separatorGaming(command);
        GameMenuController.build(equipment);
    }

    public static void disbandUnit(String command) {
        separatorGaming(command);
        GameMenuController.disbandUnit();
    }


    public static void separatorGaming(String c) {
        String pattern2 = "-(?<option>[xyXY1234seEdqt]) (?<name>\\S+)";
        Pattern pattern = Pattern.compile(pattern2);
        Matcher matcher = pattern.matcher(c);
        while (matcher.find()) {
            String option = matcher.group("option");
            String name = matcher.group("name");
            switch (option) {
                case "x":
                    x = Integer.parseInt(name);
                    break;
                case "y":
                    y = Integer.parseInt(name);
                    break;
                case "X":
                    X = Integer.parseInt(name);
                    break;
                case "Y":
                    Y = Integer.parseInt(name);
                    break;
                case "s":
                    mood = name;
                    break;
                case "e":
                    enemyX = Integer.parseInt(name);
                    break;
                case "E":
                    enemyY = Integer.parseInt(name);
                    break;
                case "d":
                    direction = name;
                    break;
                case "q":
                    equipment = name;
                    break;
                case "t":
                    typeName = name;
                    try {
                        type=Soldiers.getSoldiersByName(typeName);
                    }catch (NullPointerException ignored){

                    }
                    break;


            }
        }
    }

    public static void print(String input){
        System.out.println(input);
    }
}

