import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class BazaSeansow implements HierarchicalController<MainController> {


    public ComboBox film;
    public ComboBox sala;

    public Button dodaj;
    public Button zaktualizuj;

    //public TextField name;
    //public TextField description;

    public TableView<Seans> tablica;
    private MainController parentController;

    public BazaSeansow() throws IOException, ClassNotFoundException {
    }

    @Override
    public MainController getParentController() {
        return parentController;
    }

    @Override
    public void setParentController(MainController parentController) {
        this.parentController = parentController;
//        tablica.setEditable(true);
        tablica.setItems(parentController.getDataContainer().getSeanse());
    }



    public void dodaj(ActionEvent actionEvent) {
        Seans seans = new Seans();
        seans.setNameFilm((Film) film.getValue());
        seans.setNumberSala((Sala) sala.getValue());
        tablica.getItems().add(seans);
    }

    public void synchronizuj(ActionEvent actionEvent) {
        parentController.getDataContainer().setSeanse(tablica.getItems());
    }

    public void initialize() {
        for (TableColumn<Seans, ?> seansTableColumn : tablica.getColumns()) {
            if ("nameFilm".equals(seansTableColumn.getId())) {
                TableColumn<Seans, Film> nameColumn = (TableColumn<Seans, Film>) seansTableColumn;
                nameColumn.setCellValueFactory(new PropertyValueFactory<>("nameFilm"));
                //nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());


            } else if ("numberSala".equals(seansTableColumn.getId())) {
                TableColumn<Seans, Sala> descriptionColumn = (TableColumn<Seans, Sala>) seansTableColumn;
                descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("numberSala"));
                //descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());

            }
        }

    }

    public void zaktualizuj(ActionEvent actionEvent) throws FileNotFoundException, ClassNotFoundException {
        try {
            film.setPromptText("Wybierz film");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dataF.obj"));
            ArrayList<Film> filmyList = (ArrayList<Film>) ois.readObject();
            ObservableList<Film> ofilmyList = FXCollections.observableArrayList(filmyList);

            film.setItems(ofilmyList);

            sala.setPromptText("Wybierz salę");

            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("dataS.obj"));
            ArrayList<Sala> saleList = (ArrayList<Sala>) ois2.readObject();
            ObservableList<Sala> osaleList = FXCollections.observableArrayList(saleList);

            sala.setItems(osaleList);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    private void wez() {
//        Seans seans = new Seans();
//        seans.setNameFilm((Film) film.getValue());
//        //seans.setNumberSala((String) sala.getValue());
//        //seans.setNameFilm(film.getValue());
//        tablica.getItems().add(seans);
//        film.getValue();
//    }
}

