package com.example.spindie.Model.Entities.Film;

public class Film {
    private String productionDate;
    private String imgUrl;
    private String videoUrl;
    private String id;

    private String titleEN;
    private String descriptionEN;
    private String directorEN;
    private String actorsEN;

    private String titleES;
    private String descriptionES;
    private String directorES;
    private String actorsES;

    public String getId() {
        return id;
    }

    public String getActorsES() {
        return actorsES;
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

    public String getDirectorES() {
        return directorES;
    }

    public String getDescriptionEN() {
        return descriptionEN;
    }

    public String getDirectorEN() {
        return directorEN;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public String getActorsEN() {
        return actorsEN;
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

    public void setActorsEN(String actorsEN) {
        this.actorsEN = actorsEN;
    }

    public void setActorsES(String actorsES) {
        this.actorsES = actorsES;
    }

    public void setDescriptionEN(String descriptionEN) {
        this.descriptionEN = descriptionEN;
    }

    public void setDescriptionES(String descriptionES) {
        this.descriptionES = descriptionES;
    }

    public void setDirectorEN(String directorEN) {
        this.directorEN = directorEN;
    }

    public void setDirectorES(String directorES) {
        this.directorES = directorES;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
