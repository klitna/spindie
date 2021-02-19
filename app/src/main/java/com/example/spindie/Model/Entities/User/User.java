package com.example.spindie.Model.Entities.User;

import com.example.spindie.Model.Entities.Film.*;
import com.example.spindie.Model.Entities.OST.OST;
import com.example.spindie.Model.Entities.Serie.*;

import java.util.ArrayList;

public class User {
    private String email;
    private String name;
    boolean isAuthor;
    ArrayList<Film> filmFav;
    ArrayList<Serie> seriesFav;
    ArrayList<OST> OSTs;

    User(){
        isAuthor=false;
    }
    public String getUserEmail(){return email;}
    public String getUserName(){return name;}
    public void setUserEmail(String email){this.email=email;}
    public void setUserName(String name){this.name=name;}
}
