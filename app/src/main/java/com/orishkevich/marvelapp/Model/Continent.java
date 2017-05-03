package com.orishkevich.marvelapp.Model;

/**
 * Created by Инженер-конструктор on 03.05.2017.
 */

public class Continent {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Continent(String name) {
        Name = name;
    }

    private String Name;

}
