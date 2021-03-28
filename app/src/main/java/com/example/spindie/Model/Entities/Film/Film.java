package com.example.spindie.Model.Entities.Film;

public class Film {
    private String year;
    private String imgUrl;
    private String videoUrl;
    private String id;
    public String director;
    public String actors;

    private String titleEN;
    private String descriptionEN;

    private String titleES;
    private String descriptionES;

    Film(){
        year="";
        imgUrl="";
        videoUrl="";
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

    public String getImgUrl() {
        return imgUrl;
    }

    public String getYear() {
        return year;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

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

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setDescriptionEN(String descriptionEN) {
        this.descriptionEN = descriptionEN;
    }

    public void setDescriptionES(String descriptionES) {
        this.descriptionES = descriptionES;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setYear(String productionDate) {
        this.year = productionDate;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}