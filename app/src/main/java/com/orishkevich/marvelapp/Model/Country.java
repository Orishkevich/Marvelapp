package com.orishkevich.marvelapp.Model;

/**
 * Created by Инженер-конструктор on 03.05.2017.
 */

public class Country {

    private String name;
    private boolean map;
    private boolean dowload;
    public boolean getDowload() {
        return dowload;
    }

    public void setDowload(boolean dowload) {
        this.dowload = dowload;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public Country(String name,boolean map,boolean dowload) {
        this.name = name;
        this.map = map;
        this.dowload = dowload;
    }


    public boolean getMap() {
        return map;
    }

    public void setMap(boolean map) {
        this.map = map;
    }


}
