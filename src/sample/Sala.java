package sample;

import java.io.Serializable;

public class Sala implements Serializable {
    protected String number;
    protected Double size;
    protected String type;

    public String getNumber(){
        return number;
    }
    public void setNumber (String number){
        this.number = number;
    }

    public Double getSize(){
        return size;
    }
    public void setSize(Double size){
        this.size = size;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type =  type;
    }


}
