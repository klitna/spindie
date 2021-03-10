package com.example.spindie.series;

import java.util.ArrayList;

public class Season {
    ArrayList<Episode> episodes;
    String name;
    private boolean expanded;

    public Season() {
    }

    public Season(String name) {
        this.name = name;
    }

    public Season(ArrayList<Episode> episodes, String name) {
        this.episodes = episodes;
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
