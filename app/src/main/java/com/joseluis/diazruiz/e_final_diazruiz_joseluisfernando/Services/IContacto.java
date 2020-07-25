package com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Services;

import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Models.Contacto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IContacto {
    @GET("n00022402/contacts")
    Call<List<Contacto>> getAll();

    @POST("n00022402/contacts")
    Call<Contacto> create(@Body Contacto contacto);
}
