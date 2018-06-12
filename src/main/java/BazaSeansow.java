import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

import java.io.*;
import java.util.ArrayList;


public class BazaSeansow implements HierarchicalController<MainController> {

    public ComboBox<String> film = new ComboBox<>(
            FXCollections.observableArrayList(
                    "koty", "psy"
            )
    );
//    public TextField sala;
//    public TextField godzina;
//    public TextField data;

//    public Button add;
//    public Button delete;
//    public Button zapisz;
//    public Button wczytaj;
//    public Button synchronizuj;

//    public TableView<Seans> tablica;
    private MainController parentController;

    @Override
    public MainController getParentController() {
        return parentController;
    }

    @Override
    public void setParentController(MainController parentController) {
        this.parentController = parentController;
//        tablica.setEditable(true);
//        tablica.setItems(parentController.getDataContainer().getSeanse());
    }

    public void initialize() {

    }

}

