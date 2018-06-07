package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

import java.io.*;
import java.util.ArrayList;

public class BazaFilmow implements HierarchicalController<MainController> {

    public TextField name;
    public TextField description;
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
        tablica.setEditable(true);
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
                nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                nameColumn.setOnEditCommit((val) -> {
                    val.getTableView().getItems().get(val.getTablePosition().getRow()).setName(val.getNewValue());
                });

            } else if ("description".equals(filmTableColumn.getId())) {
                TableColumn<Film, String> descriptionColumn = (TableColumn<Film, String>) filmTableColumn;
                descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
                descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                descriptionColumn.setOnEditCommit((val) -> {
                    val.getTableView().getItems().get(val.getTablePosition().getRow()).setDescription(val.getNewValue());
                });

            } else if ("dur".equals(filmTableColumn.getId())) {
                TableColumn<Film, Double> durColumn = (TableColumn<Film, Double>) filmTableColumn;
                durColumn.setCellValueFactory(new PropertyValueFactory<>("dur"));
                durColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Double>() {
                    @Override
                    public String toString(Double object) {
                        return object == null ? null : object.toString();
                    }

                    @Override
                    public Double fromString(String string) {
                        return (string == null || string.isEmpty()) ? null : Double.parseDouble(string);
                    }
                }));
                durColumn.setOnEditCommit((val) -> {
                    val.getTableView().getItems().get(val.getTablePosition().getRow()).setDur(val.getNewValue());
                });

            } else if ("limitAge".equals(filmTableColumn.getId())) {
                TableColumn<Film, Double> limitAgeColumn = (TableColumn<Film, Double>) filmTableColumn;
                limitAgeColumn.setCellValueFactory(new PropertyValueFactory<>("limitAge"));
                limitAgeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Double>() {
                    @Override
                    public String toString(Double object) {
                        return object == null ? null : object.toString();
                    }

                    @Override
                    public Double fromString(String string) {
                        return (string == null || string.isEmpty()) ? null : Double.parseDouble(string);
                    }
                }));
                limitAgeColumn.setOnEditCommit((val) -> {
                    val.getTableView().getItems().get(val.getTablePosition().getRow()).setLimitAge(val.getNewValue());
                });
            }
        }

    }

    public void synchronizuj(javafx.event.ActionEvent actionEvent) {
        parentController.getDataContainer().setFilmy(tablica.getItems());
    }


    public void usun(ActionEvent actionEvent) {
        tablica.getItems().remove(tablica.getSelectionModel().getSelectedItem());
    }

    public void dodaj(ActionEvent actionEvent) {
        Film film = new Film();
        film.setName(name.getText());
        film.setDescription(description.getText());
        film.setLimitAge(limitAge.getText().isEmpty() ? null : Double.parseDouble(limitAge.getText()));
        film.setDur(dur.getText().isEmpty() ? null : Double.parseDouble(dur.getText()));
        tablica.getItems().add(film);
    }


    public void zapisz(ActionEvent actionEvent) {
        ArrayList<Film> filmyList = new ArrayList<>(tablica.getItems());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.obj"))) {
            oos.writeObject(filmyList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void wczytaj(ActionEvent actionEvent) {
        ArrayList<Film> filmyList;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.obj"))) {
            filmyList = (ArrayList<Film>) ois.readObject();
            tablica.getItems().clear();
            tablica.getItems().addAll(filmyList);
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
