package com.desarrollo.fotoydatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final int CAMARA_PIC_REQUEST = 1;
    EditText nombre,apellido,dni,edad,direccion;
    ImageView iv_fotofinish;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == CAMARA_PIC_REQUEST){
            if(resultCode == RESULT_OK){
                Bitmap bitmap = (Bitmap)data.getExtras().get("data");
                ImageView iv_foto = (ImageView)findViewById(R.id.iv_resultado);
                iv_foto.setImageBitmap(bitmap);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_guardar = (Button)findViewById(R.id.btn_volver);



        ((Button)findViewById(R.id.btn_captura)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,CAMARA_PIC_REQUEST);
            }
        });

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nombre = (EditText)findViewById(R.id.pt_nombre);
                apellido = (EditText)findViewById(R.id.pt_apellido);
                dni = (EditText)findViewById(R.id.pt_dni);
                edad = (EditText)findViewById(R.id.pt_edad);
                direccion = (EditText)findViewById(R.id.pt_direccion);
                iv_fotofinish = (ImageView)findViewById(R.id.iv_resultado);


                Intent intent = new Intent(getApplicationContext(),datos.class);

                Bitmap bitmap = ((BitmapDrawable)iv_fotofinish.getDrawable()).getBitmap();

                intent.putExtra("datonombre",nombre.getText().toString());
                intent.putExtra("datoapellido",apellido.getText().toString());
                intent.putExtra("datodni",dni.getText().toString());
                intent.putExtra("datoedad",edad.getText().toString());
                intent.putExtra("datodireccion",direccion.getText().toString());
                intent.putExtra("imagen",bitmap);
                intent.setType("/");
                startActivity(intent);

            }
        });
    }


}