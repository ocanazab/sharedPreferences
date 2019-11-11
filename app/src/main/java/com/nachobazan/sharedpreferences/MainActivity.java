package com.nachobazan.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText txtCorreo;
    private Button ejecutar;
    private SharedPreferences preferencias;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos controles
        txtCorreo=findViewById(R.id.txtMail);
        ejecutar=findViewById(R.id.btnEjecutar);

        //Mostramos en el campo EditText la dirección de correo recuperada de SharedPreferences
        preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
        txtCorreo.setText(preferencias.getString("mail",""));

        //Creamos el listener que almacenara el contenido del EditText en el fichero de preferencias
        ejecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
                editor=preferencias.edit();
                editor.putString("mail",txtCorreo.getText().toString());
                editor.commit();
                finish();
            }
        });

    }
}
