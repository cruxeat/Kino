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

public class BazaSal implements HierarchicalController<MainController> {

    public TextField number;
    public TextField size;
    public TextField type;

    public Button add;
    public Button delete;

    public TableView<Sala> tablica;
    private MainController parentController;




    @Override
    public MainController getParentController() {
        return parentController;
    }

    @Override
    public void setParentController(MainController parent) {
        this.parentController = parentController;
        tablica.setItems(parentController.getDataContainer().getSale());
    }


    public void initialize() {
        for (TableColumn<Sala, ?> salaTableColumn : tablica.getColumns()) {
            if ("number".equals(salaTableColumn.getId())) {
                TableColumn<Sala, String> numberColumn = (TableColumn<Sala, String>) salaTableColumn;
                numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
                numberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                numberColumn.setOnEditCommit((val) -> {
                    val.getTableView().getItems().get(val.getTablePosition().getRow()).setNumber(val.getNewValue());
                });

            } else if ("size".equals(salaTableColumn.getId())) {
                TableColumn<Sala, Double> sizeColumn = (TableColumn<Sala, Double>) salaTableColumn;
                sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
                sizeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Double>() {
                    @Override
                    public String toString(Double object) {
                        return object == null ? null : object.toString();
                    }

                    @Override
                    public Double fromString(String string) {
                        return (string == null || string.isEmpty()) ? null : Double.parseDouble(string);
                    }
                }));
                sizeColumn.setOnEditCommit((val) -> {
                    val.getTableView().getItems().get(val.getTablePosition().getRow()).setSize(val.getNewValue());
                });



            } else if ("type".equals(salaTableColumn.getId())) {
                TableColumn<Sala, String> typeColumn = (TableColumn<Sala, String>) salaTableColumn;
                typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
                typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                typeColumn.setOnEditCommit((val) -> {
                    val.getTableView().getItems().get(val.getTablePosition().getRow()).setType(val.getNewValue());
                });

            }
        }

    }

    public void synchronizuj(javafx.event.ActionEvent actionEvent) {
        parentController.getDataContainer().setSale(tablica.getItems());
    }

    public void usun(ActionEvent actionEvent) {
        tablica.getItems().remove(tablica.getSelectionModel().getSelectedItem());
    }

    public void dodaj(ActionEvent actionEvent) {
        Sala sala = new Sala();
        sala.setNumber(number.getText());
        sala.setType(type.getText());
        sala.setSize(size.getText().isEmpty() ? null : Double.parseDouble(size.getText()));
        tablica.getItems().add(sala);
    }


    public void zapisz(ActionEvent actionEvent) {
        ArrayList<Sala> salaList = new ArrayList<>(tablica.getItems());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dataS.obj"))) {
            oos.writeObject(salaList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void wczytaj(ActionEvent actionEvent) {
        ArrayList<Sala> salaList;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dataS.obj"))) {
            salaList = (ArrayList<Sala>) ois.readObject();
            tablica.getItems().clear();
            tablica.getItems().addAll(salaList);
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void usunZmiany() {
        tablica.getItems().clear();
        tablica.getItems().addAll(parentController.getDataContainer().getSale());
    }


}
