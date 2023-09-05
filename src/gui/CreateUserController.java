package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import painterestt.models.User;
import painterestt.services.ServiceUser;

public class CreateUserController implements Initializable {

    @FXML
    private PasswordField pwdTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField usernameTF;
    @FXML
    private DatePicker birthdateTF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createUser(ActionEvent event) {
        try {
            ServiceUser serviceUser = new ServiceUser();
            User user = new User();
            Date newDate = Date.valueOf(birthdateTF.getValue());
            user.setUsername(usernameTF.getText());
            user.setEmail(emailTF.getText());
            user.setPassword(pwdTF.getText());
            user.setBirthdate(newDate);
            serviceUser.CreateUser(user);
            
            showAlert("User is added successfully.", Alert.AlertType.INFORMATION);
        } catch(NumberFormatException nfe) {
            showAlert("Fill out the labels correctly.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }
    
    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Painterest");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
