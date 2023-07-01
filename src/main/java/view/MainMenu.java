package view;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu extends Application {
    public static BorderPane borderPane;
    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        URL url = SignupMenuAndLoginMenu.class.getResource("/FXML/mainMenu.fxml");
        borderPane = FXMLLoader.load(url);
        MainMenu.stage=stage;
        Scene scene = new Scene(borderPane, 800, 650);
        Image image = new Image(Objects.requireNonNull(
                SignupMenuController.class.getResource("/images/mainMenuBack.jpg")).toExternalForm());
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true));

        Background background = new Background(backgroundImage);
        borderPane.setBackground(background);
        stage.setScene(scene);
        stage.show();

    }

    public void game(MouseEvent mouseEvent) throws IOException {
        game game=new game();
        game.start(stage);
    }

    public void profileMenu(MouseEvent mouseEvent) throws Exception {
        ProfileMenuController profileMenuController=new ProfileMenuController();
        profileMenuController.start(stage);
    }

    public void exit(MouseEvent mouseEvent) {
    }
}


