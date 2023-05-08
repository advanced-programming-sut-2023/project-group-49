package controller;

import view.CommandsEnum;

public class ProfileMenuController {
    public static CommandsEnum changeUsername(String newUsername){
       CommandsEnum result= SignupMenuController.checkUsername(newUsername);
       if(result!=CommandsEnum.SUCCESS)
           return result;
       LoginMenuController.currentUser.setUsername(newUsername);
       return CommandsEnum.SUCCESS;
    }
    public static CommandsEnum changePassword(String oldPassword,String newPassword){
        if(!LoginMenuController.currentUser.isPasswordCorrect(oldPassword))
            return CommandsEnum.WRONGPASSWORD;//check
        if(oldPassword.equals(newPassword))return null;//TODO:create Enum
        CommandsEnum result=SignupMenuController.checkPasswordFormat(newPassword);
        if(result!=CommandsEnum.SUCCESS)
            return CommandsEnum.SUCCESS;
        LoginMenuController.currentUser.setPassword(newPassword);
        return CommandsEnum.SUCCESS;

    }
    public static void changeNickname(String newNickname){
        //TODO:errors
        LoginMenuController.currentUser.setNickname(newNickname);
    }
    public static CommandsEnum changeEmail(String newEmail){
        CommandsEnum result=SignupMenuController.checkEmailFormats(newEmail);
        if(result!=CommandsEnum.SUCCESS)
            return result;
        LoginMenuController.currentUser.setEmail(newEmail);
        return CommandsEnum.SUCCESS;
    }
    public static CommandsEnum changeSlogan(String newSlogan){
        LoginMenuController.currentUser.setSlogan(newSlogan);
        //TODO:errors
        return CommandsEnum.SUCCESS;
    }
    public static CommandsEnum removeSlogan(){
        LoginMenuController.currentUser.setSlogan(null);
        return CommandsEnum.SUCCESS;
    }
}
