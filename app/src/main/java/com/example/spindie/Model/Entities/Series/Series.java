package com.example.spindie.Model.Entities.Series;

import java.util.ArrayList;

public class Series {
    private String year;
    private String imgUrl;
    private ArrayList<String> seasonURLs;
    private int season;
    private String id;
    public String director;
    public String actors;

    private String titleEN;
    private String descriptionEN;

    private String titleES;
    private String descriptionES;

    Series(){
        year="";
        imgUrl="";
        id="";
        director="";
        actors="";
        titleEN="";
        descriptionEN="";
        titleES="";
        descriptionES="";
    }

    public String getId() {
        return id;
    }

    public String getActors() {
        return actors;
    }

    public String getTitleES() {
        return titleES;
    }

    public String getTitleEN() {
        return titleEN;
    }

    public String getDescriptionES() {
        return descriptionES;
    }

    public String getDirector() {
        return director;
    }

    public String getDescriptionEN() {
        return descriptionEN;
    }

    public int getSeason(){return season;}

    public String getImgUrl() {
        return imgUrl;
    }

    public String getYear() {
        return year;
    }

    public ArrayList<String> getSeasonUrls() {
        return seasonURLs;
    }

    public String getEpisodeByNumber(int i){return seasonURLs.get(i);}

    //-------------------------------------------------------------

    public void setId(String id) {
        this.id = id;
    }

    public void setTitleEN(String titleEN) {
        this.titleEN = titleEN;
    }

    public void setTitleES(String titleES) {
        this.titleES = titleES;
    }

    public void setActorsEN(String actorsEN) {
        this.actors = actors;
    }

    public void setDescriptionEN(String descriptionEN) {
        this.descriptionEN = descriptionEN;
    }

    public void setDescriptionES(String descriptionES) {
        this.descriptionES = descriptionES;
    }

    public void setDirectorEN(String directorEN) {
        this.director = director;
    }

    public void setYear(String productionDate) {
        this.year = productionDate;
    }

    public void setSeason(int season){this.season = season;}

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setVideoUrls(ArrayList<String> urls) {
        this.seasonURLs = urls;
    }
}