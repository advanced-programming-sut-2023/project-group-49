package view;

import controller.GameMenuController;
import model.Map;

import java.util.regex.Matcher;

public class GameMenu {

    public static void run() {
        while (true) {
            String command = MainMenu.getScanner().nextLine();
            Matcher matcher;
            if (command.equals("user logout")) {
                System.out.println("user logged out successfully!");
                break;
            } else if ((matcher=Commands.getMatcher(command, Commands.SHOW_MAP)) != null) {
                GameMenuController.showMap(matcher);
                if ((matcher=Commands.getMatcher(command, Commands.MOVE_MAP)) != null) {
                    GameMenuController.mapMove(matcher);
                }
            } else {
                System.out.println("Invalid command!");
            }
        }
    }

    public static void printMap(int num,int x,int y){
        while(true) {
            if (num == 1) {
                System.out.println("S");
                break;
            } else if (num == 2) {
                System.out.println("w");
                break;
            } else if (num == 3) {
                System.out.println("B");
                break;
            } else if (num==4) {
                System.out.println("T");
                break;
            } 
            else if (num==5){
                System.out.println(Map.showApartOfMap(x,y).getGroundType());
                break;
            }
            else {
                System.out.println("can not move or show map!");
            }
        }
    }
}
