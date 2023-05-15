package view;

import controller.ProfileMenuController;

import java.util.Objects;
import java.util.regex.Matcher;

import static view.SignupMenuAndLoginMenu.*;


public class ProfileMenu {

    public void run() {
        while (true) {
            String command = MainMenu.getScanner().nextLine();
            Matcher matcher;
            if (command.equals("user logout")) {
                System.out.println("user logged out successfully!");
                break;
            } else if (Commands.getMatcher(command, Commands.USERNAME_CHANGE) != null)
                usernameChange(command);
            else if (Commands.getMatcher(command, Commands.NICKNAME_CHANGE) != null)
                nicknameChange(command);
            else if (Commands.getMatcher(command, Commands.PASSWORD_CHANGE) != null)
                passwordchange(command);
            else if (Commands.getMatcher(command, Commands.EMAIL_CHANGE) != null)
                emailChange(command);
            else if (Commands.getMatcher(command, Commands.SLOGAN_CHANGE) != null)
                sloganChange(command);
            else if (Commands.getMatcher(command, Commands.REMOVE_SLOGAN) != null)
                sloganRemove();
            else if (Commands.getMatcher(command, Commands.HIGHSCORE_DISPLAY) != null)
                showHighscore(command);
            else if (Commands.getMatcher(command, Commands.RANK_DISPLAY) != null)
                showRank(command);
            else if (Commands.getMatcher(command, Commands.SLOGAN_DISPLAY) != null)
                showSlogan(command);
            else if (Commands.getMatcher(command, Commands.PROFILE_DISPLAY) != null)
                showProfile(command);
            else
                System.out.println("Invalid command!");
        }
    }


    private void usernameChange(String command) {
        SignupMenuAndLoginMenu.sprater(command);
        CommandsEnum message = ProfileMenuController.changeUsername(username);
        switch (message) {
            case USERNAME_FORMAT_INVALID:
                System.out.println("username format is invalid");
                break;
            case USERNAME_EXISTS:
                System.out.println("this username already exists");
                break;
            case SUCCESS:
                System.out.println("username successfully changed");
                break;
        }
    }


    private void nicknameChange(String command) {
        SignupMenuAndLoginMenu.sprater(command);
        ProfileMenuController.changeNickname(username);
        System.out.println("nickname successfully changed");

    }


    private void passwordChange(String command) {
        SignupMenuAndLoginMenu.sprater(command);
        System.out.println(SignupMenuAndLoginMenu.checkPasswordFormat(Objects.requireNonNull
                (ProfileMenuController.changePassword(oldPassword, newPassword))));
    }



    private void emailChange(String command){
        SignupMenuAndLoginMenu.sprater(command);
        CommandsEnum message = ProfileMenuController.changeEmail(email);
        switch (message){
            case EMAIL_FORMAT:
                System.out.println("email format invalid");
                break;
            case MALE_EXISTS:
                System.out.println("this email already exists");
                break;
            case SUCCESS:
                System.out.println("email successfully changed");
                break;
        }
    }


    private void sloganChange(String command){
        SignupMenuAndLoginMenu.sprater(command);
        if(slogan != null){
            CommandsEnum message = ProfileMenuController.changeSlogan(slogan);
            switch (message){
                //TODO print errors
                case SUCCESS:
                    System.out.println("slogan successfully changed");
            }
        }else
            System.out.println("you don't have any slogan");
    }


    private void sloganRemove(){
        ProfileMenuController.removeSlogan();
        System.out.println("slogan removed successfully");
    }


    private void showHighScore(String command){
        //TODO showHighScore
    }

    private void showRank(String commands){
        //TODO showRank
    }

    private void showSlogan(String commands){
        //TODO showSlogan
    }


    private void showProfile(String commands){
        //TODO showProfile
    }

    public void run(String command) {
    }
}
