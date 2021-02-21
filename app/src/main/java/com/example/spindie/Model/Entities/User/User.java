package com.example.spindie.Model.Entities.User;

import com.example.spindie.Model.Entities.Film.*;
import com.example.spindie.Model.Entities.OST.OST;
import com.example.spindie.Model.Entities.Serie.*;

import java.util.ArrayList;

public class User {
    private String email;
    private String name;
    private String id;
    private String nick;
    boolean isAuthor;
    ArrayList<Film> filmFav;
    ArrayList<Serie> seriesFav;
    ArrayList<OST> OSTs;

    public User(){
        isAuthor=false;
    }
    public User(String name, String email, String id){
        this.name = name;
        this.email = email;
        this.id = id;
        int index = email.indexOf('@');
        nick = email.substring(0,index).replaceAll("[._]","");
    }
    public String getUserEmail(){return email;}
    public String getUserName(){return name;}
    public String getUserId(){return id;}
    public String getUserNick(){return nick;}

    public void setUserEmail(String email){this.email=email;}
    public void setUserName(String name){this.name=name;}
    public void getUserId(String id){this.id = id;}
}
