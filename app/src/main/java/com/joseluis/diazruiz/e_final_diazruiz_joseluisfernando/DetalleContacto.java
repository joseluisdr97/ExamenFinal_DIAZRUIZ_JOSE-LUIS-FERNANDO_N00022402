package com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Models.Contacto;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class DetalleContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        //OBTENER EL POKEMON POR SU ID
        int id = getIntent().getIntExtra("id",1);
        String nombre=getIntent().getStringExtra("name");
        String email=getIntent().getStringExtra("email");
        String phone=getIntent().getStringExtra("phone");
        //String imagen=getIntent().getStringExtra("imagen");


                ImageView imagenn = findViewById(R.id.ivContactoDetalle);
                TextView nombres = findViewById(R.id.tvNombreContactoDetalle);
                TextView emails = findViewById(R.id.tvEmailContactoDetalle);
                TextView numero = findViewById(R.id.tvNumeroContactoDetalle2);

                //Picasso.get().load(imagen).into(imagenn);
                nombres.setText(nombre);
                emails.setText( email);
                numero.setText(phone);

        Button btnVerDirecciones = findViewById(R.id.btnMostrarDirecciones);
        Button btnCrearDirecciones = findViewById(R.id.btnCrearDireccion);

        btnVerDirecciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ENVIAR A LAS CAPTURAS
                Intent intent=new Intent(getApplicationContext(),Direcciones.class);
                intent.putExtra("id",id);
                intent.putExtra("name",nombre);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                //intent.putExtra("imagen",imagen);
                startActivity(intent);
            }
        });

        btnCrearDirecciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ENVIAR A LAS CAPTURAS
                Intent intent=new Intent(getApplicationContext(),CrearDireccion.class);
                intent.putExtra("id",id);
                intent.putExtra("name",nombre);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                //intent.putExtra("imagen",imagen);
                startActivity(intent);
            }
        });
    }
}