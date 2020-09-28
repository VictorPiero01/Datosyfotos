package com.desarrollo.fotoydatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class datos extends AppCompatActivity {

    TextView tvnombre,tvapellido,tvdni,tvedad,tvdireccion;
    ImageView foto;
    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);


        Intent receptor = getIntent();

        String  nombre = getIntent().getStringExtra("datonombre");
        String  apellido = getIntent().getStringExtra("datoapellido");
        String  dni = getIntent().getStringExtra("datodni");
        String  edad = getIntent().getStringExtra("datoedad");
        String  direccion = getIntent().getStringExtra("datodireccion");

        Bitmap bitmap =(Bitmap) receptor.getParcelableExtra("imagen");
        ImageView icono =(ImageView)findViewById(R.id.iv_resultadofinal);
        icono.setImageBitmap(bitmap);



        tvnombre = findViewById(R.id.tv_nombrefinal);
        tvnombre.setText(nombre);

        tvapellido = findViewById(R.id.tv_apellidofinal);
        tvapellido.setText(apellido);

        tvdni = findViewById(R.id.tv_dnifinal);
        tvdni.setText(dni);

        tvedad = findViewById(R.id.tv_edadfinal);
        tvedad.setText(edad);

        tvdireccion = findViewById(R.id.tv_direccionfinal);
        tvdireccion.setText(direccion);


        /*-------*/

        /*-------*/

        Button btn_volver = (Button)findViewById(R.id.btn_volver);

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });

    }



}