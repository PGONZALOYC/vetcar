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

public class OlvidasteContrasenaActivity extends AppCompatActivity implements View.OnClickListener {
    EditText olvTxtOlvidasteContrasenaCorreo;
    Button olvBtnOlvidasteContrasenaEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_olvidaste_contrasena);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        olvTxtOlvidasteContrasenaCorreo = findViewById(R.id.olvTxtOlvidasteContrasenaCorreo);
        olvBtnOlvidasteContrasenaEnviar = findViewById(R.id.olvBtnOlvidasteContrasenaEnviar);

        olvBtnOlvidasteContrasenaEnviar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.olvBtnOlvidasteContrasenaEnviar) {
            enviarCorreo(); // Método para manejar el botón Enviar
        }
    }

    private void enviarCorreo() {
        Intent intent = new Intent(this, ConfirmarCodigoActivity.class);
        startActivity(intent);
    }
}