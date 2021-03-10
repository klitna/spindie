package com.example.spindie.profile;

public class filmsfavoritas {

    private String titulo;
    private String IMGlink;

    public filmsfavoritas(String titulo, String IMGlink) {
        this.titulo = titulo;
        this.IMGlink= IMGlink;
    }

    public String getTitulo(){
        return titulo;
    }
    public String getImagen(){
        return  IMGlink;
    }
}


