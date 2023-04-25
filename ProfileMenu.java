package view;

import java.util.regex.Matcher;

public class ProfileMenu {

    public void run(){
        while(true){
            String command = MainMenu.getScanner().nextLine();
            Matcher matcher;
            if (command.equals("user logout")) {
                System.out.println("user logged out successfully!");
                break;
            }
            else if ((matcher = Commands.getMatcher(command,Commands.REGISTER_VALID)) != null)
                register(matcher);
            else
                System.out.println("Invalid command!");
        }
    }


    private void profileChange(String command){


    }
}
