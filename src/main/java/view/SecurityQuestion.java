package view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class SecurityQuestion extends Application {
    public static Stage stage;
    public static String username;
    public static String password;
    public static String email;
    public static String nickname;
    public static String slogan;
    public String randomCaptchaNumber;
    public static Pane Box;
    public String selectedChoice;

    public String answer;

    @Override
    public void start(Stage stage1) throws Exception {
      //  Stage stage1=new Stage();
        Pane box=new Pane();
        Scene scene=new Scene(box,800,650);
        SecurityQuestion.stage=stage;
        stage1.setScene(scene);
        Image image = new Image(Objects.requireNonNull(
                SignupMenuController.class.getResource("/images/securityBackground1.jpg")).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(800);
        imageView.setFitHeight(650);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(100,100,true,true,true,true));
        Background background = new Background(backgroundImage);
       box.setBackground(background);
        Button close= new Button("Close");
        close.setLayoutY(620);
        close.setOnAction(e -> stage.close());
        box.getChildren().addAll(close);
        ComboBox<String> questions = new ComboBox<>();
        questions.getItems().addAll("What is my father's name?", "What is my first pet's name?", "What is my mother's last name?");
        questions.setValue("What is my father's name?");
        selectedChoice = questions.getValue();
        TextField textField=new TextField();
        textField.setMinWidth(200);
        textField.setMaxWidth(200);
        textField.setPromptText("answer");
        questions.setOnAction(mouseEvent -> {
            selectedChoice = questions.getValue();
            choice(questions.getValue());
        });
        choice(questions.getValue());
        Button button=new Button("submit");
        VBox vBox=new VBox(questions,textField,button);
        Box=vBox;
        vBox.setSpacing(10);
        vBox.setLayoutX(300);
        vBox.setLayoutY(160);
        box.getChildren().add(vBox);
        Button captchaButton=new Button("submit");
        TextField captchaText=new TextField();
        captchaText.setPromptText("write number");
        captchaText.setMinWidth(200);
        captchaText.setMaxWidth(200);
        button.setOnAction(actionEvent -> {
            if(!textField.getText().equals("")) {
                selectCaptcha();
                answer=textField.getText();
                creatUser();
                vBox.getChildren().addAll(captchaButton, captchaText);
            }

        });
        Alert alert=new Alert(Alert.AlertType.ERROR);
        captchaButton.setOnMouseClicked(mouseEvent -> {
            if(!captchaText.getText().equals(randomCaptchaNumber)){
                alert.setTitle("Error");
                alert.setContentText("captcha isn't correct!");
                alert.showAndWait();
            }
            else {
                SignupMenuController signupMenuController=new SignupMenuController();
                try {
                    signupMenuController.start(stage1);
                } catch (Exception e) {

                }
            }

        });

        stage1.show();
    }
      public static void save(String username1,String password1,String email1,String nickname1,String slogan1){
        username=username1;
        password=password1;
        email=email1;
        nickname=nickname1;
        slogan=slogan1;
      }
      public void creatUser(){
        User user=new User(username,password,nickname,email,selectedChoice,slogan,answer);
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
        Box.getChildren().add(rectangle);
    }

    private void choice(String value) {
      answer=value;
    }

}
