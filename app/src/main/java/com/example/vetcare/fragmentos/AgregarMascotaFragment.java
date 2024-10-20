package com.example.vetcare.fragmentos;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.vetcare.R;
import com.example.vetcare.clases.Menu;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgregarMascotaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgregarMascotaFragment extends Fragment {
    EditText edtNombre, edtEdadAnios, edtEdadMeses, edtRaza;
    Spinner spinnerTipoMascota;
    Button btnAgregarMascota, btnSubirImagen;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AgregarMascotaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AgregarMascotaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AgregarMascotaFragment newInstance(String param1, String param2) {
        AgregarMascotaFragment fragment = new AgregarMascotaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_agregar_mascota, container, false);

        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_agregar_mascota, container, false);
        edtNombre = vista.findViewById(R.id.agremasEdtNombreMascota);
        edtEdadAnios = vista.findViewById(R.id.agrmasEdtEdadAnios);
        edtEdadMeses = vista.findViewById(R.id.agrmasEdtEdadMeses);
        spinnerTipoMascota = vista.findViewById(R.id.agremascSpinnerTipoMascota);
        edtRaza = vista.findViewById(R.id.agremasEdtRazaMascota);
        btnSubirImagen = vista.findViewById(R.id.agremascBtnSubirImagen);
        btnAgregarMascota = vista.findViewById(R.id.agremascBtnAgregarMascota);

        btnAgregarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = getActivity();
                ((Menu) activity).onClickMenu(4);
            }
        });

        // Llenar los spinners
        llenarTipoMascota();
        return vista;
    }

    private void llenarTipoMascota() {
        String[] tipos = {"--Seleccione el tipo de mascota--", "Perro", "Gato", "Otro"};
        spinnerTipoMascota.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, tipos));

    }
}