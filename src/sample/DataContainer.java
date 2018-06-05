package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataContainer {
    protected ObservableList<Film> filmy;

    public DataContainer() {
        filmy = FXCollections.observableArrayList();
    }

    public ObservableList<Film> getFilmy() {
        return filmy;
    }

    public void setFilmy(ObservableList<Film> filmy) {
        this.filmy = filmy;
    }

}
