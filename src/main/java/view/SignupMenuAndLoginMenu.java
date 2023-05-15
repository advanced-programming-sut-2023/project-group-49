package view;

import controller.LoginMenuController;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.ProfileMenuController;
import controller.SignupMenuController;
import model.User;

import static view.CommandsEnum.USERNAME_FORMAT_INVALID;

public class SignupMenuAndLoginMenu {

    static String username;
    static String password ;
    static String email ;
    static String nickname ;
    static String slogan ;
    static String answer ;
    static String questionNumber ;
    static String answerConfirm ;
    static String passwordConfirmation ;
    static String oldPassword ;
    static String newPassword ;


    public void run(){
        while(true){
            String command = MainMenu.getScanner().nextLine();
            Matcher matcher;
            if (command.equals("exit"))
                break;
            else if (Commands.getMatcher(command,Commands.REGISTER_VALID) != null)
                register(command);
            else if ((matcher =Commands.getMatcher(command, Commands.LOGIN_VALID)) != null) {

                String result=login(matcher);
                System.out.println(result);
                System.out.println(LoginMenuController.getIncorrectPassword());
                if(LoginMenuController.getIncorrectPassword()==4) {
                    System.out.println("please wait "+LoginMenuController.getWaitTime()+" seconds:");
                    System.out.println(LoginMenuController.waitIncorrectPassword());
                }
                if(result.equals("user logged in successfully!"))
                    return;
            }
            else if (Commands.getMatcher(command, Commands.FORGOT_PASSWORD) != null)
                forgotPassword(command);
            else
                System.out.println("Invalid command!");
        }

    }


    private void register(String command){
        SignupMenuController.separator(command);
        CommandsEnum message = SignupMenuController.userCreator();
        switch (message) {
            case USERNAME_FORMAT_INVALID:
                System.out.println("Username's format is invalid!");
                break;
            case LENGTH_WEEK_PASSWORD:
                System.out.println("password at least should be 6 character!");
                break;
            case CAPITAL_LETTERS:
                System.out.println("capital letters doesn't exists!");
                break;
            case SMALL_LETTERS:
                System.out.println("small letters doesn't exists!");
                break;
            case NUMBER_NOT_EXISTS:
                System.out.println("password should have number!");
                break;
            case INVALID_SPECIAL_CHARACTER:
                System.out.println("password should hava special character!");
                break;
            case PASSWORD_CONFIRMATION_INCORRECT:
                System.out.println("password confirmation doesn't equal your password!");
                break;
            case EMAIL_EXISTS:
                System.out.println("email is already exists!");
                break;
            case EMAIL_FORMAT:
                System.out.println("email's format is invalid!");
                break;
            case USERNAME_EXISTS:
                System.out.println("user already exists, you may use this username: "+SignupMenuController.newUsername);
                break;
            case EMPTY_FIELD:
                System.out.println("empty field!");
                break;
            case SUCCESS:
                System.out.println("User has been created successfully!");
                securityQuestion();
                break;
            default:
                System.out.println("Invalid command!");
        }
    }


    public static void securityQuestion (){
        System.out.println("Pick your security question: \n1. What is my father’s name? \n" +
                "2. What was my first pet’s name? \n3. What is my mother’s last name?");
        String command = MainMenu.getScanner().nextLine();
        SignupMenuController.separator(command);
        System.out.println(SignupMenuController.answerOfSecurityQuestion());
        System.out.println("write number:");
        while (true) {
            SignupMenuController.captcha();
            int number = MainMenu.getScanner().nextInt();
            String result=SignupMenuController.checkCaptcha(number);
            if(result.equals("successful"))
                break;
            System.out.println(result);
        }
        System.out.println("Your registration is complete");

    }



    private String login(Matcher matcher){
        String username = matcher.group("username");
        String password = matcher.group("password");
        String statLoggedIn = matcher.group("statLoggedIn");
        CommandsEnum message = LoginMenuController.userLogin(username,password,statLoggedIn);
        switch (message) {
            case INVALID_USERNAME_OR_PASSWORD:
                return "Username and password didn’t match!";
            case SUCCESS:
                return "user logged in successfully!";
            default:
                return "Invalid command!";
        }
    }


    private void forgotPassword(String command) {
        SignupMenuController.separator(command);
        System.out.println(SignupMenuController.forgotMyPassword());
        while (true) {
            String answer = MainMenu.getScanner().nextLine();
            String message = SignupMenuController.forgotPasswordController(answer);
            if (message.equals("successful")) {
                System.out.println("please write new password:");
                while (true) {
                    String password = MainMenu.getScanner().nextLine();

                    CommandsEnum result = SignupMenuController.checkPasswordFormat(password);
                    if (result != CommandsEnum.SUCCESS) {
                        System.out.println(checkPasswordFormat(result));
                    } else {
                        Objects.requireNonNull(User.getUserByUsername(SignupMenuController.getUsername())).setPassword(password);
                        SignupMenuController.userDateBase();
                        SignupMenuController.getNull();
                        return;
                    }
                }
            }
            else{
                System.out.println(message);
            }
        }
    }



    public static String checkPasswordFormat(CommandsEnum commandsEnum){
        switch (commandsEnum){
            case LENGTH_WEEK_PASSWORD:
                return "password at least should be 6 character!";
            case CAPITAL_LETTERS:
                return "capital letters doesn't exists!";
            case SMALL_LETTERS:
                return "small letters doesn't exists!";
            case NUMBER_NOT_EXISTS:
                return "password should have number!";
            case INVALID_SPECIAL_CHARACTER:
                return "password should hava special character!";
            case SUCCESS:
                return "password successfully changed!";
            default:
                return "Invalid command!";
        }
    }


    public static String chaeckUsername(CommandsEnum commandsEnum){
        switch (commandsEnum){
            case USERNAME_FORMAT_INVALID:
                return "invalid username entered!";
            case USERNAME_EXISTS:
                return "username already exists!";
            default:
                return "Invalid command!";
        }
    }


    private String checkEmail(CommandsEnum commandsEnum){
        switch (commandsEnum){
            case EMAIL_FORMAT:
                return "invalid email entered!";
            case MALE_EXISTS:
                return "email already exists!";
            default:
                return "Invalid command!";
        }
    }




    public void removeCotation(String string) {
        if (string.matches("(\".+\")")) {
            String result = string.substring(1, string.length() - 1);
            string = result;
        }
    }

    public static void printUsernameSuggestion(String username){
        System.out.println(username);
    }
    public static void printRandomPassword(String randomPassword){
        System.out.println(randomPassword);
        while (true){
            String confirm=MainMenu.getScanner().nextLine();
            if (confirm.equals(randomPassword))
                return;
            else System.out.println("Your password is wrong!");
        }
    }
    public static void print(String input){
        System.out.println(input);
    }
}
