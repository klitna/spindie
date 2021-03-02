package com.example.spindie.fragments;

import androidx.fragment.app.Fragment;

public class Song extends Fragment{
    private String tittle;
    private String artist;
    private String album;

    public Song(String tittle, String artist, String album) {
        this.tittle = tittle;
        this.artist = artist;
        this.album = album;
    }

    public Song(int contentLayoutId, String tittle, String artist, String album) {
        super(contentLayoutId);
        this.tittle = tittle;
        this.artist = artist;
        this.album = album;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
