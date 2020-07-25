package com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Models;

import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.text.Editable;

public class Direccion {

    public String address;
    public double latitude;
    public double longitude;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Direccion() {
    }

    public Direccion(String address, double latitude, double longitude) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
