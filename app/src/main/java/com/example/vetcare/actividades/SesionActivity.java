package com.example.vetcare.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vetcare.R;

public class SesionActivity extends AppCompatActivity  implements View.OnClickListener {
    EditText txtCorreo, txtClave;
    Button btnIngresar, btnRegistrarse, btnSOS;
    CheckBox chkRecordar;
    TextView logTxtOlvidasteContrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sesion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar vistas
        txtCorreo = findViewById(R.id.logTxtCorreo);
        txtClave = findViewById(R.id.logTxtClave);
        btnIngresar = findViewById(R.id.logBtnIngresar);
        btnRegistrarse = findViewById(R.id.logBtnRegistrate); // Nuevo botón Registrarse
        btnSOS = findViewById(R.id.logBtnSOS); // Botón SOS
        chkRecordar = findViewById(R.id.logChkRecordar);
        logTxtOlvidasteContrasena = findViewById(R.id.logTxtOlvidasteContrasena);

        // Configurar listeners para los botones y el TextView
        btnIngresar.setOnClickListener(this);
        btnRegistrarse.setOnClickListener(this); // Listener para el botón Registrarse
        btnSOS.setOnClickListener(this); // Listener para el botón SOS
        logTxtOlvidasteContrasena.setOnClickListener(this); // Listener para el olvido de contraseña
    }

    @Override
    public void onClick(View v) {
// Usando if-else if para manejar los clics
        if (v.getId() == R.id.logBtnIngresar) {
            iniciarSesion(txtCorreo.getText().toString(), txtClave.getText().toString(), chkRecordar.isChecked());
        }
        else if (v.getId() == R.id.logBtnRegistrate) {
            registrar(); // Método para manejar el botón Registrarse

        } else if (v.getId() == R.id.logTxtOlvidasteContrasena) {
            olvidasteContrasena(); // Método para manejar el olvido de contraseña
        }
        //else if (v.getId() == R.id.logBtnSOS) {
//            mostrarSOS(); // Método para manejar el botón SOS
    }

    private void iniciarSesion(String correo, String clave, boolean recordar) {
        // Validar credenciales en base de datos o lógica específica
        if (correo.equals("dinamita@gmail.com") && clave.equals("123")) {
            //Intent bienvenida = new Intent(this, ReservaCitaActivity.class);
            Intent bienvenida = new Intent(this, BienvenidaActivity.class);
            bienvenida.putExtra("nombre", "Dinamita");
            startActivity(bienvenida);
            finish();
        } else {
            Toast.makeText(this, "Error: Credenciales incorrectas", Toast.LENGTH_LONG).show();
        }
    }

        private void registrar() {
        Intent registro = new Intent(this, RegistroActivity.class);
        startActivity(registro);
    }
//
//    private void mostrarSOS() {
//        // Mostrar mensaje de emergencia o realizar alguna acción de emergencia
//        Toast.makeText(this, "¡Emergencia SOS activada!", Toast.LENGTH_LONG).show();
//    }
//
    private void olvidasteContrasena() {
        Intent olvidasteContrasena = new Intent(this, OlvidasteContrasenaActivity.class);
        startActivity(olvidasteContrasena);
    }
}