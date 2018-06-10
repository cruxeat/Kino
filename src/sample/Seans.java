package sample;

import java.io.Serializable;

public class Seans implements Serializable {
    protected String nameFilm;
    protected String numberSala;
    protected String data;
    protected String godzina;
    protected Sala sala;


    public String getnameFilm(){
        return nameFilm;}


    public void setNameFilm(String nameFilm){
        this.nameFilm = nameFilm;}

    public String getNumberSala(){
        return numberSala;}

    public void setNumberSala(String numberSala){
        this.numberSala = sala.getNumber();}

    public String getData(){
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getGodzina(){
        return godzina;
    }

    public void setGodzina(String godzina) {
        this.godzina = godzina;
    }
}

