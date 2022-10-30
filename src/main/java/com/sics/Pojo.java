package com.sics;

import java.io.Serializable;
import java.util.Date;

public class Pojo implements Serializable {
    private int id ;
    private Date date;

    private int functionNum;

    public Pojo(int id, Date date,int functionNum) {
        this.id = id;
        this.date = date;
        this.functionNum = functionNum;
    }

    public void addFunctionNum(){
        functionNum++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getFunctionNum() {
        return functionNum;
    }

    public void setFunctionNum(int functionNum) {
        this.functionNum = functionNum;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "id=" + id +
                ", date='" + date + '\'' +
                '}';
    }
}
