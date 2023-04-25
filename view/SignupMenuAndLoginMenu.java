package view;

import controller.LoginMenuController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.ProfileMenuController;
import controller.SignupMenuController;
import model.User;

import static view.CommandsEnum.USERNAME_FORMAT_INVALID;

public class SignupMenuAndLoginMenu {



    static String username = null;
    static String password = null;
    static String email = null;
    static String nickname = null;
    static String slogan = null;
    static String answer = null;
    static String questionNumber = null;
    static String answerConfirm = null;
    static String passwordConfirmation = null;
    static String oldPassword = null;
    static String newPassword = null;


public void run(){
    while(true){
        String command = MainMenu.getScanner().nextLine();
        Matcher matcher;
        if (command.equals("exit"))
            break;
        else if (Commands.getMatcher(command,Commands.REGISTER_VALID) != null)
            register(command);
        else if ((matcher =Commands.getMatcher(command, Commands.LOGIN_VALID)) != null)
            System.out.println(login(matcher));
        else if (Commands.getMatcher(command, Commands.FORGOT_PASSWORD) != null)
            forgotPassword(command);
        else
            System.out.println("Invalid command!");
    }

}


    private void register(String command){

          sprater(command);
          CommandsEnum message = SignupMenuController.userCreater(username,password,passwordConfirmation,email,slogan,nickname);
        switch (message) {
            //TODO:check errors
            case USERNAME_FORMAT_INVALID:
                System.out.println("Username's format is invalid!");
                break;
            case LENGTH_WEEK_PASSWORD:
                System.out.println("password at least should be 6 character");
                break;
            case CAPITAL_LETTERS:
                System.out.println("capital letters doesn't exists");
                break;
            case SMALL_LETTERS:
                System.out.println("small letters doesn't exists");
                break;
            case NUMBER_NOT_EXISTS:
                System.out.println("password should have number");
                break;
            case INVALID_SPECIAL_CHARACTER:
                System.out.println("password should hava special character");
                break;
            case PASSWORD_CONFIRMATION_INCORRECT:
                System.out.println("password confirmation doesn't equal your password");
                break;
            case EMAIL_EXISTS:
                System.out.println("email is already exists");
                break;
            case EMAIL_FORMAT:
                System.out.println("email's format is invalid");
                break;
            case USERNAME_EXISTS:
                System.out.println("user already exists, you may use this username: "+SignupMenuController.newUsername);
                break;
            case EMPTY_FIELD:  //TODO:
                System.out.println("empty field");
                break;
            case SUCCESS:
                System.out.println("User has been created successfully!");
                System.out.println("Pick your security question: \n1. What is my father’s name? \n" +
                        "2. What was my first pet’s name? \n3. What is my mother’s last name?");
                securityQuestion(username);
                break;
            default:
                System.out.println("Invalid command!");
        }
    }


    private void securityQuestion (String username){
        String command = MainMenu.getScanner().nextLine();
        sprater(command);
        SignupMenuController.answerOfSecurityQuestion(Integer.parseInt(questionNumber),answer,answerConfirm,username);
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


    private void forgotPassword(String command){
        sprater(command);
        if(User.getUserByUsername(username)!=null) {
            System.out.println(User.getUserByUsername(username).getPasswordRecoveryQuestion());
        }
        String answer = MainMenu.getScanner().nextLine();
        String message= LoginMenuController.forgotPasswordController(answer,username);
        if (message.equals("successful")){
            String password = MainMenu.getScanner().nextLine();

            CommandsEnum result = SignupMenuController.checkPasswordFormat(password);
            if(result != CommandsEnum.SUCCESS) {
                System.out.println(checkPasswordFormat(result));
            }
            else {

                User.getUserByUsername(username).setPassword(password);
            }
        } else {
            System.out.println(message);
        }
    }



    public static String checkPasswordFormat(CommandsEnum commandsEnum){
        switch (commandsEnum){
            case LENGTH_WEEK_PASSWORD:
                return "password at least should be 6 character";
            case CAPITAL_LETTERS:
                return "capital letters doesn't exists";
            case SMALL_LETTERS:
                return "small letters doesn't exists";
            case NUMBER_NOT_EXISTS:
                return "password should have number";
            case INVALID_SPETIONAL:
                return "password should hava special character";
            case SUCCESS:
                return "password successfully changed";
            default:
                return "Invalid command!";
    }
    }


    public static String chaeckUsername(CommandsEnum commandsEnum){
        switch (commandsEnum){
            case USERNAME_FORMAT_INVALID:
                return "invalid username entered";
            case USERNAME_EXISTS:
                return "username already exists";
            default:
                return "Invalid command!";
        }
    }


    private String checkEmail(CommandsEnum commandsEnum){
        switch (commandsEnum){
            case EMAIL_FORMAT:
                return "invalid email entered";
            case MALE_EXISTS:
                return "email already exists";
            default:
                return "Invalid command!";
        }
    }


    public static void sprater(String c) {
        String pattern2 = "(-(?<option>[upenqacsow]) (?<name>\\S+))";
        Pattern pattern = Pattern.compile(pattern2);
        Matcher matcher = pattern.matcher(c);
        while (matcher.find()) {
            String option = matcher.group("option");
            String name = matcher.group("name");
            switch (option) {
                case "p":
                    password = name;
                    break;
                case "e":
                    email = name;
                    break;
                case "n":
                    nickname = name;
                    break;
                case "s":
                    slogan = name;
                    break;
                case "a":
                    answer = name;
                    break;
                case "q":
                    questionNumber = name;
                    break;
                case "u":
                    username = name;
                    break;
                case "c":
                    answerConfirm = name;
                    break;
                case "f":
                    passwordConfirmation = name;
                    break;
                case "o":
                    oldPassword = name;
                    break;
                case "w":
                    newPassword = name;
                    break;
            }
        }
    }

    public void removeCotation(String string) {
        if (string.matches("(\".+\")")) {
            String result = string.substring(1, string.length() - 1);
            string = result;
        }
    }
}
