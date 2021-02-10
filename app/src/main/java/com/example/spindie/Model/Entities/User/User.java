package com.example.spindie.Model.Entities.User;

import com.example.spindie.Model.Entities.Film.*;
import com.example.spindie.Model.Entities.OST.OST;
import com.example.spindie.Model.Entities.Serie.*;

import java.util.ArrayList;

public class User {
    private String email;
    private String name;
    //private ... photo???
    boolean isAuthor;
    ArrayList<Film> filmFav;
    ArrayList<Serie> seriesFav;
    ArrayList<OST> OSTs;
}
