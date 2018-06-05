package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BazaSal implements HierarchicalController<MainController> {

    public TextField number;
    public TextField size;
    public TextField type;

    public Button add;
    public Button delete;

    public TableView<Sala> tablica;
    private MainController parentController;


    public void dodaj(ActionEvent actionEvent) {
        Sala sala = new Sala();
        sala.setNumber(number.getText());
        sala.setSize(size.getText().isEmpty() ? null : Double.parseDouble(size.getText()));
        sala.setType(type.getText());
        tablica.getItems().add(sala);
    }


    @Override
    public MainController getParentController() {
        return parentController;
    }

    @Override
    public void setParentController(MainController parent) {
        this.parentController = parentController;
        tablica.setItems(parentController.getDataContainerSale().getSale());
    }


    public void initialize() {
        for (TableColumn<Sala, ?> salaTableColumn : tablica.getColumns()) {
            if ("number".equals(salaTableColumn.getId())) {
                TableColumn<Sala, String> numberColumn = (TableColumn<Sala, String>) salaTableColumn;
                numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

            } else if ("size".equals(salaTableColumn.getId())) {
                TableColumn<Sala, Double> sizeColumn = (TableColumn<Sala, Double>) salaTableColumn;
                sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));


            } else if ("type".equals(salaTableColumn.getId())) {
                TableColumn<Sala, String> typeColumn = (TableColumn<Sala, String>) salaTableColumn;
                typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

            }
        }

    }

    public void synchronizuj(javafx.event.ActionEvent actionEvent) {
        parentController.getDataContainerSale().setSale(tablica.getItems());
    }

    public void usun(ActionEvent actionEvent) {
    }
}
