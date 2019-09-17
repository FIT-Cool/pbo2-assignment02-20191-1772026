package com.steven.controller;

import com.steven.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public TextField txtUsername;
    public PasswordField txtPassword;
    public GridPane login;

    public void loginAction(ActionEvent actionEvent) {
        if (txtUsername.getText().equals("steven") && txtPassword.getText().equals("1772026")) {
            try {
                Parent root = FXMLLoader.load(Main.class.getResource("view/MainForm.fxml"));
                Stage mainStage = new Stage();
                mainStage.setTitle("Main Form");
                mainStage.setScene(new Scene(root));
                mainStage.show();

                ((Stage) login.getScene().getWindow()).close();

            } catch (IOException e) {
                e.printStackTrace();
            }

//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Information");
//            alert.setContentText("Welcome Steven");
//            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Invalid username or password");
            alert.show();
        }
    }
}
