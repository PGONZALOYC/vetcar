package com.example.vetcare.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vetcare.R;

public class RegistroPrimeraMascotaActivity extends AppCompatActivity implements View.OnClickListener{
    EditText regTxtRegistroPrimMascotaNombre, regTxtRegistroPrimMascotaAnios, regTxtRegistroPrimMascotaMeses;
    Spinner regCboRegistroPrimMascotaTipo, regCboRegistroPrimMascotaRaza;
    ImageButton mascIconoRegistroPrimMascota,imageButtonSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro_primera_mascota);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        regTxtRegistroPrimMascotaNombre = this.<EditText>findViewById(R.id.regTxtRegistroPrimMascotaNombre);
        regTxtRegistroPrimMascotaAnios = findViewById(R.id.regTxtRegistroPrimMascotaAnios);
        regTxtRegistroPrimMascotaMeses = findViewById(R.id.regTxtRegistroPrimMascotaMeses);
        regCboRegistroPrimMascotaTipo = findViewById(R.id.regCboRegistroPrimMascotaTipo);
        regCboRegistroPrimMascotaRaza = findViewById(R.id.regCboRegistroPrimMascotaRaza);
        mascIconoRegistroPrimMascota = findViewById(R.id.mascIconoRegistroPrimMascota);
        imageButtonSiguiente = findViewById(R.id.imageButtonSiguiente);

        imageButtonSiguiente.setOnClickListener(this);

        llenarTiposMascota();
        llenarRazasMascota();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageButtonSiguiente) {
            // Obtener los valores ingresados
            String nombrePrimeraMascota = regTxtRegistroPrimMascotaNombre.getText().toString().trim();
            String aniosPrimeraMascota = regTxtRegistroPrimMascotaAnios.getText().toString().trim();
            String mesesPrimeraMascota = regTxtRegistroPrimMascotaMeses.getText().toString().trim();
            String tipoMascotaPrimeraMascota = regCboRegistroPrimMascotaTipo.getSelectedItem().toString();
            String razaMascotaPrimeraMascota = regCboRegistroPrimMascotaRaza.getSelectedItem().toString();

            // Verificar que todos los campos estén completos y válidos
            if (nombrePrimeraMascota.isEmpty()) {
                regTxtRegistroPrimMascotaNombre.setError("Por favor, ingrese el nombre.");
            } else if (aniosPrimeraMascota.isEmpty()) {
                regTxtRegistroPrimMascotaAnios.setError("Por favor, ingrese los años.");
            } else if (mesesPrimeraMascota.isEmpty()) {
                regTxtRegistroPrimMascotaMeses.setError("Por favor, ingrese los meses.");
            } else if (regCboRegistroPrimMascotaTipo.getSelectedItemPosition() == 0) {
                // Si no se ha seleccionado un tipo válido
                ((android.widget.TextView) regCboRegistroPrimMascotaTipo.getSelectedView()).setError("Seleccione un tipo de mascota.");
            } else if (regCboRegistroPrimMascotaRaza.getSelectedItemPosition() == 0) {
                // Si no se ha seleccionado una raza válida
                ((android.widget.TextView) regCboRegistroPrimMascotaRaza.getSelectedView()).setError("Seleccione una raza.");
            } else {
                // Si todas las validaciones son correctas, avanzar a la siguiente actividad
                Intent intent = new Intent(RegistroPrimeraMascotaActivity.this, BienvenidaActivity.class);
                startActivity(intent);
            }

            // Si todas las validaciones son correctas, avanzar a la siguiente actividad
//            Intent intent = new Intent(RegistroPrimeraMascotaActivity.this, BienvenidaActivity.class);
//            startActivity(intent);
        }
    }
    private void llenarTiposMascota() {
        String[] tiposMascota = {"--Seleccione Tipo de Mascota", "Perro", "Gato", "Pez", "Hamster"};
        regCboRegistroPrimMascotaTipo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tiposMascota));
    }

    private void llenarRazasMascota() {
        String[] razasMascota = {"--Seleccione Raza", "Bulldog", "Pastor Alemán", "Chihuahua", "Siamés", "Persa", "Común", "Goldfish", "Betta", "Guppy", "Ruso", "Dwarf", "Campbell"};
        regCboRegistroPrimMascotaRaza.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, razasMascota));
    }
}