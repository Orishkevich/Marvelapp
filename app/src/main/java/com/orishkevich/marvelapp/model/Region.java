package com.orishkevich.marvelapp.model;

/**
 * Created by Инженер-конструктор on 03.05.2017.
 */

public class Region {
    public Region(String name) {
        Name = name;
    }

    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
