package sample;

import java.io.Serializable;

public class Film implements Serializable {
    protected String name;
    protected String description;
    protected Double dur;
    protected Double limitAge;
    protected Double grade;

    public String getName(){
        return name;}
    public void setName(String name){
        this.name = name;}

    public String getDescription(){
        return description;}
    public void setDescription(String description){
        this.description = description;}

    public Double getDur(){
        return dur;}
    public void setDur(Double dur){
        this.dur = dur;}

    public Double getLimitAge(){
        return limitAge;}
    public void setLimitAge(Double limitAge){
        this.limitAge = limitAge;
    }

}


