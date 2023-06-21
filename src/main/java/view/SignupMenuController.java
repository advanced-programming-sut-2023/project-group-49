package view;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.Objects;

public class SignupMenuController extends Application {
    public static Stage stage;

    @FXML
    public TextField username;
    @FXML
    public PasswordField password;
    public PasswordField passwordConfirmation;
    public TextField email;
    public TextField nickname;
    public static SignupMenuController currentSignupMenu;
    public static Timeline timeline;
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        URL url= SignupMenuAndLoginMenu.class.getResource("/FXML/signupMenu.fxml");
        BorderPane borderPane= FXMLLoader.load(url);
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
//        StringProperty textProperty =username.textProperty();
//        Label errorText=new Label("");
//        vb.getChildren().add(errorText);
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
//        textProperty.addListener((observable, oldValue, newValue) -> {
//            String text = textProperty.get();
//
//
//        });
//
//        timeline = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
//            errorText.setLayoutY(300);
//            errorText.setLayoutX(300);
//            if(!username.getText().matches("[a-zA-Z0-9_]+")&&username.getText().length()!=0){
//                errorText.setText("invalid username format!");
//            }
//            else{
//                errorText.setText("");
//            }
//
//
//        }));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
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


}
