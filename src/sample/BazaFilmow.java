package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.event.ActionEvent;

public class BazaFilmow implements HierarchicalController<MainController> {

    public TextField name;
    public TextField descript;
    public TextField dur;
    public TextField limitAge;

    public Button add;
    public Button delete;

    public TableView<Film> tablica;
    private MainController parentController;
    @Override
    public MainController getParentController() {
        return parentController;
    }

    @Override
    public void setParentController(MainController parent) {
        this.parentController = parentController;
        tablica.setItems(parentController.getDataContainer().getFilmy());
    }

    public void usunZmiany() {
        tablica.getItems().clear();
        tablica.getItems().addAll(parentController.getDataContainer().getFilmy());
    }

    public void initialize() {
        for (TableColumn<Film, ?> filmTableColumn : tablica.getColumns()) {
            if ("name".equals(filmTableColumn.getId())) {
                TableColumn<Film, String> nameColumn = (TableColumn<Film, String>) filmTableColumn;
                nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            } else if ("descript".equals(filmTableColumn.getId())) {
                TableColumn<Film, String> descriptColumn = (TableColumn<Film, String>) filmTableColumn;
                descriptColumn.setCellValueFactory(new PropertyValueFactory<>("descript"));

            } else if ("dur".equals(filmTableColumn.getId())) {
                TableColumn<Film, Double> durColumn = (TableColumn<Film, Double>) filmTableColumn;
                durColumn.setCellValueFactory(new PropertyValueFactory<>("dur"));
            } else if ("limitAge".equals(filmTableColumn.getId())) {
                TableColumn<Film, Double> limitAgeColumn = (TableColumn<Film, Double>) filmTableColumn;
                limitAgeColumn.setCellValueFactory(new PropertyValueFactory<>("limitAge"));
            }
        }

    }

    public void synchronizuj(javafx.event.ActionEvent actionEvent) {
        parentController.getDataContainer().setFilmy(tablica.getItems());
    }


    public void usun(ActionEvent actionEvent) {
    }

    public void dodaj(ActionEvent actionEvent) {
    }
}
