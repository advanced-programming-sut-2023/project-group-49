package view;


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
                System.out.println("user logged out!");
                break;
            }else if(command.matches("profile .+")){
                ProfileMenu profileMenu=new ProfileMenu();
                profileMenu.run(command);
            }else if(command.matches("start game .+")){
                GameMenu gameMenu=new GameMenu();
                gameMenu.run(command);
            }


        }
    }





}


