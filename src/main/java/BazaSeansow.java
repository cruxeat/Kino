import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

import java.io.*;
import java.util.ArrayList;


public class BazaSeansow implements HierarchicalController<MainController> {

    public ComboBox film;
    public ComboBox sala;




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
//        tablica.setItems(parentController.getDataContainer().getSeanse());
    }

    public void initialize() throws FileNotFoundException, ClassNotFoundException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dataF.obj"));
            ArrayList<Film> filmyList = (ArrayList<Film>) ois.readObject();
            ObservableList<Film> ofilmyList = FXCollections.observableArrayList(filmyList);

            film.setItems(ofilmyList);

            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("dataS.obj"));
            ArrayList<Sala> saleList = (ArrayList<Sala>) ois2.readObject();
            ObservableList<Sala> osaleList = FXCollections.observableArrayList(saleList);

            sala.setItems(osaleList);



        } catch (IOException e) {
            e.printStackTrace();
        }




    }

}

