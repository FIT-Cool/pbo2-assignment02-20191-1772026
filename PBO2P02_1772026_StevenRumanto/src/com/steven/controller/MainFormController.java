package com.steven.controller;

import com.steven.entity.Category;
import com.steven.entity.Item;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
/**
 * Steven Rumanto
 * 1772026
 */
public class MainFormController implements Initializable {
    List<String> myCategory = new ArrayList<>();
    @FXML
    private ObservableList<Item> item;
    @FXML
    private TableView<Item> tableItem;
    @FXML
    private TextField txtNama;
    @FXML
    private TableColumn<Item, String> col01;
    @FXML
    private TableColumn<Item, String> col02;
    @FXML
    private TableColumn<Item, String> col03;
    @FXML
    private TextField txtPrice;
    @FXML
    private Button update;
    @FXML
    private TextField txtCategoryName;
    @FXML
    private ChoiceBox choiceBox;
    private int index;

    @FXML
    private void tambahAction(ActionEvent actionEvent) {
        try {
            if (txtNama.getText().trim().isEmpty() ||
                    txtPrice.getText().trim().isEmpty() ||

                    choiceBox.getSelectionModel().isEmpty()) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Please fill name/price/category");
                a.show();
            } else {
                Item i = new Item();
                Category c = new Category();
                c.setNama(choiceBox.getValue().toString());
                i.setNama(txtNama.getText().trim());
                i.setPrice(txtPrice.getText().trim());
                i.setCategory(c);
                item.add(i);
            }

        } catch (Exception e) {
        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        item = FXCollections.observableArrayList();
        tableItem.setItems(item);
        col01.setCellValueFactory((data) -> {
            Item f = data.getValue();
            return new SimpleStringProperty(f.getNama());
        });
        col02.setCellValueFactory((data) -> {
            Item f = data.getValue();
            return new SimpleStringProperty(f.getPrice());
        });
        col03.setCellValueFactory((data) -> {
            Item f = data.getValue();
            return new SimpleStringProperty(f.getCategory().getNama());
        });
    }


    @FXML
    private void keluar(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    private void tentang(ActionEvent actionEvent) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Steven Rumanto \n1772026");
        a.show();
    }

    @FXML
    private void reset(ActionEvent actionEvent) {
        txtCategoryName.setText("");
        txtNama.setText("");
        txtPrice.setText("");
        update.setDisable(true);
    }

    @FXML
    private void update(ActionEvent actionEvent) {
        Item i = tableItem.getSelectionModel().getSelectedItem();
        Category c = new Category();
        c.setNama(choiceBox.getValue().toString());
        i.setNama(txtNama.getText());
        i.setPrice(txtPrice.getText());
        i.setCategory(c);
        tableItem.getItems().set(index, i);

    }

    @FXML
    private void simpanKategori(ActionEvent actionEvent) {
        if (txtCategoryName.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please fill category name");
            a.show();
        } else {
            boolean cek = false;
            for (String str : myCategory) {
                if (str.trim().contains(txtCategoryName.getText().trim())) cek = true;
            }
            if (!cek) {
                myCategory.add(txtCategoryName.getText().trim());
                choiceBox.setItems(FXCollections.observableArrayList(myCategory));
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Duplicate Category Name!");
                a.show();
            }
        }


    }

    @FXML
    private void pilihTabel(MouseEvent mouseEvent) {
        try {
            update.setDisable(false);
            Item i = tableItem.getSelectionModel().getSelectedItem();
            index = tableItem.getSelectionModel().getSelectedIndex();
            choiceBox.setValue(i.getCategory().getNama());
            txtNama.setText(i.getNama());
            txtPrice.setText(i.getPrice());
        } catch (Exception e) {
        }


    }
}
