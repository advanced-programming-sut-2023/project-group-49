package view;

import controller.Controller;
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

    @FXML
    public TextField username;
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
        //stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.setMaxHeight(900);
        stage.setMaxWidth(2000);
        ///////

        Scene scene=new Scene(borderPane);
        Image image = new Image(Objects.requireNonNull(
                SignupMenuController.class.getResource("/images/Back.jpg")).toExternalForm());
        ImageView imageView = new ImageView(image);
        BackgroundImage backgroundImage = new BackgroundImage(imageView.getImage(),BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(100,100,true,true,true,true));

        Background background = new Background(backgroundImage);
        borderPane.setBackground(background);
        stage.setScene(scene);

//        TextField username = new TextField ();
//        username.setPromptText("username");
//        username.setMaxSize(200,10);
//        PasswordField password=new PasswordField();
//        password.setPromptText("password");
//        password.setMinSize(100,20);
//        ToggleButton showPasswordButton=new ToggleButton("show password");
//        showPasswordButton.setMinSize(50,10);
//        HBox hBox=new HBox(password,showPasswordButton);
//        hBox.setSpacing(10);
//        hBox.setMinSize(800,10);
//        hBox.setAlignment(Pos.CENTER);
//        PasswordField passwordConfirmationField=new PasswordField();
//        passwordConfirmationField.setPromptText("password confirmation");
//        passwordConfirmationField.setMaxSize(200,10);
//        TextField nickname=new TextField();
//        nickname.setPromptText("nickname");
//        nickname.setMaxSize(200,10);
//        TextField email=new TextField();
//        email.setPromptText("email");
//        email.setMaxSize(200,10);
//        VBox vb = new VBox();
//        vb.setAlignment(Pos.CENTER);
//        vb.setMinSize(300,300);
//        vb.getChildren().addAll(username,hBox,passwordConfirmationField,nickname,email);
//        vb.setSpacing(10);
//        Image image = new Image(Objects.requireNonNull(
//                SignupMenuController.class.getResource("/images/Back.jpg")).toExternalForm());
//        ImageView imageView = new ImageView(image);
//        BackgroundImage backgroundImage = new BackgroundImage(imageView.getImage(),BackgroundRepeat.NO_REPEAT,
//                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
//                new BackgroundSize(100,100,true,true,true,true));
//
//        Background background = new Background(backgroundImage);
//        Background background1 = new Background(new BackgroundFill(Color.BLACK,null,null));
//
//        vb.setBackground(background);
//        Scene scene=new Scene(vb);
//
//
//        scene.getStylesheets().addAll(SignupMenuController.class.getResource("/CSS/style1.css").toExternalForm());
//        stage.setScene(scene);
//
//    StringProperty textProperty =username.textProperty();
//     Label errorText=new Label("");
//      vbox.getChildren().add(errorText);
//
//        VBox.setMargin(hBox, new Insets(0, 0, 0, 50));
//
//        showPasswordButton.setOnAction(event -> {
//
//            showPasswordButton.setText("hide password");
//
//          /*  if(!password.isVisible())
//            password.setVisible(true);
//            else password.setVisible(false);*/
//        });
//        Button createRandomPassword=new Button("random password");
//        vb.getChildren().add(createRandomPassword);
//        createRandomPassword.setOnMouseClicked(mouseEvent -> {
//            Label label=new Label();
//
//            System.out.println(SignupController.randomPassword());
//
//            //label.setText("your random password is:"+ controller.SignupMenuController.randomPassword());
//            vb.getChildren().add(label);
//        });
//        // vb.getChildren().add(showPasswordButton);
       /* StringProperty textProperty =username.textProperty();
        textProperty.addListener((observable, oldValue, newValue) -> {
            String text = textProperty.get();
        });
        StringProperty textProperty2 =password.textProperty();
        textProperty2.addListener((observable, oldValue, newValue) -> {
            String text2 = textProperty2.get();


        });
        Label errorTextUsername=new Label("");

        Label errorTextPassword=new Label("");
        vbox.getChildren().addAll(errorTextUsername,errorTextPassword);*/
//        try {
//            StringProperty textProperty =username;
//            textProperty.addListener((observable, oldValue, newValue) -> {
//                String text = textProperty.get();
//                System.out.println(text);
//            });
//        }catch (NullPointerException ignored){
//
//        }
//        timeline = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
//          /*  errorTextUsername.setLayoutY(300);
//            errorTextUsername.setLayoutX(300);
//            errorTextPassword.setLayoutX(300);
//            errorTextPassword.setLayoutY(310);
//            String result;
//            if(!username.getText().matches("[a-zA-Z0-9_]+")&&username.getText().length()!=0){
//                errorTextUsername.setText("invalid username format!");
//            }
//            if(!(result=Controller.checkPasswordFormat(password.getText())).equals("password successfully changed!")){
//                errorTextPassword.setText(result);
//            }
//            if(username.getText().matches("[a-zA-Z0-9_]+")||username.getText().length()==0){
//                errorTextUsername.setText("");
//            }
//            if((result=Controller.checkPasswordFormat(password.getText())).equals("password successfully changed!")){
//                errorTextPassword.setText("");
//            }
//
//*
//           */
//
//        }));
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
        Button randomSlogan=new Button("random slogan");
       
        randomSlogan.setOnMouseClicked(MouseEvent ->{
            sloganTextField.setText(Controller.randomSlogan());
        } );
        vbox.getChildren().addAll(sloganTextField,randomSlogan);
    }

    public void checkError(MouseEvent mouseEvent) {
        if(!vbox.getChildren().contains(error)) {
            vbox.getChildren().add(error);
        }
        System.out.println(password.getText().length());
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
       else{
            try {
                new SecurityQuestion().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
