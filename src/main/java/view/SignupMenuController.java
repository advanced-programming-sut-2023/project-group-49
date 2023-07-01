package view;
import Controller.Controller;

import controller.SignupController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.Objects;

public class SignupMenuController extends Application {
    public static Stage stage;
   public String slogan1;
   public TextField textField=new TextField("");
    @FXML
    public  TextField username;
    public PasswordField password;
    public VBox vbox;
    public PasswordField passwordConfirmation;
    public TextField email;
    public TextField nickname;

    public static SignupMenuController currentSignupMenu;
    public static BorderPane borderPane;
    public static Timeline timeline;
    public Label errorTextUsername=new Label();
    public Label passwordTextError=new Label();
    public Label error=new Label();
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        URL url= SignupMenuAndLoginMenu.class.getResource("/FXML/signupMenu.fxml");
        borderPane= FXMLLoader.load(url);
        SignupMenuController.stage=stage;
        stage.getIcons().add(new Image(SignupMenuController.class.getResource("/images/iconCR.png").toExternalForm()));
        stage.setTitle("STRONG HOLD");
        Scene scene=new Scene(borderPane,800,650);
        Image image = new Image(Objects.requireNonNull(
                SignupMenuController.class.getResource("/images/SignUpMenuBack.jpg")).toExternalForm());
        ImageView imageView = new ImageView(image);
        BackgroundImage backgroundImage = new BackgroundImage(imageView.getImage(),BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(100,100,true,true,true,true));

        Background background = new Background(backgroundImage);
        borderPane.setBackground(background);
        stage.setScene(scene);
        stage.show();
    }

    public void submit(MouseEvent mouseEvent) {
        currentSignupMenu=this;
        String result;
        result=SignupMenuAndLoginMenu.register();
        Alert alert=new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText("signup error");
        alert.setContentText(result);
        alert.showAndWait();

    }


    public void random(MouseEvent mouseEvent) {
       String randomPassword=Controller.randomPassword();
       password.setText(randomPassword);
       Label label=new Label();
       vbox.getChildren().add(label);
       label.setText("your random password is: "+randomPassword);

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

    public void randomSlogan(MouseEvent mouseEvent) {
        TextField sloganTextField=new TextField();
        sloganTextField.setPromptText("slogan");
        sloganTextField.setMaxSize(600,10);
        Button randomSlogan=new Button("random slogan");
        slogan1=sloganTextField.getText();
        randomSlogan.setOnMouseClicked(MouseEvent ->{
            sloganTextField.setText(Controller.randomSlogan());
            slogan1=Controller.randomSlogan();
        } );
        ComboBox<String> famousSlogan = new ComboBox<>();
        famousSlogan.getItems().addAll("God wills it!",
                "For the Holy Land!",
                "Crusaders, forward!",
                "Deus vult!",
                "We march to glory!",
                "Defend the faith!",
                "Onward to Jerusalem!",
                "With God's help, we'll prevail!"
);
        famousSlogan.setValue("famous slogan");
        famousSlogan.setOnAction(actionEvent -> {
            slogan1=famousSlogan.getValue();
        });
        vbox.getChildren().addAll(sloganTextField,randomSlogan,famousSlogan);
    }

    public void checkError(MouseEvent mouseEvent) {
        if(!vbox.getChildren().contains(error)) {
            vbox.getChildren().add(error);
        }
      //  Alert alert=new Alert(Alert.AlertType.ERROR);
        if(password.getText().length()==0||passwordConfirmation.getText().length()==0||username.getText().length()==0||
        email.getText().length()==0||nickname.getText().length()==0){
           /* alert.setTitle("error");
            alert.setContentText("empty field");
            alert.showAndWait();*/
            error.setText("empty field");
        }
       else if(!password.getText().equals(passwordConfirmation.getText())){
      /*  alert.setTitle("error");
        alert.setContentText("password confirmation isn't correct");
        alert.showAndWait();*/
            error.setText("password confirmation isn't correct");
        }
       else if(!Controller.checkEmailFormats(email.getText()).equals("successful")){
           /* alert.setTitle("error");
            alert.setContentText(Controller.checkEmailFormats(email.getText()));
            alert.showAndWait();*/
            error.setText(Controller.checkEmailFormats(email.getText()));
        }
       else if(!passwordTextError.getText().equals("")||!errorTextUsername.getText().equals("")){
           ;
        }
       else{
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Registration was successful.");
            alert.showAndWait();
            try {

                SecurityQuestion.save(username.getText(),password.getText(),email.getText(),nickname.getText(),slogan1);
                new SecurityQuestion().start(stage);
            } catch (Exception e) {

            }
        }

    }

    public void login(MouseEvent mouseEvent) throws Exception {
        LoginMenuController loginMenuController=new LoginMenuController();
        loginMenuController.start(stage);
    }

    public void showPassword(MouseEvent mouseEvent) {
        textField.setMaxWidth(200);
        if(!vbox.getChildren().contains(textField)){
            textField.setText(password.getText());
            vbox.getChildren().add(vbox.getChildren().indexOf(password),textField);
            vbox.getChildren().remove(password);
        }
        else{
            password.setText(textField.getText());
            vbox.getChildren().add(vbox.getChildren().indexOf(textField),password);
            vbox.getChildren().remove(textField);
        }
    }
}
