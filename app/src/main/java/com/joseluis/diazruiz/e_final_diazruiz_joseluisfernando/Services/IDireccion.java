package com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Services;

import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Models.Contacto;
import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Models.Direccion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IDireccion {
    @GET("n00022402/contacts")
    Call<List<Direccion>> getAll();

    @POST("address")
    Call<Direccion> create(@Body Direccion direccion);
}
