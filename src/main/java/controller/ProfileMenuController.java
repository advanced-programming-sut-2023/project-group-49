package controller;

import model.User;
import view.CommandsEnum;

public class ProfileMenuController {
    public static CommandsEnum changeUsername(){
        CommandsEnum result= SignupMenuController.checkUsername(SignupMenuController.getUsername());
        if(result!=CommandsEnum.SUCCESS)
            return result;
        LoginMenuController.currentUser.setUsername(SignupMenuController.getUsername());
        return CommandsEnum.SUCCESS;
    }
    public static CommandsEnum changePassword(){
        String oldPassword=SignupMenuController.getOldPassword();
        String newPassword=SignupMenuController.getNewPassword();
        if(!LoginMenuController.currentUser.isPasswordCorrect(oldPassword))
            return CommandsEnum.WRONGPASSWORD;//check
        if(oldPassword.equals(newPassword))
            return CommandsEnum.ENTER_NEW_PASSWORD;//TODO:create Enum
        CommandsEnum result=SignupMenuController.checkPasswordFormat(newPassword);
        return result;

    }
    public static void changeNickname(){
        String newNickname=SignupMenuController.getNickname();
        LoginMenuController.currentUser.setNickname(newNickname);
    }
    public static CommandsEnum changeEmail(){
        String newEmail=SignupMenuController.getEmail();
        CommandsEnum result=SignupMenuController.checkEmailFormats(newEmail);
        if(result!=CommandsEnum.SUCCESS)
            return result;
        LoginMenuController.currentUser.setEmail(newEmail);
        return CommandsEnum.SUCCESS;
    }
    public static CommandsEnum changeSlogan(){
        String newSlogan=SignupMenuController.getSlogan();
        if(newSlogan.matches("\\s*"))
            return CommandsEnum.EMPTY_FIELD;
        LoginMenuController.currentUser.setSlogan(newSlogan);
        return CommandsEnum.SUCCESS;
    }
    public static CommandsEnum removeSlogan(){
        LoginMenuController.currentUser.setSlogan(null);
        return CommandsEnum.SUCCESS;
    }
    public static User showHighScore(String command){
        int max=0;
        User user = null;
        for(int i=0;i<User.getAllUsers().size();i++){
            if(User.getAllUsers().get(i).getScore()>max){
                user=User.getAllUsers().get(i);
            }
        }
        return user;
    }
    public static String showSlogan(){
        String slogan=new String();
        try {
            slogan=LoginMenuController.currentUser.getSlogan();
        }catch (NullPointerException ignored){
            return "user doesn't have slogan";
        }
        return  slogan;

    }

}
