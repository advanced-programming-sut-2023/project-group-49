package controller;

import model.User;
import view.CommandsEnum;

public class LoginMenuController {
    public static User currentUser = null;
    static Boolean stayLoggedIn = false;
    static int incorrectPassword=0;
    static int waitTime=5;
    static int waitcount=1;
    public static CommandsEnum userLogin(String username, String password, String stayIn) {
        stayIn = stayIn.trim();
        try {
            if(!User.getUserByUsername(username).isPasswordCorrect(password)){
                incorrectPassword++;
            }
        }catch (NullPointerException ignored){

        }
        try {
            if (!stayLoggedIn&&User.getUserByUsername(username) == null || !User.getUserByUsername(username).isPasswordCorrect(password)) {
                return CommandsEnum.INVALID_USERNAME_OR_PASSWORD;
            }
        }catch (NullPointerException ignored){

        }



        if (stayLoggedIn) {
            stayLoggedIn = false;
            return CommandsEnum.SUCCESS;
        } else if (stayIn.matches("--stay-logged-in")) {
            stayLoggedIn = true;
            currentUser=User.getUserByUsername(username);
        } else
            currentUser = User.getUserByUsername(username);
        incorrectPassword=0;
        waitTime=5;
        waitcount=1;
        return CommandsEnum.SUCCESS;

    }


    public static void logOut() {
        if (!stayLoggedIn)
            currentUser = null;
    }

    public static int getIncorrectPassword() {
        return incorrectPassword;
    }
    public static String waitIncorrectPassword(){

        try{
            Thread.sleep(waitTime*1000);
            waitTime+=5;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        incorrectPassword=0;
        return "you can write password!";
    }

    public static int getWaitTime() {
        return waitTime;
    }
}
