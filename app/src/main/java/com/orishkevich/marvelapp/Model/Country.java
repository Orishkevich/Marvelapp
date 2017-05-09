package com.orishkevich.marvelapp.Model;

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
        return "http://download.osmand.net/download.php?standard=yes&file=" + getName() + "_" + getContinent() + "_2.obf.zip";
    }
}
