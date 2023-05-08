package controller;

import model.User;
import view.CommandsEnum;

public class LoginMenuController {
    public static User currentUser=null;
    static Boolean stayLoggedIn=false;
    public static CommandsEnum userLogin(String username,String password,String stayIn){

        if(User.getUserByUsername(username)==null||!User.getUserByUsername(username).isPasswordCorrect(password)){
            return CommandsEnum.INVALID_USERNAME_OR_PASSWORD;
        }
        if(stayLoggedIn)
            stayLoggedIn=false;
        if(stayIn.matches(" --stay-logged-in"))
            stayLoggedIn=true;
        else{
            if(currentUser==null)
            currentUser=User.getUserByUsername(username);

        }

        return CommandsEnum.SUCCESS;

    }
    public static String forgotPasswordController(String answer,String username){
        if(answer.equals(User.getUserByUsername(username).getAnswer())){
            return "successful";
        }
        else {
            return "answer incorrect";
        }
    }
    public static void logOut(){
        if(!stayLoggedIn)
            currentUser=null;
    }
}
