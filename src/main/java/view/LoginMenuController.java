package view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class LoginMenuController extends Application {
    public static BorderPane borderPane;
    public static Stage stage;
    @FXML
    public TextField username;
    public TextField password;
    public VBox vbox;
    public Boolean correctAnswer = false;
    public String randomCaptchaNumber;
    public static User loginUser;
    public Button submit;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL url = SignupMenuAndLoginMenu.class.getResource("/FXML/loginMenu.fxml");
        borderPane = FXMLLoader.load(url);
        LoginMenuController.stage=stage;
        Scene scene = new Scene(borderPane, 800, 650);
        Image image = new Image(Objects.requireNonNull(
                SignupMenuController.class.getResource("/images/loginBack.jpg")).toExternalForm());
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true));

        Background background = new Background(backgroundImage);
        borderPane.setBackground(background);
        stage.setScene(scene);
        stage.show();
    }

    public void submit(MouseEvent mouseEvent) {
        String result = Controller.LoginMenuController.userLogin(username.getText(), password.getText());
        if (!(result).equals("successful")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(result);
            alert.showAndWait();
        } else if ( result.equals("successful")) {
          captcha();
        }
    }

    private void captcha() {
        Button captchaButton = new Button("submit");
        TextField captchaText = new TextField();
        captchaText.setPromptText("write number");
        captchaText.setMinWidth(200);
        captchaText.setMaxWidth(200);
        vbox.getChildren().addAll(captchaButton,captchaText);
        selectCaptcha();
        Alert alert=new Alert(Alert.AlertType.ERROR);
        captchaButton.setOnMouseClicked(mouseEvent1 -> {
            if(!captchaText.getText().equals(randomCaptchaNumber)){
                alert.setTitle("Error");
                alert.setContentText("captcha isn't correct!");
                alert.showAndWait();
            }
            else {
                loginUser=User.getUserByUsername(username.getText());
                MainMenu mainMenu=new MainMenu();
                try {
                    mainMenu.start(stage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    public void signup(MouseEvent mouseEvent) throws Exception {
        SignupMenuController signupMenuController=new SignupMenuController();
        signupMenuController.start(stage);
    }

    public void forgotPassword(MouseEvent mouseEvent) throws Exception {
        TextField textField = new TextField();
        textField.setPromptText(User.getUserByUsername(username.getText()).getPasswordRecoveryQuestion());
        textField.setMaxWidth(200);
        if(!vbox.getChildren().contains(textField)) {
            vbox.getChildren().add(textField);
        }
        submit.setOnMouseClicked(mouseEvent1 -> {
            if (!textField.getText().equals(User.getUserByUsername(username.getText()).getAnswer())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("your answer is wrong!");
            } else {
               captcha();
            }
        });

    }
    private void selectCaptcha() {
        Random random=new Random();
        int lineNumber=random.nextInt(50);
        int counter=0;
        try {
            File myObj = new File("src/main/resources/captchanumber.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                randomCaptchaNumber = myReader.nextLine();
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
        Rectangle rectangle = new Rectangle(300, 200);
        rectangle.setFill(new ImagePattern(
                new Image(Objects.requireNonNull(SecurityQuestion.class.getResource("/Captcha/"+randomCaptchaNumber.trim()+".png")).toExternalForm())));
        vbox.getChildren().add(rectangle);
    }
}
