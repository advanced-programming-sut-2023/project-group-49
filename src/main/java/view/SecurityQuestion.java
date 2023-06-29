package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class SecurityQuestion extends Application {
    public static Stage stage;
    public String randomCaptchaNumber;
    public static VBox VBox;
    public String selectedChoice;

    @Override
    public void start(Stage stage) throws Exception {
        VBox box=new VBox();
        VBox=box;
        Stage stage1=new Stage();
        stage1.setWidth(500);
        stage1.setHeight(400);
        Scene scene=new Scene(box);
        SecurityQuestion.stage=stage;
        stage1.setScene(scene);
        Button close= new Button("Close");
        close.setOnAction(e -> stage1.close());
        box.getChildren().addAll(close);


        ComboBox<String> questions = new ComboBox<>();
        questions.getItems().addAll("What is my father's name?", "What is my first pet's name?", "What is my mother's last name?");
        questions.setValue("What is my father's name?");
        box.getChildren().add(questions);
       /* nodeComboBox.setLayoutX(200);
        nodeComboBox.setLayoutY(100);*/
        selectedChoice = questions.getValue();
        TextField textField=new TextField();
        textField.setPromptText("answer");
        box.getChildren().add(textField);
        questions.setOnMouseClicked(mouseEvent -> {
            selectedChoice = questions.getValue();
            choice(questions.getValue());
        });
        Button button=new Button("submit");
        box.getChildren().add(button);
        Button captchaButton=new Button("submit");
        TextField captchaText=new TextField();
        captchaText.setPromptText("write number");

        button.setOnAction(actionEvent -> {
            selectCaptcha();
            box.getChildren().addAll(captchaButton,captchaText);

        });
        Alert alert=new Alert(Alert.AlertType.ERROR);
        captchaButton.setOnMouseClicked(mouseEvent -> {
            if(!captchaText.getText().equals(randomCaptchaNumber)){
                alert.setTitle("Error");
                alert.setContentText("captcha isn't correct!");
                alert.showAndWait();
            }

        });

        stage1.showAndWait();
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
        System.out.println(randomCaptchaNumber);
        Rectangle rectangle = new Rectangle(300, 200);
        rectangle.setFill(new ImagePattern(
                new Image(Objects.requireNonNull(SecurityQuestion.class.getResource("/Captcha/"+randomCaptchaNumber.trim()+".png")).toExternalForm())));
        VBox.getChildren().add(rectangle);

    }

    private void choice(String value) {
    }

}
