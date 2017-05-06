package com.orishkevich.marvelapp.Model;

/**
 * Created by Инженер-конструктор on 03.05.2017.
 */

public class Country {

    private String name;
    private boolean map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public Country(String name,boolean map) {
        this.name = name;
        this.map = map;
    }


    public boolean getMap() {
        return map;
    }

    public void setMap(boolean map) {
        this.map = map;
    }


}
