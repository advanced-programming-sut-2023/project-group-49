package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.ProfileMenuController;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private Image avatar;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String slogan;
    private String passwordRecoveryQuestion;
    private String answer;
    private int score;

    public Image getAvatar() {
        return avatar;
    }

    private static ArrayList<User> allUsers ;
    private final int userId;
    private static int lastUserId;
    static {
        lastUserId=1;
        allUsers=new ArrayList<>();
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public User(String username, String password, String nickname, String email) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.userId=lastUserId;
        this.avatar=new Image(Objects.requireNonNull(
                ProfileMenuController.class.getResource("/images/1.png")).toExternalForm());
        lastUserId++;

    }


    public static void addUser(User user) {
        allUsers.add(user);
    }

    public static User getUserByUsername(String username) {
        for (User user : allUsers) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    public static User getUserByEmail(String email) {
        for (User user : allUsers) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }


    public boolean isPasswordCorrect(String password) {
        return this.getPassword().equals(password);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public void setPasswordRecoveryQuestion(String passwordRecoveryQuestion) {
        this.passwordRecoveryQuestion = passwordRecoveryQuestion;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getSlogan() {
        return slogan;
    }

    public String getPasswordRecoveryQuestion() {
        return passwordRecoveryQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public int getUserId() {
        return userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
