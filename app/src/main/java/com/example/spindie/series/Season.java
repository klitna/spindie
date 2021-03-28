package com.example.spindie.series;

import java.util.ArrayList;

public class Season {
    ArrayList<Episode> episodes;
    String name;
    int episodeNumber;
    private boolean expanded;

    public Season() {
    }
    public Season(String name, int episodes){
        this.name = name;
        this.episodeNumber = episodes;
    }

    public Season(String name, ArrayList<Episode> episodes){
        this.episodes = episodes;
        this.name = name;
    }

    public Season(String name) {
        this.name = name;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

}
