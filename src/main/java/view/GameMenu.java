package view;


//import controller.GameMenuController;
//import model.Map;
//
//
//import model.Sloldier;
import model.Soldiers;

import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import static controller.GameMenuController.equipment;
//import static controller.GameMenuController.getAllBuildings;


public class GameMenu {



//    public static void run(String command1) {
//        GameMenuController.separateUsers(command1);
//        while (true) {
//            String command = MainMenu.getScanner().nextLine();
//            Matcher matcher;
//            if (command.equals("user logout")) {
//                System.out.println("user logged out successfully!");
//                break;
//
//            } else if ((matcher = Commands.getMatcher(command, Commands.SHOW_MAP)) != null)
//                GameMenuController.showMap(matcher);
//            else if ((matcher = Commands.getMatcher(command, Commands.MOVE_MAP)) != null)
//                GameMenuController.mapMove(matcher);
//            else if (Commands.getMatcher(command, Commands.SELECTUNIT) != null)
//                selectUnit(command);
//            else if (Commands.getMatcher(command, Commands.MOVEUNITTO) != null)
//                moveUnitTo(command);
//            else if (Commands.getMatcher(command, Commands.PATROL_UNIT) != null)
//                patrolUnit(command);
//            else if (Commands.getMatcher(command, Commands.SET) != null)
//                set(command);
//            else if (Commands.getMatcher(command, Commands.ATTACK_ENEMY) != null)
//                attackEnemy(command);
//            else if (Commands.getMatcher(command, Commands.AIR_ATTACK) != null)
//                airAttack(command);
//            else if (Commands.getMatcher(command, Commands.POUR_OIL) != null)
//                pourOil(command);
//            else if (Commands.getMatcher(command, Commands.DIG_TUNNEL) != null)
//                digTunnel(command);
//            else if (Commands.getMatcher(command, Commands.BUILD) != null)
//                build(command);
//            else if (Commands.getMatcher(command, Commands.DISBANDUNIT) != null)
//                disbandUnit(command);
//            else
//                System.out.println("Invalid command!");
//        }
//    }
//
//
//    public static void printMap(int num, int x, int y) {
//        while (true) {
//            if (num == 1) {
//                System.out.println("S");
//                break;
//            } else if (num == 2) {
//                System.out.println("w");
//                break;
//            } else if (num == 3) {
//                System.out.println("B");
//                break;
//            } else if (num == 4) {
//                System.out.println("T");
//                break;
//            } else if (num == 5) {
//                System.out.println(Map.showApartOfMap(x, y).getGroundType());
//                break;
//            } else {
//                System.out.println("can not move or show map!");
//            }
//        }
//    }
//
//    public static void printMapDetails(int num, int x, int y) {
//        while (true) {
//            if (num == 1) {
//                System.out.println(Map.showApartOfMap(x, y).getAllUnit());
//                break;
//            } else if (num == 2) {
//                System.out.println(Map.showApartOfMap(x, y).getBuilding());
//                break;
//            } else if (num == 3) {
//                System.out.println(Map.showApartOfMap(x, y).getGroundType());
//                break;
//            }
//            else if (num == 4) {
//                System.out.println("all the military units in this location: "+GameMenuController.getAllSoldiers().size());
//                break;
//            } else if (num == 5) {
//                System.out.println("all the buildings in this location: "+GameMenuController.getAllBuildings().size());
//                break;
//            }
//            else {
//                System.out.println("can not show details-(your Coordinate is not available)!");
//            }
//
//        }
//    }
//
//
//
//    public static void selectUnit(String command) {
//        GameMenuController.separatorGaming(command);
//        try {
//            GameMenuController.selectUnit(GameMenuController.x,GameMenuController.y,GameMenuController.type);
//        }catch (NullPointerException ignored){
//
//        }
//
//
//    }
//
//    public static void moveUnitTo(String command) {
//        GameMenuController.separatorGaming(command);
//        GameMenuController.moveUnitTo(GameMenuController.x,GameMenuController.y);
//    }
//
//    public static void patrolUnit(String command) {
//       GameMenuController.separatorGaming(command);
//        GameMenuController.patrolUnit(GameMenuController.x,GameMenuController.y,GameMenuController.X,GameMenuController.Y);
//    }
//
//    public static void set(String command) {
//        GameMenuController.separatorGaming(command);
//        GameMenuController.set(GameMenuController.x,GameMenuController.y,GameMenuController.mood);
//    }
//
//    public static void attackEnemy(String command) {
//        GameMenuController.separatorGaming(command);
//        GameMenuController.attackEnemy(GameMenuController.x,GameMenuController.y);
//    }
//
//    public static void airAttack(String command) {
//        GameMenuController.separatorGaming(command);
//        GameMenuController.airAttack(GameMenuController.x,GameMenuController.y);
//    }
//
//    public static void pourOil(String command) {
//        GameMenuController.separatorGaming(command);
//        GameMenuController.pourOil(GameMenuController.direction);
//    }
//
//    public static void digTunnel(String command) {
//        GameMenuController.separatorGaming(command);
//        GameMenuController.digTunnel(GameMenuController.x,GameMenuController.y);
//    }
//
//    public static void build(String command) {
//       GameMenuController.separatorGaming(command);
//        GameMenuController.build(equipment);
//    }
//
//    public static void disbandUnit(String command) {
//        GameMenuController.separatorGaming(command);
//        GameMenuController.disbandUnit();
//    }
//
//
//
//    public static void print(String input){
//        System.out.println(input);
//    }
}

