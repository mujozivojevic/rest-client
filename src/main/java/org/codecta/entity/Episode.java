package org.codecta.entity;

public class Episode {
    private String name;
    private String season;
    private String number;

    public Episode(String name, String season, String number){
        this.name = name;
        this.season = season;
        this.number = number;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
