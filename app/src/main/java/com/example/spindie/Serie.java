package com.example.spindie;

public class Serie {
    private String seasonNumber, episodeName;
    private boolean expanded;

    public Serie(String seasonNumber, String episodeName) {
        this.seasonNumber = seasonNumber;
        this.episodeName = episodeName;
        this.expanded=false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(String seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }
}
