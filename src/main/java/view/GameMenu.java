package view;

import java.util.regex.Matcher;

public class GameMenu {

    public void run(){
        while(true){
            String command = MainMenu.getScanner().nextLine();
            Matcher matcher;
            if (command.equals("user logout")) {
                System.out.println("user logged out successfully!");
                break;
            }
            else
                System.out.println("Invalid command!");
        }
    }
}
