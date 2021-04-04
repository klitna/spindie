package com.example.spindie.series;

import androidx.annotation.NonNull;

public class Episode {
    private String name;
    private String description;

    public Episode() {
    }

    public Episode(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
