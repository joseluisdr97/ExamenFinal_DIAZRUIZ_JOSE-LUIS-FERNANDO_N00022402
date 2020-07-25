package com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Models.Contacto;
import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Models.Direccion;
import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Services.IContacto;
import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Services.IDireccion;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearDireccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_direccion);

        int id = getIntent().getIntExtra("id",1);
        String nombre=getIntent().getStringExtra("name");
        String email=getIntent().getStringExtra("email");
        String phone=getIntent().getStringExtra("phone");
        String imagen=getIntent().getStringExtra("imagen");

        //BOTON DE GUARDAR
        Button btnGuardarDireccion=findViewById(R.id.btnGuardarDireccion);

        final EditText txtadress = findViewById(R.id.txtaddress);
        final EditText txtlongitus = findViewById(R.id.txtlongitude);
        final EditText txtlatitud=findViewById(R.id.txtlatitude);

        btnGuardarDireccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Direccion direccion = new Direccion();


                direccion.setAddress(txtadress.getText().toString());
                direccion.setLongitude(Double.parseDouble(String.valueOf(txtlongitus.getText())));
                direccion.setLatitude(Double.parseDouble(String.valueOf(txtlatitud.getText())));
                //fruta.me_gusta=true;

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.sky4dev.com/n00022402/contacts/"+id+"/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                IDireccion service = retrofit.create(IDireccion.class);
                service.create(direccion).enqueue(new Callback<Direccion>() {
                    @Override
                    public void onResponse(Call<Direccion> call, Response<Direccion> response) {
                        Log.d("Se envio Correcto","imagen");
                    }

                    @Override
                    public void onFailure(Call<Direccion> call, Throwable t) {
                        Log.d("No Se envio Correcto","imagen");
                    }
                });

                //ENVIAR AL INICIO
                Intent intent=new Intent(getApplicationContext(),DetalleContacto.class);
                intent.putExtra("id",id);
                intent.putExtra("name",nombre);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                intent.putExtra("imagen",imagen);
                startActivity(intent);


            }
        });

    }


}