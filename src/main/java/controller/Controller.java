package Controller;

import model.User;
import view.CommandsEnum;
import view.SignupMenuAndLoginMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    public static String randomPassword(){

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
        // SignupMenuAndLoginMenu.printRandomPassword(randomString2);
        //  User.getUserByUsername(username).setPassword(randomString2);
        System.out.println(randomString2);
        return randomString2;

    }
    public static String checkPasswordFormat(String password){

        if (password.length() < 6) {
            return SignupMenuAndLoginMenu.checkPasswordFormat( CommandsEnum.LENGTH_WEEK_PASSWORD);
        } else if (!password.matches(".*[A-Z].*")) {
            return SignupMenuAndLoginMenu.checkPasswordFormat(CommandsEnum.CAPITAL_LETTERS);
        } else if (!password.matches(".*[a-z].*")) {
            return SignupMenuAndLoginMenu.checkPasswordFormat(CommandsEnum.SMALL_LETTERS);
        } else if (!password.matches(".*[0-9].*")) {
            return SignupMenuAndLoginMenu.checkPasswordFormat(CommandsEnum.NUMBER_NOT_EXISTS);
        } else if (!password.matches(".*[\\W+].*")) {
            return SignupMenuAndLoginMenu.checkPasswordFormat(CommandsEnum.INVALID_SPECIAL_CHARACTER);
        }else return SignupMenuAndLoginMenu.checkPasswordFormat(CommandsEnum.SUCCESS);

    }
    public static String randomSlogan(){
        String randomSlogan = null;
        Random random=new Random();
        int lineNumber=random.nextInt(19);
        int counter=0;
        try {
            File myObj = new File("Slogan.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                randomSlogan = myReader.nextLine();
                counter++;
                if(counter==lineNumber) {
                    break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
       /* try {
            User.getUserByUsername(username).setSlogan(randomSlogan);
        }catch (NullPointerException ignored){

        }

        SignupMenuAndLoginMenu.print("you random Slogan is : "+randomSlogan);*/
        return randomSlogan;
    }
    public static String checkEmailFormats(String email){
        if (!email.matches("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]+")) {
            return SignupMenuAndLoginMenu.checkEmail(CommandsEnum.EMAIL_FORMAT);
        } else if (User.getUserByEmail(email) != null) {
            return SignupMenuAndLoginMenu.checkEmail(CommandsEnum.EMAIL_EXISTS);
        }
        return SignupMenuAndLoginMenu.checkEmail(CommandsEnum.SUCCESS);
    }
}
