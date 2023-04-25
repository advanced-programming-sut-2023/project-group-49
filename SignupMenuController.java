package controller;

import model.User;
import view.CommandsEnum;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.io.IOException;
import org.json.simple.JSONObject;

public class SignupMenuController {
    public static String newUsername;

    public static CommandsEnum userCreator(String username,String password,String passwordConfirmation,String email,String slogan,String nickname) {

        if (username.matches("\\s*") || password.matches("\\s*") || passwordConfirmation.matches("\\s*")
                || email.matches("\\s*") ) {
            return CommandsEnum.EMPTY_FIELD;
        }
        CommandsEnum result2=checkUsername(username);
        if(result2!=CommandsEnum.SUCCESS)
            return result2;
        if(!password.equals("random")) {
            CommandsEnum result = checkPasswordFormat(password);
            if (result != CommandsEnum.SUCCESS)
                return result;
            if (!password.equals(passwordConfirmation))
                return CommandsEnum.PASSWORD_CONFIRMATION_INCORRECT;
        }
        CommandsEnum result3=checkUsername(username);
        if(result3!=CommandsEnum.SUCCESS)
            return result3;
        else{
            User user=new User(username,password,nickname,email);
            if(password.equals("random"))
                randomPassword(username);
            if(slogan.equals("random"))
                randomSlogan(username);
            User.getAllUsers().add(User.getUserByUsername(username));
            userDateBase(username,password,email,slogan,nickname);


            return CommandsEnum.SUCCESS;
        }
    }
    public static CommandsEnum checkUsername(String username){
        if (!username.matches("[a-zA-Z0-9_]+")) {
            return CommandsEnum.USERNAME_FORMAT_INVALID;
        } else if (User.getUserByUsername(username) != null) {
            UsernameSuggestion(username);
            return CommandsEnum.USERNAME_EXISTS;
        }
        return CommandsEnum.SUCCESS;
    }
    public static CommandsEnum checkPasswordFormat(String password){

         if (password.length() < 6) {
            return CommandsEnum.LENGTH_WEEK_PASSWORD;
        } else if (!password.matches(".*[A-Z].*")) {
            return CommandsEnum.CAPITAL_LETTERS;
        } else if (!password.matches(".*[a-z].*")) {
            return CommandsEnum.SMALL_LETTERS;
        } else if (!password.matches(".*[0-9].*")) {
            return CommandsEnum.NUMBER_NOT_EXISTS;
        } else if (!password.matches(".*[\\W+].*")) {
            return CommandsEnum.INVALID_SPETIONAL;
        } else if (!password.equals(passwordConfirmation)) {
            return CommandsEnum.PASSWORD_CONFIRMATION_INCORRECT;
        }
         else return CommandsEnum.SUCCESS;

    }
    public static CommandsEnum checkEmailFormats(String email){
         if (!email.matches("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]+")) {
            return CommandsEnum.EMAIL_FORMAT;
        } else if (User.getUserByEmail(email) != null) {
            return CommandsEnum.MALE_EXISTS;
        }
    }

    public  static void UsernameSuggestion(String username){
        Random random = new Random();
        while (true){
            newUsername = null;
            int rand = random.nextInt(1000);
            newUsername = username + rand;
            if(User.getUserByUsername(newUsername) == null){
                //TODO
                break;
            }
        }

    }
    public static void answerOfSecurityQuestion(int question,String answer,String answerConfirm,String username){
        if(question==1) {
            User.getUserByUsername(username).setPasswordRecoveryQuestion("What is my father's name?");
        }
        else if(question==2) {
            User.getUserByUsername(username).setPasswordRecoveryQuestion("What is my first pet's name?");
        }
        else if(question==3) {
            User.getUserByUsername(username).setPasswordRecoveryQuestion("What is my mother's last name?");
        }
        User.getUserByUsername(username).setAnswer(answer);


    }
    public static void userDateBase(String username,String password,String email,String slogan,String nickname){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("password", password);
        jsonObject.put("email", email);
        jsonObject.put("slogan", slogan);
        jsonObject.put("nickname", nickname);
        try {
            FileWriter file = new FileWriter("G:/"+username+".json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void randomPassword(String username){
        Random rand = new Random();
        int length;
        while (true) {
            length = rand.nextInt(20);
            if(length>=6)
                break;
        }
        String smallLetters = "abcdefghijklmnopqrstuvwxyz";
        String capitalLetters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers="123456789";
        String character="*.!@$%^&(){}[]:;<>,?/~_+-=|";
        StringBuilder randomString = new StringBuilder();
        int i, lengthSmallLetters;
        while (true) {
            lengthSmallLetters = rand.nextInt(length-3);

            if(lengthSmallLetters!=0&&length-lengthSmallLetters>3){
                break;
            }
        }
        for ( i = 0; i < lengthSmallLetters; i++) {
            int index = rand.nextInt(smallLetters.length());
            randomString .append(smallLetters.charAt(index));
        }
        int lengthCapitalLetters,j=0;
        while (true){
            lengthCapitalLetters= rand.nextInt(length-2);

            if(lengthCapitalLetters!=0&&length-(lengthCapitalLetters+lengthSmallLetters)>2){
                break;
            }
        }
        for(  j=0;j<lengthCapitalLetters;j++){
            int index=rand.nextInt(capitalLetters.length());
            randomString.append(capitalLetters.charAt(index));
        }
        int lengthNumbers,k;
        while (true){
            lengthNumbers= rand.nextInt(length-1);
            if(lengthNumbers!=0&&length-(lengthCapitalLetters+lengthSmallLetters+lengthNumbers)>1){
                break;
            }
        }
        for(k=0;k<lengthNumbers;k++){
            int index= rand.nextInt(numbers.length());
            randomString.append(numbers.charAt(index));
        }
        int lengthCharacter,l;
        lengthCharacter=length-(lengthCapitalLetters+lengthSmallLetters+lengthNumbers);
        for(l=0;l<lengthCharacter;l++){
            int index=rand.nextInt(character.length());
            randomString.append(character.charAt(index));
        }
        int length2;
        while (true) {
            length2 = rand.nextInt(length);
            if(length2!=0)break;
        }

        for(int h=0;h<length2;h++) {
            int change1 = rand.nextInt(length2);
            char c1 = randomString.charAt(change1);
            int change2 = rand.nextInt(length2);
            char c2 = randomString.charAt(change2);
            randomString.deleteCharAt(change1);
            randomString.insert(change1, c2);
            randomString.deleteCharAt(change2);
            randomString.insert(change2, c1);
        }
        String randomString2= String.valueOf(randomString);
        User.getUserByUsername(username).setPassword(randomString2);


    }
    public static void randomSlogan(String username){
        String randomSlogan=null;
        //TODO:create file and write slogan
        User.getUserByUsername(username).setSlogan(randomSlogan);
    }
}