package com.devops.translatorapp.ui.bienvenida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.devops.translatorapp.R;
import com.devops.translatorapp.ui.autenticacion.AutenticacionActivity;
import com.devops.translatorapp.ui.registrar.RegistrarActivity;

public class BienvenidaActivity extends AppCompatActivity {

    Button boton_iniciar;
    Button boton_crear_cuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        boton_iniciar = findViewById(R.id.boton_iniciar);
        boton_crear_cuenta = findViewById(R.id.boton_crear_cuenta);

        boton_iniciar.setOnClickListener(v->{
            Intent intent = new Intent(BienvenidaActivity.this, AutenticacionActivity.class);
            startActivity(intent);
        });

        boton_crear_cuenta.setOnClickListener(v -> {
            Intent intent = new Intent(BienvenidaActivity.this, RegistrarActivity.class);
            startActivity(intent);
        });
    }
}