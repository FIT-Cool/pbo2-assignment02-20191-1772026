package com.steven.controller;

import com.steven.model.Fakultas;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class FacultyFormController implements Initializable {
    @FXML
    private TextField txtName;
    @FXML
    private TableView<Fakultas> tableDepartment;
    @FXML
    private TableColumn<Fakultas, String> col01;
    private ObservableList<Fakultas> faculties;
    @FXML
    private VBox fakultasForm;
    private MainFormController mainFormController;


    public void setMainFormController(MainFormController mainFormController) {
        this.mainFormController = mainFormController;
    }

    @FXML
    private void tambahAction(ActionEvent actionEvent) {
        Fakultas f = new Fakultas();
        f.setName(txtName.getText().trim());
        faculties.add(f);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        faculties = FXCollections.observableArrayList();
        tableDepartment.setItems(faculties);
        col01.setCellValueFactory(data -> {
            Fakultas f = data.getValue();
            return new SimpleStringProperty(f.getName());
        });

    }

    @FXML
    private void tableCllicked(MouseEvent mouseEvent) {
        Fakultas f=tableDepartment.getSelectionModel().getSelectedItem();
        txtName.setText(f.getName());
    }
}
