package com.example.vetcare.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vetcare.R;

public class CambiarContrasenaActivity extends AppCompatActivity implements View.OnClickListener {
    EditText camTxtCambiarContrasenaNueva, camTxtCambiarContrasenaConfirmarNueva;
    Button camBtnCambiarContrasenaAceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cambiar_contrasena);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        camTxtCambiarContrasenaNueva = findViewById(R.id.camTxtCambiarContrasenaNueva);
        camTxtCambiarContrasenaConfirmarNueva = findViewById(R.id.camTxtCambiarContrasenaConfirmarNueva);

        camBtnCambiarContrasenaAceptar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.camBtnCambiarContrasenaAceptar) {
            cambiarContrasena(); // Método para manejar el botón Enviar
        }
    }

    private void cambiarContrasena() {
        Intent intent = new Intent(this, SesionActivity.class);
        startActivity(intent);
    }
}