package view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import model.User;

public class SignupMenuController {

    @FXML
    public TextField username;
    public PasswordField password;
    public PasswordField passwordConfirmation;
    public static User user1;

    public void submit(MouseEvent mouseEvent) {
        CommandsEnum result;
        result = controller.SignupMenuController.checkUsername(username.getText());
        Alert alert=new Alert(Alert.AlertType.WARNING);
        if(!result.equals("successful")){
            alert.setTitle("Error");
            alert.setHeaderText("signup error");
            alert.showAndWait();
        }
        else if(password.getText().length()<4){
            alert.setTitle("Error");
            alert.setHeaderText("signup error");
            alert.setContentText("your password is weak");
            alert.showAndWait();
        }
        else if(!password.getText().equals(passwordConfirmation.getText())){
            alert.setTitle("Error");
            alert.setHeaderText("signup error");
            alert.setContentText("your password confirmation isn't correct!");
            alert.showAndWait();
        }

        else {
            Alert alert1=new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("successful");
            alert1.setContentText("signup successful please go to login menu and enter your username and password");
            alert1.showAndWait();
            controller.SignupMenuController.userDataBase();
        }
    }


}
