import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;

public class DataContainer {

    @Getter @Setter protected ObservableList<Film> filmy;
    @Getter @Setter protected ObservableList<Sala> sale;
    @Getter @Setter protected ObservableList<Seans> seanse;
    @Getter @Setter protected ObservableList<String> numberSale;
    //protected ObservableList<String> optionSale;

    public DataContainer() {
        sale = FXCollections.observableArrayList();
        filmy = FXCollections.observableArrayList();
        seanse = FXCollections.observableArrayList();
        numberSale = FXCollections.observableArrayList();

        for (Sala sala : sale) {
            numberSale.add(sala.getNumber());
        }

    }


    //optionSale = wezNumber

    //parentController.getDataContainer().wezNumberSale(parentController.getDataContainer().getSale());

    /*
    public ObservableList<String> getNumberSale() {
        return numberSale;
    }
    */

    /*

    public ObservableList<String> wezNumberSale(ObservableList<Sala> sale) {
        for (Sala sala : sale) {
            numberSale.add(sala.getNumber());
        }
        return numberSale;
    } */


    /*public void setNumberSale(ObservableList<String> numberSale) {
        for(Sala sala: sale) {
            numberSale.add(sala.getNumber());
            }
        this.numberSale = numberSale;

        } */


}