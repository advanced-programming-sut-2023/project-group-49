package view;


import model.Sloldier;
import model.Soldiers;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameMenu {

    static int x;
    static int y ;
    static int X ;
    static int Y ;
    static String mood ;
    static int enemyX ;
    static int enemyY ;
    static String direction ;
    static String equipment  ;


    public void run(){
        while(true){
            String command = MainMenu.getScanner().nextLine();
            Matcher matcher;
            if (command.equals("user logout")) {
                System.out.println("user logged out successfully!");
                break;
            } else if (Commands.getMatcher(command, Commands.SELECTUNIT) != null)
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


    public void selectUnit(String command){
        Sloldier sloldier = new Sloldier(x,y,type);

    }
    public void moveUnitTo(String command){

    }
    public void patrolUnit(String command){

    }
    public void set(String command){

    }
    public void attackEnemy(String command){

    }
    public void airAttack(String command){

    }
    public void pourOil(String command){

    }
    public void digTunnel(String command){

    }
    public void build(String command){

    }
    public void disbandUnit(String command){

    }


    public static void separatorGaming(String c) {
        String pattern2 = "-(?<option>[xyXY1234seEdq]) (?<name>\\S+)";
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
                    equipment  = name;
                    break;

            }
        }
    }
}

