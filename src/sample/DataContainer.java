package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataContainer {


    protected ObservableList<Film> filmy;
    protected ObservableList<Sala> sale;
    protected ObservableList<Seans> seanse;
    protected ObservableList<String> numberSale;
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

    public ObservableList<String> getNumberSale(){
        return numberSale;
    }


    public ObservableList<Sala> getSale() {
        return sale;
    }

    public ObservableList<Film> getFilmy() {
        return filmy;
    }

    public ObservableList<Seans> getSeanse(){ return seanse;}

    public void setSale (ObservableList<Sala> sale) {
        this.sale = sale;
    }
    public void setFilmy (ObservableList<Film> filmy) {
        this.filmy = filmy;
    }
    public void setSeanse (ObservableList<Seans> seanse) { this.seanse = seanse; }
    public void setNumberSale(ObservableList<String> numberSale) {
        this.numberSale = numberSale;
    }

}