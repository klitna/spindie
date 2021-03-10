package com.example.spindie.Model.Entities.Music;

import androidx.fragment.app.Fragment;

public class Song extends Fragment{
    private String album;
    private String artist;
    private int min;
    private int seg;
    private String src;
    private String title;

    public Song(String title, String artist, String album, String src, int min, int seg) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.src = src;
        this.min = min;
        this.seg = seg;
    }

    public Song(int contentLayoutId, String tittle, String artist, String album) {
        super(contentLayoutId);
        this.title = tittle;
        this.artist = artist;
        this.album = album;
    }

    public String getTittle() {
        return title;
    }
    public void setTittle(String tittle) {
        this.title = tittle;
    }
    public String getArtist() {
        return artist;
    }
    public String getSrc(){
        return src;
    }
    public int getMin()
    {
        return min;
    }
    public int getSeg(){
        return seg;
    }
    public String getAlbum() {
        return album;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public void setSrc(String src){
        this.src = src;
    }
    public void setMin(int min) {
        this.min = min;
    }
    public void setSeg(int seg) {
        this.seg = seg;
    }
    public void setTtitle(String title){
        this.title=title;
    }
}
