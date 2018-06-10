package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

import java.io.*;
import java.util.ArrayList;



public class BazaSeansow implements HierarchicalController<MainController> {

    public TextField nameFilm;
    public TextField numberSala;
    public TextField godzina;
    public TextField data;

    public Button add;
    public Button delete;
    public Button zapiszZmiany;
    public Button wczytaj;
    public Button synchronizuj;


    public TableView<Seans> tablica;
    private MainController parentController;

    @Override
    public MainController getParentController() {
        return parentController;
    }

    @Override
    public void setParentController(MainController parentController) {
        this.parentController = parentController;
        tablica.setEditable(true);
        tablica.setItems(parentController.getDataContainer().getSeanse());
    }

    public void usunZmiany() {
        tablica.getItems().clear();
        tablica.getItems().addAll(parentController.getDataContainer().getSeanse());
    }

    public void initialize() {
        for (TableColumn<Seans, ?> seansTableColumn : tablica.getColumns()) {
            if ("nameFilm".equals(seansTableColumn.getId())) {
                TableColumn<Seans, String> filmColumn = (TableColumn<Seans, String>) seansTableColumn;
                filmColumn.setCellValueFactory(new PropertyValueFactory<>("nameFilm"));
                filmColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                filmColumn.setOnEditCommit((val) -> {
                    val.getTableView().getItems().get(val.getTablePosition().getRow()).setNameFilm(val.getNewValue());
                });

            } else if ("numberSala".equals(seansTableColumn.getId())) {
                TableColumn<Seans, String> salaColumn = (TableColumn<Seans, String>) seansTableColumn;
                salaColumn.setCellValueFactory(new PropertyValueFactory<>("numberSala"));

                //ObservableList<String> optionSal = parentController.getDataContainer().wezNumberSale(parentController.getDataContainer().getSale());

                ObservableList<String> optionSal = parentController.getDataContainer().getNumberSale();


                salaColumn.setCellValueFactory(ComboBoxTableCell.forTableColumn(optionSal));




                salaColumn.setOnEditCommit((val) -> {
                    val.getTableView().getItems().get(val.getTablePosition().getRow()).setNameFilm(val.getNewValue());
                });



            }
            else if ("godzina".equals(seansTableColumn.getId())) {
                TableColumn<Seans, String> godzinaColumn = (TableColumn<Seans, String>) seansTableColumn;
                godzinaColumn.setCellValueFactory(new PropertyValueFactory<>("godzina"));
                godzinaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                godzinaColumn.setOnEditCommit((val) -> {
                    val.getTableView().getItems().get(val.getTablePosition().getRow()).setGodzina(val.getNewValue());
                });


            }

            else if ("data".equals(seansTableColumn.getId())) {
                TableColumn<Seans, String> dataColumn = (TableColumn<Seans, String>) seansTableColumn;
                dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
                dataColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                dataColumn.setOnEditCommit((val) -> {
                    val.getTableView().getItems().get(val.getTablePosition().getRow()).setData(val.getNewValue());
                });

            }
        }

    }

    public void synchronizuj(javafx.event.ActionEvent actionEvent) {
        parentController.getDataContainer().setSeanse(tablica.getItems());
    }


    public void usun(ActionEvent actionEvent) {
        tablica.getItems().remove(tablica.getSelectionModel().getSelectedItem());
    }

    public void dodaj(ActionEvent actionEvent) {
        Seans seans = new Seans();
        seans.setNameFilm(nameFilm.getText());
        seans.setNumberSala(numberSala.getText());
        seans.setGodzina(godzina.getText());
        seans.setData(data.getText());

        tablica.getItems().add(seans);
    }


    public void zapisz(ActionEvent actionEvent) {
        ArrayList<Seans> seansList = new ArrayList<>(tablica.getItems());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dataSS.obj"))) {
            oos.writeObject(seansList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void wczytaj(ActionEvent actionEvent) {
        ArrayList<Seans> seansList;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dataSS.obj"))) {
            seansList = (ArrayList<Seans>) ois.readObject();
            tablica.getItems().clear();
            tablica.getItems().addAll(seansList);
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

