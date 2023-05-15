package controller;

import model.User;
import view.CommandsEnum;

public class LoginMenuController {
    public static User currentUser = null;
    static Boolean stayLoggedIn = false;

    public static CommandsEnum userLogin(String username, String password, String stayIn) {
        stayIn = stayIn.trim();
        if (User.getUserByUsername(username) == null || !User.getUserByUsername(username).isPasswordCorrect(password)) {
            return CommandsEnum.INVALID_USERNAME_OR_PASSWORD;
        }

        if (stayLoggedIn) {
            stayLoggedIn = false;
            return CommandsEnum.SUCCESS;
        } else if (stayIn.matches("--stay-logged-in"))
            stayLoggedIn = true;

        if (currentUser == null)
            currentUser = User.getUserByUsername(username);
        return CommandsEnum.SUCCESS;

    }


    public static void logOut() {
        if (!stayLoggedIn)
            currentUser = null;
    }


}
