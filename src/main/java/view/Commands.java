package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Commands {
    REGISTER_VALID("user create .+"),
    LOGIN_VALID("user login -u (?<username>.+) -p (?<password>.+) (?<statLoggedIn>.*)"),
    FORGOT_PASSWORD("forgot my password .+"),
    SECURITY_QUESTION("question pick .+"),
    USER_LOGOUT("user logout"),
    USERNAME_CHANGE("profile change .+"),
    NICKNAME_CHANGE("profile change .+"),
    PASSWORD_CHANGE("profile change password .+"),
    EMAIL_CHANGE("profile change .+"),
    SLOGAN_CHANGE("profile change slogan .+"),
    REMOVE_SLOGAN("Profile remove slogan"),
    HIGHSCORE_DISPLAY("profile display highscore"),
    RANK_DISPLAY("profile display rank"),
    SLOGAN_DISPLAY("profile display slogan"),
    PROFILE_DISPLAY("profile display"),
    ENTER_MENU("enter menu (?<manuName>.+)"),
<<<<<<< HEAD
    SHOW_MAP("show map -x (?<x>[0-9]+) -y (?<y>[0-9]+)"),
    MOVE_MAP("map (?<dir1>\\S+)\\s?(?<dir2>\\S*)");
=======
    SELECTUNIT("select unit.+"),
    MOVEUNITTO("move unit to.+"),
    PATROL_UNIT("patrol unit.+"),
    SET("set.+"),
    ATTACK_ENEMY("attack.+"),
    AIR_ATTACK("attack.+"),
    POUR_OIL("pour oil.+"),
    DIG_TUNNEL("dig tunnel.+"),
    BUILD("build.+"),
    DISBANDUNIT("disband unit");

>>>>>>> 8d7ed2888b0feb46fe0c430911189bbe618f814f

    private String regex;

    private Commands(String regex) {
        this.regex = regex;
    }

    public static Matcher getMatcher(String input, Commands command) {
        Matcher matcher = Pattern.compile(command.regex).matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}
