package org.codecta.entity;


public class Series {

    /*http://api.tvmaze.com/singlesearch/shows?q=game%20of%20thrones*/

    private String name;
    private Long id;
    private String language;


    public Series(Long id, String name, String language){
        this.name = name;
        this.id = id;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }



}
