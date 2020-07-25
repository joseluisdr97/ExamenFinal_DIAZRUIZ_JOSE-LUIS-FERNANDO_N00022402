package com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Models.Contacto;
import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Services.IContacto;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearContacto extends AppCompatActivity {
    String imagen ;
    private static final int SELECT_FILE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_contacto);


            final EditText txtNombres = findViewById(R.id.txtNames);
            final EditText txtEmail = findViewById(R.id.txtEmail);
            final EditText txtPhone = findViewById(R.id.txtPhone);
            Button CargarPorGaleria = findViewById(R.id.btnCargarImagenGaleria);

            //ABRIR LA GALERIA
            CargarPorGaleria.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(
                            Intent.createChooser(intent, "Seleccione una imagen"),
                            SELECT_FILE);
                }
            });

            //BOTON DE GUARDAR
            Button btnGuardarContacto=findViewById(R.id.btnGuardarContacto);

            btnGuardarContacto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Contacto contacto = new Contacto();
                    //Obtenermos los textos
                    contacto.setNames(txtNombres.getText().toString());
                    contacto.setEmail(txtEmail.getText().toString());
                    contacto.setPhone(txtPhone.getText().toString());
                    contacto.setImage(imagen);
                    //fruta.me_gusta=true;
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://api.sky4dev.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    IContacto service = retrofit.create(IContacto.class);
                    service.create(contacto).enqueue(new Callback<Contacto>() {
                        @Override
                        public void onResponse(Call<Contacto> call, Response<Contacto> response) {
                            Log.d("Se envio Correcto la direccion","");
                        }

                        @Override
                        public void onFailure(Call<Contacto> call, Throwable t) {
                            Log.d("No Se envio Correcto la direccion","");
                        }
                    });

                    //ENVIAR AL INICIO
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

                    Log.d("urlDeImagen",imagen);
                }
            });

        }

        //CONVERTIR IMAGEN A BASE 64
        protected void onActivityResult(int requestCode, int resultCode,
        Intent imageReturnedIntent) {
            super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
            Uri selectedImageUri = null;
            Uri selectedImage;

            String filePath = null;
            switch (requestCode) {
                case SELECT_FILE:
                    if (resultCode == MainActivity.RESULT_OK) {
                        selectedImage = imageReturnedIntent.getData();
                        String selectedPath=selectedImage.getPath();
                        if (requestCode == SELECT_FILE) {

                            if (selectedPath != null) {
                                InputStream imageStream = null;
                                try {
                                    imageStream = getContentResolver().openInputStream(
                                            selectedImage);
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }

                                // Transformamos la URI de la imagen a inputStream y este a un Bitmap
                                Bitmap bmp = BitmapFactory.decodeStream(imageStream);

                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                                byte[] imageBytes = baos.toByteArray();
                                String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);

                                //decode base64 string to image
                                imageBytes = Base64.decode(imageString, Base64.DEFAULT);
                                Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);


                                // Ponemos nuestro bitmap en un ImageView que tengamos en la vista
                                ImageView mImg = (ImageView) findViewById(R.id.ivContactoCrear);
                                mImg.setImageBitmap(bmp);

                                Log.d("cadena",imageString);
                                copiarimagen(imageString);

                            }
                        }
                    }
                    break;
            }
        }

        public void copiarimagen(String imageString){
            imagen = imageString;
        }
    }