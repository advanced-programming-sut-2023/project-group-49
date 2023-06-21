package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

public class SecurityQuestion extends Application {
    public static Stage stage;
    public String selectedChoice;

    @Override
    public void start(Stage stage) throws Exception {
        VBox box=new VBox();
        Stage stage1=new Stage();
        Scene scene=new Scene(box);
        SecurityQuestion.stage=stage;
        stage1.setScene(scene);
        stage1.setFullScreen(true);
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
        selectCaptcha();
        textField.setOnAction(actionEvent -> {

        });
        stage1.show();
    }

    private void selectCaptcha() {
        File folder = new File("src/main/resources/Captcha");
        File[] files = folder.listFiles();
        for (File file : Objects.requireNonNull(files)) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

    }

    private void choice(String value) {
    }

}
