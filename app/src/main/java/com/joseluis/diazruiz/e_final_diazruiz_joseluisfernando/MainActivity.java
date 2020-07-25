package com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //OBTENER LAYOUTS DE BOTONES
        Button btnCrearContacto=findViewById(R.id.btnNuevoContacto);
        Button btnListarContactos=findViewById(R.id.btnListarContactos);

        btnCrearContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CrearContacto.class);
                startActivity(intent);
            }
        });
        btnListarContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Contactos.class);
                startActivity(intent);
            }
        });
    }
}