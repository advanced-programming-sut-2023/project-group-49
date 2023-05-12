package view;

import model.Product;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }
    public static Matcher getMatcher(String command,String regex){
        Matcher matcher= Pattern.compile(regex).matcher(command);
        return matcher.matches()?matcher:null;
    }

    public static void run() {
        while (true) {
            String command = getScanner().nextLine();
            Matcher matcher;
            if (command.equals("logout")) {
                break;
            }else if(command.matches("profile .+")){
                ProfileMenu profileMenu=new ProfileMenu();
                profileMenu.run(command);
            }else{
                GameMenu gameMenu=new GameMenu();
                gameMenu.run();
            }


        }
    }


    /*public static String enterMenu(Matcher matcher){
        String menuName = matcher.group("menuName");
        CommandsEnum messages = ChoosingMenu.enteringMenu(menuName);
        switch (messages){
            case INVALID_MENU_ENTERED:
                return ("enter menu failed: invalid menu name");
            case NO_ACCESS:
                return ("enter menu failed: access denied");
            case SUCCESS:
                switch (menuName){
                    case "customer menu":
                        ProfileMenu.run();
                    case "restaurant admin menu":
                        MapMenu.run();
                    case "Snappfood admin menu":
                        GameMenu.run();
                }
                return ("enter menu successful: You are in the " +menuName +"!");
            default:
                return ("invalid command!");
        }
    }*/


}


