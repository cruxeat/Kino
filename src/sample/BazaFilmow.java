package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.awt.event.ActionEvent;

public class BazaFilmow implements HierarchicalController<MainController> {

    public TextField name;
    public TextField descript;
    public TextField dur;
    public TextField limitAge;

    public Button add;
    public Button delete;

    public TableView<Film> tablica;
    private MainController parentController;


    public void dodaj(ActionEvent actionEvent) {
        Film film = new Film();
        film.setName(name.getText());
        film.setDescript(descript.getText());
        film.setDur(dur.getText().isEmpty() ? null : Double.parseDouble(dur.getText()));
        film.setLimitAge((limitAge.getText().isEmpty() ? null : Double.parseDouble(limitAge.getText())));
        tablica.getItems().add(film);
    }


    @Override
    public MainController getParentController() {
        return parentController;
    }

    @Override
    public void setParentController(MainController parent) {
        this.parentController = parentController;
        tablica.setItems(parentController.getDataContrainer().getFilmy());
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
}
