package view;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }


    public static void run() {
        while (true) {
            String command = getScanner().nextLine();
            Matcher matcher;
            if (command.equals("logout")) {
                break;
            }else if (command.matches("\\s*show\\s+current\\s+menu\\s*")) {
                System.out.println("mai admin menu");
            } else if ((matcher = Commands.getMatcher(command, Commands.ENTER_MENU)) != null) {
                System.out.println(enterMenu(matcher));
            } else
                System.out.println("invalid command!");
        }
    }


    public static String enterMenu(Matcher matcher){
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
                        ProfileMenu.run(getScanner());
                    case "restaurant admin menu":
                        MapMenu.run(getScanner());
                    case "Snappfood admin menu":
                        GameMenu.run(getScanner());
                }
                return ("enter menu successful: You are in the " +menuName +"!");
            default:
                return ("invalid command!");
        }
    }


    }


