import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.DateTimeStringConverter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;





public class BazaSeansow implements HierarchicalController<MainController> {

    public ComboBox film;
    public ComboBox sala;
    public DatePicker dzien;
    public DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    //public Label timeLabel;
    public TextField godzina;
    public Button dodaj;
    public Button zaktualizuj;




    //public TextField godzina;
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
        seans.setData((LocalDate) dzien.getValue());
        seans.setGodzina(godzina.getText());
        tablica.getItems().add(seans);

        film.getItems().remove(film.getValue());

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

            else if ("data".equals(seansTableColumn.getId())) {
                TableColumn<Seans, LocalDate> descriptionColumn = (TableColumn<Seans, LocalDate>) seansTableColumn;
                descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
                //descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());

            }

            else if ("godzina".equals(seansTableColumn.getId())) {
                TableColumn<Seans, String> descriptionColumn = (TableColumn<Seans, String>) seansTableColumn;
                descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("godzina"));
                //descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());

            }
        }

    }

    public void zaktualizuj(ActionEvent actionEvent) throws FileNotFoundException, ClassNotFoundException, ParseException {
        try {
            film.setPromptText("Film: ");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dataF.obj"));
            ArrayList<Film> filmyList = (ArrayList<Film>) ois.readObject();
            ObservableList<Film> ofilmyList = FXCollections.observableArrayList(filmyList);

            film.setItems(ofilmyList);

            sala.setPromptText("Sala: ");

            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("dataS.obj"));
            ArrayList<Sala> saleList = (ArrayList<Sala>) ois2.readObject();
            ObservableList<Sala> osaleList = FXCollections.observableArrayList(saleList);

            sala.setItems(osaleList);
            dzien.setPromptText("Data: ");


            //DateFormat timeFormat = new SimpleDateFormat( "HH:mm:ss" );
            //godzina.setText(timeFormat.format("00:00:00"));
            godzina.setPromptText("Godzina: ");
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            godzina.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00:00")));


            //SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            //tf.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00:00")));


            //godzina = new JTextField("dkdk");
            //TimeValue



        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

