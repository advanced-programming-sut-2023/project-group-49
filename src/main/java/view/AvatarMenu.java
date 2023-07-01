package view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class AvatarMenu extends Application {

    public static Stage stage;

    @FXML
    public TextField username;
    @FXML
    public PasswordField password;

    public TextField email;
    public TextField nickname;


    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        URL url= AvatarMenu.class.getResource("/FXML/avatarMenu.fxml");
        BorderPane borderPane= FXMLLoader.load(url);
        AvatarMenu.stage=stage;
        stage.getIcons().add(new Image(SignupMenuController.class.getResource("/images/iconCR.png").toExternalForm()));
        stage.setTitle("STRONG HOLD");
        //stage.setFullScreen(true);
        //stage.setMaximized(true);
        stage.setMaxHeight(650);
        stage.setMaxWidth(800);

        ///////

        Scene scene=new Scene(borderPane);
        Image image = new Image(Objects.requireNonNull(
                ProfileMenuController.class.getResource("/images/01.jpg")).toExternalForm());
        ImageView imageView = new ImageView(image);
        BackgroundImage backgroundImage = new BackgroundImage(imageView.getImage(), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(100,100,true,true,true,true));

        ////////////////////////////////////////
        Image image2 = new Image(Objects.requireNonNull(
                ProfileMenuController.class.getResource("/images/th.png")).toExternalForm());
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(90);
        imageView2.setFitHeight(90);
        imageView2.setX(50);
        imageView2.setY(400);
        imageView2.setOnMouseClicked(mouseEvent -> {
            LoginMenuController.loginUser.setAvatar(image2);
        });


        Image image3 = new Image(Objects.requireNonNull(
                ProfileMenuController.class.getResource("/images/bin.png")).toExternalForm());
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitWidth(100);
        imageView3.setFitHeight(100);
        imageView3.setX(200);
        imageView3.setY(400);
        imageView3.setOnMouseClicked(mouseEvent -> {
            LoginMenuController.loginUser.setAvatar(image3);
        });

        Image image4 = new Image(Objects.requireNonNull(
                ProfileMenuController.class.getResource("/images/1.png")).toExternalForm());
        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitWidth(70);
        imageView4.setFitHeight(70);
        imageView4.setX(50);
        imageView4.setY(150);
        imageView4.setOnMouseClicked(mouseEvent -> {
            LoginMenuController.loginUser.setAvatar(image4);
        });

        Image image5 = new Image(Objects.requireNonNull(
                ProfileMenuController.class.getResource("/images/2.png")).toExternalForm());
        ImageView imageView5 = new ImageView(image5);
        imageView5.setFitWidth(70);
        imageView5.setFitHeight(70);
        imageView5.setX(200);
        imageView5.setY(150);
        imageView5.setOnMouseClicked(mouseEvent -> {
            LoginMenuController.loginUser.setAvatar(image5);
        });

        Image image6 = new Image(Objects.requireNonNull(
                ProfileMenuController.class.getResource("/images/3.png")).toExternalForm());
        ImageView imageView6 = new ImageView(image6);
        imageView6.setFitWidth(70);
        imageView6.setFitHeight(70);
        imageView6.setX(350);
        imageView6.setY(150);
        imageView6.setOnMouseClicked(mouseEvent -> {
            LoginMenuController.loginUser.setAvatar(image6);
        });

        Image image7 = new Image(Objects.requireNonNull(
                ProfileMenuController.class.getResource("/images/4.png")).toExternalForm());
        ImageView imageView7 = new ImageView(image7);
        imageView7.setFitWidth(70);
        imageView7.setFitHeight(70);
        imageView7.setX(500);
        imageView7.setY(150);
        imageView7.setOnMouseClicked(mouseEvent -> {
            LoginMenuController.loginUser.setAvatar(image7);
        });

        Image image8 = new Image(Objects.requireNonNull(
                ProfileMenuController.class.getResource("/images/or.png")).toExternalForm());
        ImageView imageView8 = new ImageView(image8);
        imageView8.setFitWidth(90);
        imageView8.setFitHeight(90);
        imageView8.setX(650);
        imageView8.setY(135);
        imageView8.setOnMouseClicked(mouseEvent -> {
            LoginMenuController.loginUser.setAvatar(image8);
        });

        Image image9 = new Image(Objects.requireNonNull(
                ProfileMenuController.class.getResource("/images/brg.png")).toExternalForm());
        ImageView imageView9 = new ImageView(image9);
        imageView9.setFitWidth(90);
        imageView9.setFitHeight(90);
        imageView9.setX(400);
        imageView9.setY(400);
        imageView9.setOnMouseClicked(mouseEvent -> {
            LoginMenuController.loginUser.setAvatar(image9);
        });

        Image image10 = new Image(Objects.requireNonNull(
                ProfileMenuController.class.getResource("/images/greec.png")).toExternalForm());
        ImageView imageView10 = new ImageView(image10);
        imageView10.setFitWidth(90);
        imageView10.setFitHeight(90);
        imageView10.setX(600);
        imageView10.setY(400);
        imageView10.setOnMouseClicked(mouseEvent -> {
            LoginMenuController.loginUser.setAvatar(image10);
        });


        ///////////////////////////////////////
        Background background = new Background(backgroundImage);

        borderPane.setBackground(background);
        borderPane.getChildren().addAll(imageView2,imageView3,imageView4,imageView5,imageView6
                ,imageView7,imageView8,imageView9,imageView10);
        stage.setScene(scene);

        Rectangle  rectangle1= new Rectangle(10,20);



        stage.show();
    }


    public void back(MouseEvent mouseEvent) throws Exception {
        new ProfileMenuController().start(stage);
    }
}