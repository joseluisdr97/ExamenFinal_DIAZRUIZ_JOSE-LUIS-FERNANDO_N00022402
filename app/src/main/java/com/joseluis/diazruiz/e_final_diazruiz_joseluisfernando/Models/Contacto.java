package com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Models;

public class Contacto {
    public int id;
    public String names;
    public String email;
    public String phone;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String image;



    public Contacto() {
    }

    public Contacto(int id, String names, String email, String phone, String image) {
        this.id = id;
        this.names = names;
        this.email = email;
        this.phone = phone;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}
