/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import painterestt.models.User;
import painterestt.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author nadab
 */
public class LoginController implements Initializable {

     PreparedStatement prepareStatement;
    ResultSet resultSet;
    @FXML
    private TextField usernameLabel;
    @FXML
    private PasswordField passwordLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginBT(ActionEvent event) throws IOException {
        try{
         if (usernameLabel.getText().isEmpty()|| passwordLabel.getText().isEmpty() ){
             
     System.out.println("Champs invalide!");
            }
         else
         {
             
         MyConnection cnx=new MyConnection();
        prepareStatement=cnx.getCnx().prepareStatement("select * from user where email=? and mot_de_passe=?");
        prepareStatement.setString(1,usernameLabel.getText());
       
        prepareStatement.setString(2,passwordLabel.getText());
            resultSet = prepareStatement.executeQuery();
            if(!resultSet.isBeforeFirst()){
            System.out.println("Compte invalide!");
            usernameLabel.setText("");
            
            passwordLabel.setText("");
            }
            else
            {
                while(resultSet.next()){
            Parent root = FXMLLoader.load(getClass().getResource("CreateUser.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
                  
                }
            }
         }
     }catch (SQLException e){
         
     }   
    }


    @FXML
    private void forgotpwd(MouseEvent event) {
    }
    
}
