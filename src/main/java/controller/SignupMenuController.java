package controller;

import model.User;

import view.CommandsEnum;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;
import view.MainMenu;
import view.SignupMenuAndLoginMenu;

public class SignupMenuController {
    public static String newUsername;

    static String username;
    static String password;
    static String email;
    static String nickname;
    static String slogan;
    static String answer;
    static String questionNumber;
    static String answerConfirm;
    static String passwordConfirmation;
    static String oldPassword;
    static String newPassword;
    static int randomNumber;



    public static CommandsEnum userCreator() {
        if (username == null || password == null || passwordConfirmation == null || nickname == null
                || email == null) {
            getNull();
            return CommandsEnum.EMPTY_FIELD;
        }
        CommandsEnum result2=checkUsername(username);
        if(result2!=CommandsEnum.SUCCESS) {
            getNull();
            return result2;
        }
        if(!password.equals("random")) {
            CommandsEnum result = checkPasswordFormat(password);
            if (result != CommandsEnum.SUCCESS) {
                getNull();
                return result;
            }
            if (!password.equals(passwordConfirmation)) {
                getNull();
                return CommandsEnum.PASSWORD_CONFIRMATION_INCORRECT;
            }
            CommandsEnum result3=checkEmailFormats(email);
            if(result3!=CommandsEnum.SUCCESS){
                getNull();
                return result3;
            }
        }

        User user=new User(username,password,nickname,email);
        try {
            user.setSlogan(slogan);
            if(slogan.equals("random"))
                randomSlogan();
        }catch(NullPointerException ignored){

        }

        User.addUser(user);
        if(password.equals("random"))
            randomPassword();

     //   userDataBase();


        return CommandsEnum.SUCCESS;
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
            return CommandsEnum.INVALID_SPECIAL_CHARACTER;
        }else return CommandsEnum.SUCCESS;

    }
    public static CommandsEnum checkEmailFormats(String email){
        if (!email.matches("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]+")) {
            return CommandsEnum.EMAIL_FORMAT;
        } else if (User.getUserByEmail(email) != null) {
            return CommandsEnum.EMAIL_EXISTS;
        }
        return CommandsEnum.SUCCESS;
    }

    public  static void UsernameSuggestion(String username){
        Random random = new Random();
        while (true){
            newUsername = null;
            int rand = random.nextInt(1000);
            if(User.getUserByUsername(newUsername) == null){
                newUsername = username + rand;
                break;
            }
        }

    }
  /*  public static String  answerOfSecurityQuestion(){
        try {
            if(Integer.parseInt(questionNumber)==1) {
                User.getUserByUsername(username).setPasswordRecoveryQuestion("What is my father's name?");
            }
            else if(Integer.parseInt(questionNumber)==2) {
                User.getUserByUsername(username).setPasswordRecoveryQuestion("What is my first pet's name?");
            }
            else if(Integer.parseInt(questionNumber)==3) {
                User.getUserByUsername(username).setPasswordRecoveryQuestion("What is my mother's last name?");
            }

        }catch (NumberFormatException e){
            SignupMenuAndLoginMenu.print("not a format of picking security question!");
            SignupMenuAndLoginMenu.securityQuestion();
        }
        try {
            User.getUserByUsername(username).setAnswer(answer);
            userDataBase();
            getNull();
        }catch (NullPointerException ignored){
            return "";
        }

        return "security question picked";
    }
    public static void userDataBase(){
        JSONObject jsonObject = new JSONObject();
        User user;
        if(LoginMenuController.currentUser!=null)
            user=LoginMenuController.currentUser;
        else user=User.getUserByUsername(username);
        jsonObject.put("username", user.getUsername());
        String password=encrypt(user.getPassword());

        jsonObject.put("password", password);
        jsonObject.put("email", user.getEmail());
        try {
            jsonObject.put("slogan", user.getSlogan());
        }catch (NullPointerException ignored){

        }

        jsonObject.put("nickname", user.getNickname());
        jsonObject.put("Question",user.getPasswordRecoveryQuestion());
        jsonObject.put("answer",user.getAnswer());
        try {
            FileWriter file = new FileWriter("Database/"+user.getUserId()+".json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
    public static void randomPassword(){
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
      //  SignupMenuAndLoginMenu.printRandomPassword(randomString2);
        User.getUserByUsername(username).setPassword(randomString2);

    }
    public static void randomSlogan(){
        String randomSlogan=null;
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
        try {
            User.getUserByUsername(username).setSlogan(randomSlogan);
        }catch (NullPointerException ignored){

        }

        SignupMenuAndLoginMenu.print("you random Slogan is : "+randomSlogan);
    }
    public static void separator(String c) {
        String pattern2 = "-(?<option>[upenqacsow]) (?<name>\"((?<=\").*?(?=\"))\"|\\S+)";
        Pattern pattern = Pattern.compile(pattern2);
        Matcher matcher = pattern.matcher(c);
        while (matcher.find()) {
            String option = matcher.group("option");
            String name = matcher.group("name");
            if(name.matches("\"((?<=\").*?(?=\"))\""))
                name=name.substring(1,name.length()-1);
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
        if((matcher= MainMenu.getMatcher(c,".*-p \\S+ (?<password>\\S+).*"))!=null){
            passwordConfirmation=matcher.group("password");
        }

    }
    public static void getNull(){
        username=null;
        password=null;
        passwordConfirmation=null;
        email=null;
        nickname=null;
        slogan=null;
        answer=null;
        answerConfirm=null;
        questionNumber=null;

    }
    public static String forgotMyPassword(){
        if(User.getUserByUsername(username)!=null) {
            return User.getUserByUsername(username).getPasswordRecoveryQuestion();

        }
        return null;
    }
    public static String forgotPasswordController(String answer){
        if(answer.equals(User.getUserByUsername(username).getAnswer())){
            return "successful";
        }
        else {
            return "answer incorrect";
        }
    }

    public static String getUsername() {
        return username;
    }

    public static String getNickname() {
        return nickname;
    }
    public static String getNewPassword(){
        return newPassword;
    }

    protected static String getOldPassword() {
        return oldPassword;
    }

    public static String getEmail() {
        return email;
    }

    public static String getSlogan() {
        return slogan;
    }
    public static void captcha() {
//        int width = 100;
//        int height = 30;
//        Random random = new Random();
//        while (true) {
//            int randomDigitNumber;
//            while (true) {
//                randomDigitNumber = random.nextInt(8);
//                if (randomDigitNumber >= 4)
//                    break;
//            }
//            randomNumber = random.nextInt((int) Math.pow((double) 10, (double) randomDigitNumber));
//            if (randomNumber > 1000)
//                break;
//
//        }
//        String randomString = Integer.toString(randomNumber);
//        StringBuilder randomString2 = new StringBuilder();
//        for (int i = 0; i < randomString.length(); i++) {
//            int randomNum = random.nextInt(10);
//            randomString2.append(randomString.charAt(i));
//            if (randomNum % 2 == 0) {
//                randomString2.append("$");
//            }
//
//        }
//
//        String randomString3 = randomString2.toString();
//        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        Graphics g = image.getGraphics();
//        g.setFont(new Font("SansSerif", Font.PLAIN, 16));
//
//        Graphics2D graphics = (Graphics2D) g;
//        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
//                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//        graphics.drawString(randomString3, 1, 20);
//        for (int y = 0; y < height; y++) {
//            StringBuilder sb = new StringBuilder();
//            for (int x = 0; x < width; x++) {
//
//                sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");
//
//            }
//
//            if (sb.toString().trim().isEmpty()) {
//                continue;
//            }
//
//            SignupMenuAndLoginMenu.print(sb.toString());
//        }
    }
    public static String checkCaptcha(int number){
        if(number!=randomNumber)
            return "number isn't correct!";
        return "successful";
    }
    public static String encrypt(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(input.getBytes());

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String hex = Integer.toHexString(0xff & messageDigest[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}