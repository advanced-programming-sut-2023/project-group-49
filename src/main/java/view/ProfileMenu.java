package view;

import controller.GameMenuController;
import controller.LoginMenuController;
import controller.ProfileMenuController;
import controller.SignupMenuController;
import model.User;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;

import static view.SignupMenuAndLoginMenu.*;


public class ProfileMenu {
    static  boolean flag=false;
    public void run(String command1) {
        String command=new String();
        while (true) {
            if(!flag)
                command=command1;
            else {
                command = MainMenu.getScanner().nextLine();
            }
            flag=true;
            Matcher matcher;
            if (command.equals("logout")) {
                System.out.println("user logged out successfully!");
                flag=false;
                break;
            } else if (Commands.getMatcher(command, Commands.USERNAME_CHANGE) != null)
                usernameChange(command);
            else if (Commands.getMatcher(command, Commands.NICKNAME_CHANGE) != null)
                nicknameChange(command);
            else if (Commands.getMatcher(command, Commands.PASSWORD_CHANGE) != null)
                passwordChange(command);
            else if (Commands.getMatcher(command, Commands.EMAIL_CHANGE) != null)
                emailChange(command);
            else if (Commands.getMatcher(command, Commands.SLOGAN_CHANGE) != null)
                sloganChange(command);
            else if (Commands.getMatcher(command, Commands.REMOVE_SLOGAN) != null)
                sloganRemove();
            else if (Commands.getMatcher(command, Commands.HIGHSCORE_DISPLAY) != null)
                System.out.println(ProfileMenuController.showHighScore(command).getUsername());
            else if (Commands.getMatcher(command, Commands.RANK_DISPLAY) != null)
                showRank(command);
            else if (Commands.getMatcher(command, Commands.SLOGAN_DISPLAY) != null)
                System.out.println( ProfileMenuController.showSlogan());
            else if (Commands.getMatcher(command, Commands.PROFILE_DISPLAY) != null)
                showProfile(command);
            else
                System.out.println("Invalid command!");
           // SignupMenuController.userDataBase();
          //  SignupMenuController.getNull();


        }
    }


    private void usernameChange(String command) {
        SignupMenuController.separator(command);
        CommandsEnum message = ProfileMenuController.changeUsername();
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
        SignupMenuController.separator(command);
        ProfileMenuController.changeNickname();
        System.out.println("nickname successfully changed");

    }


    private void passwordChange(String command) {
        SignupMenuController.separator(command);
        CommandsEnum message=ProfileMenuController.changePassword();
        switch (message) {
            case WRONGPASSWORD:
                System.out.println("password is wrong");
                break;
            case ENTER_NEW_PASSWORD:
                System.out.println("new password is equal old password");
                break;
            case SUCCESS:
                System.out.println("Please enter your new password again");
                String password=MainMenu.getScanner().nextLine();
                if(password.equals(SignupMenuController.getNewPassword())) {
                    LoginMenuController.currentUser.setPassword(SignupMenuController.getNewPassword());
                    System.out.println("password changed successfully");
                }
                else System.out.println("password is wrong");
                break;
            default:
                System.out.println(checkPasswordFormat(message));
        }


    }



    private void emailChange(String command){
        SignupMenuController.separator(command);
        CommandsEnum message = ProfileMenuController.changeEmail();
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
        SignupMenuController.separator(command);
        if(LoginMenuController.currentUser.getSlogan() != null){
            CommandsEnum message = ProfileMenuController.changeSlogan();
            switch (message){
                case EMPTY_FIELD:
                    System.out.println("slogan empty");
                    break;
                case SUCCESS:
                    System.out.println("slogan successfully changed");
                    break;
            }
        }else
            System.out.println("you don't have any slogan");
    }


    private void sloganRemove(){
        ProfileMenuController.removeSlogan();
        System.out.println("slogan removed successfully");
    }




    private void showRank(String commands){
        //System.out.println(Player.getPlayers().max());
    }

    private void showSlogan(String commands){
        // System.out.println(currentPlayer.getSlogan());
    }


    private void showProfile(String commands){
        System.out.println("username: "+LoginMenuController.currentUser.getUsername());
        System.out.println("password: "+LoginMenuController.currentUser.getPassword());
        System.out.println("email: "+LoginMenuController.currentUser.getEmail());

    }

}
