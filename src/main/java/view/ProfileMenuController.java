package view;

import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

public class ProfileMenuController extends Application {

    @FXML
    public static Stage stage;
    public Label errorTextUsername=new Label();
    public Label passwordTextError=new Label();
    public BorderPane borderPane;
    public Label error=new Label();
    public static User currentuser = new User("name","12Ab/","nickname","email@gmail.com");

    @FXML
    public TextField username;
    @FXML
    public PasswordField password;

    public TextField email;
    public TextField nickname;
    public VBox vbox;
    public TextField slogan;


    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        URL url= ProfileMenuController.class.getResource("/FXML/profileMenu.fxml");
        borderPane= FXMLLoader.load(url);
        ProfileMenuController.stage=stage;
        stage.getIcons().add(new Image(ProfileMenuController.class.getResource("/images/iconCR.png").toExternalForm()));
        stage.setTitle("STRONG HOLD");
        //stage.setFullScreen(true);
        //stage.setMaximized(true);
        stage.setMaxHeight(650);
        stage.setMaxWidth(800);
        ///////

        Scene scene=new Scene(borderPane);
        Image image = new Image(Objects.requireNonNull(
                ProfileMenuController.class.getResource("/images/IMG_6047 (1).PNG")).toExternalForm());
        ImageView imageView = new ImageView(image);
        BackgroundImage backgroundImage = new BackgroundImage(imageView.getImage(), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(100,100,true,true,true,true));

        ImageView profileImage=new ImageView(currentuser.getAvatar());
        profileImage.setFitWidth(60);
        profileImage.setFitHeight(60);
        profileImage.setX(720);
        profileImage.setY(10);
        Background background = new Background(backgroundImage);
        borderPane.setBackground(background);
        borderPane.getChildren().add(profileImage);
        stage.setScene(scene);

        stage.show();
    }


    public void goToAvatar(MouseEvent mouseEvent) throws Exception {
            new AvatarMenu().start(ProfileMenuController.stage);

    }

    public void nameError(KeyEvent keyEvent) {
        errorTextUsername.setText("");
        if(!username.getText().matches("[a-zA-Z0-9_]+")&&username.getText().length()!=0){
            if(!vbox.getChildren().contains(errorTextUsername)) {
                vbox.getChildren().add(errorTextUsername);
            }
            errorTextUsername.setText("invalid username format!");
        }
        if(username.getText().matches("[a-zA-Z0-9_]+")){
            vbox.getChildren().remove(errorTextUsername);
        }
    }
    public void passwordError(KeyEvent keyEvent) {
        String result;
        if(!(result=Controller.checkPasswordFormat(password.getText())).equals("password successfully changed!")){
            if(!vbox.getChildren().contains(passwordTextError)) {
                vbox.getChildren().add(passwordTextError);
            }
            passwordTextError.setText(result);
        }
        if((result=Controller.checkPasswordFormat(password.getText())).equals("password successfully changed!")){
            passwordTextError.setText("");
        }
    }

    public void checkError(MouseEvent mouseEvent) {
        if(!vbox.getChildren().contains(error)) {
            vbox.getChildren().add(error);
        }
        System.out.println(password.getText().length());
        //  Alert alert=new Alert(Alert.AlertType.ERROR);
        if(password.getText().length()==0||username.getText().length()==0||
                email.getText().length()==0||nickname.getText().length()==0){
           /* alert.setTitle("error");
            alert.setContentText("empty field");
            alert.showAndWait();*/
            error.setText("empty field");
        }
        else if(!Controller.checkEmailFormats(email.getText()).equals("successful")){
           /* alert.setTitle("error");
            alert.setContentText(Controller.checkEmailFormats(email.getText()));
            alert.showAndWait();*/
            error.setText(Controller.checkEmailFormats(email.getText()));
        }
        else{
            try {
                new SecurityQuestion().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }


    public void changeUsername(MouseEvent mouseEvent) {
        if(!vbox.getChildren().contains(errorTextUsername)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("edit username");
            alert.setContentText("Username changed!");
            if(alert.showAndWait().get().getButtonData().isDefaultButton()){
                currentuser.setUsername(username.getText());
            }
            
        }
    }

    public void changePassword(MouseEvent mouseEvent) {
        if(!vbox.getChildren().contains(passwordTextError)){
            currentuser.setPassword(password.getText());
            //Dialog dialog=new Dialog();
        }
    }

    public void changeEmail(MouseEvent mouseEvent) {
        if(!vbox.getChildren().contains(error)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("edit email");
            alert.setContentText("Email changed!");
            if(alert.showAndWait().get().getButtonData().isDefaultButton()){
                currentuser.setEmail(email.getText());
            }

        }
    }


    public void changeSlogan(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("edit slogan");
        alert.setContentText("Slogan changed!");
        if(alert.showAndWait().get().getButtonData().isDefaultButton()){
            currentuser.setSlogan(slogan.getText());
        }
    }
}
