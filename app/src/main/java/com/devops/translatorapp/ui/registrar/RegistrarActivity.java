package com.devops.translatorapp.ui.registrar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.devops.translatorapp.MainActivity;
import com.devops.translatorapp.R;
import com.devops.translatorapp.ui.autenticacion.AutenticacionActivity;

public class RegistrarActivity extends AppCompatActivity {

    Button boton_registrarse;
    EditText texto_usuario;
    EditText texto_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        boton_registrarse = findViewById(R.id.boton_registrarse);
        texto_usuario = findViewById(R.id.texto_usuario);
        texto_password = findViewById(R.id.texto_password);

        boton_registrarse.setOnClickListener(v -> {
            boolean value = isFormEmpty();

            try {
                if (value) {
                    Intent intent = new Intent(RegistrarActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            } catch (Exception error) {
                toastAlert("Ocurrió un error.\n Contactar a soporte técnico");
            }
        });

    }

    private boolean isFormEmpty() {
        if (texto_usuario.getText().toString().isEmpty() || texto_password.getText().toString().isEmpty()) {
            toastAlert("Debe completar los campos vacíos");
        } else {
            return true;
        }

        return false;
    }

    private void toastAlert(String message) {
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.toast_alert, findViewById(R.id.toast_alert));
        TextView texto_alerta = view.findViewById(R.id.texto_alerta);
        texto_alerta.setText(message);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 150);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        toast.show();
    }
}