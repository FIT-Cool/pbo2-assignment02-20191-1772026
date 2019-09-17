package com.steven.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class DepartmentFormControl {
    @FXML
    private VBox departmentForm;
    @FXML
    private TableView tableDepartment;
    @FXML
    private TextField txtKode;
    @FXML
    private TextField txtName;
    @FXML
    private TableColumn col01;
    @FXML
    private TableColumn col02;
    @FXML
    private TableColumn col03;

    @FXML
    private void tambahAction(ActionEvent actionEvent) {
    }

    @FXML
    private void tableCllicked(MouseEvent mouseEvent) {
    }
}
