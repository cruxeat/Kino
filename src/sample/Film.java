package sample;

import java.io.Serializable;

public class Film implements Serializable {
    protected String name;
    protected String descript;
    protected Double dur;
    protected Double limitAge;

    public String getName(){
        return name;}
    public void setName(String name){
        this.name = name;}

    public String getDescript(){
        return descript;}
    public void setDescript(String descprit){
        this.descript = descript;}

    public Double getDur(){
        return dur;}
    public void setDur(Double dur){
        this.dur = dur;}

    public Double getLimitAge(){
        return limitAge;}
    public void setLimitAge(Double limitAge){
        this.limitAge = limitAge;}


}
