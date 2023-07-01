package Controller;

import model.User;
import view.CommandsEnum;

public class LoginMenuController {
    public static User currentUser = null;
    static Boolean stayLoggedIn = false;
    static int incorrectPassword=0;
    static int waitTime=5;
    static int waitcount=1;
    public static String userLogin(String username, String password) {

            if (User.getUserByUsername(username) == null || !User.getUserByUsername(username).
                    isPasswordCorrect(password)) {
                return "invalid username or password";
            }

        return "successful";

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
