package view;

import controller.SignupController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SignupMenuController extends Application {

    @FXML
    public TextField username;
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
        //  URL url= SignupMenuAndLoginMenu.class.getResource("/FXML/signupMenu.fxml");
        TextField username = new TextField ();
        username.setPromptText("username");
        PasswordField password=new PasswordField();
        password.setPromptText("password");
        PasswordField passwordConfirmationField=new PasswordField();
        passwordConfirmationField.setPromptText("password confirmation");
        TextField nickname=new TextField();
        nickname.setPromptText("nickname");
        TextField email=new TextField();
        email.setPromptText("email");
        VBox vb = new VBox();
        vb.setMinSize(300,300);
        vb.getChildren().addAll(username,passwordConfirmationField,email,nickname);
        vb.setSpacing(10);

        Scene scene=new Scene(vb);
        stage.setScene(scene);
        StringProperty textProperty =username.textProperty();
        Label errorText=new Label("");
        vb.getChildren().add(errorText);
        ToggleButton showPasswordButton=new ToggleButton("show password");
        HBox hBox=new HBox(password,showPasswordButton);
        VBox.setMargin(hBox, new Insets(0, 0, 0, 50));
        vb.getChildren().add(hBox);
        showPasswordButton.setOnAction(event -> {

            showPasswordButton.setText("\u2713 hide password");

          /*  if(!password.isVisible())
            password.setVisible(true);
            else password.setVisible(false);*/
        });
        Button createRandomPassword=new Button("random password");
        vb.getChildren().add(createRandomPassword);
        createRandomPassword.setOnMouseClicked(mouseEvent -> {
            Label label=new Label();

            System.out.println(SignupController.randomPassword());

            //label.setText("your random password is:"+ controller.SignupMenuController.randomPassword());
            vb.getChildren().add(label);
        });
        // vb.getChildren().add(showPasswordButton);
        textProperty.addListener((observable, oldValue, newValue) -> {
            String text = textProperty.get();


        });

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
            errorText.setLayoutY(300);
            errorText.setLayoutX(300);
            if(!username.getText().matches("[a-zA-Z0-9_]+")&&username.getText().length()!=0){
                errorText.setText("invalid username format!");
            }
            else{
                errorText.setText("");
            }


        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
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
