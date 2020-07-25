package com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Adapters.ContactoAdapter;
import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Models.Contacto;
import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Services.IContacto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Contactos extends AppCompatActivity {
    //LLAMAR A TODOS MIS VIEW
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ContactoAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        mRecyclerView=findViewById(R.id.rvContactos);//Nombre de mi recicler
        mRecyclerView.setHasFixedSize(true);//Para decir que los view dentro de mi recicler view van a tener el mismo tamaño

        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //TRAER LOS DATOS DESDE INTERNET
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.sky4dev.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IContacto service=retrofit.create(IContacto.class);
        Call<List<Contacto>> frutas=service.getAll();
        frutas.enqueue(new Callback<List<Contacto>>() {

            @Override//Que hay conexion con el servidor
            public void onResponse(Call<List<Contacto>> call, Response<List<Contacto>> response) {
                List<Contacto> data=response.body();
                Log.i("Loguer_succes", String.valueOf(data.size()));

                //specify an adapter (see also next example)
                mAdapter=new ContactoAdapter(data);//List<String>

                mRecyclerView.setAdapter(mAdapter);
            }

            @Override//Que no hay conexion con el servidor
            public void onFailure(Call<List<Contacto>> call, Throwable t) {

            }
        });
    }
}