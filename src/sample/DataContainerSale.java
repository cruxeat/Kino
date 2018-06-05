package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataContainerSale {
    protected ObservableList<Sala> sale;

    public DataContainerSale() {
        sale = FXCollections.observableArrayList();
    }

    public ObservableList<Sala> getSale() {
        return sale;
    }

    public void setSale (ObservableList<Sala> sale) {
        this.sale = sale;
    }

}