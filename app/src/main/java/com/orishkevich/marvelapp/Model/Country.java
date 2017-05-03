package com.orishkevich.marvelapp.Model;

/**
 * Created by Инженер-конструктор on 03.05.2017.
 */

public class Country {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Country(String name) {
        Name = name;
    }

    private String Name;
}
