package com.orishkevich.marvelapp.model;

/**
 * Created by Инженер-конструктор on 03.05.2017.
 */

public class Country {
    //http://download.osmand.net/download.php?standard=yes&file=Denmark_europe_2.obf.zip)
    private String name;
    private boolean map;
    private boolean dowload;
    private String continent;

    public String getContinent() {
        return continent;
    }

    public void setCountry(String continent) {
        this.continent = continent;
    }


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

    public Country(String name, boolean map, boolean dowload, String continent) {
        this.name = name;
        this.map = map;
        this.dowload = dowload;
        this.continent = continent;
    }


    public boolean getMap() {
        return map;
    }

    public void setMap(boolean map) {
        this.map = map;
    }

    public String getAdress() {
        //http://download.osmand.net/download.php?standard=yes&file=Denmark_europe_2.obf.zip)
        return "http://download.osmand.net/download.php?standard=yes&file=" + getName() + "_" + firstDownCase(getContinent()) + "_2.obf.zip";
    }

    public String firstDownCase(String word) {
        if (word == null || word.isEmpty()) return "";//или return word;
        return word.substring(0, 1).toLowerCase() + word.substring(1);
    }
}
