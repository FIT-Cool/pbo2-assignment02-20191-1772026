package com.steven.controller;

import com.steven.model.Fakultas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {

    @FXML
    private BorderPane border;
    private ObservableList<Fakultas> faculties;

    public ObservableList<Fakultas> getFaculties() {
        if (faculties.isEmpty())faculties= FXCollections.observableArrayList();
        return faculties;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void buttonDepartment(ActionEvent actionEvent) {
        try {
            VBox box;
            box=FXMLLoader.load(getClass().getResource("../view/DepartmentForm.fxml"));
            border.setCenter(box);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void buttonFakultas(ActionEvent actionEvent) {
        try {
//            Parent root = FXMLLoader.load(getClass().getResource("../view/FacultyForm.fxml"));
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/FacultyForm.fxml"));
            FacultyFormController controller=loader.getController();
            controller.setMainFormController(this);
            VBox root=loader.load();
//            Stage mainStage = new Stage();
//            mainStage.setTitle("Main Form");s
//            mainStage.setScene(new Scene(root));
//            mainStage.show();

//            ((Stage) login.getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            VBox box;
//            box=FXMLLoader.load(getClass().getResource("../view/FacultyForm.fxml"));
//            border.setCenter(box);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
