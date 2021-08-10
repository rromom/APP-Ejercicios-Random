package com.example.laboratorio1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ejercicio3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ejercicio3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button enviar;
    EditText anio;
    TextView resultados;
    View view;

    public ejercicio3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ejercicio3.
     */
    // TODO: Rename and change types and number of parameters
    public static ejercicio3 newInstance(String param1, String param2) {
        ejercicio3 fragment = new ejercicio3();
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
        view= inflater.inflate(R.layout.fragment_ejercicio3, container, false);
        enviar = (Button) view.findViewById(R.id.eje3btn);
        resultados = (TextView) view.findViewById(R.id.eje3res);
        anio = (EditText) view.findViewById(R.id.eje3anio);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (anio.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Campo año vacio",Toast.LENGTH_LONG).show();
                    return;
                }
                int anio_num;
                try {
                    anio_num = Integer.parseInt(anio.getText().toString());
                }catch (Exception e){
                    Toast.makeText(getContext(), "dato año mal ingresado",Toast.LENGTH_LONG).show();
                    return;
                }
                if ((anio_num % 4 == 0) && ((anio_num % 100 != 0) || (anio_num % 400 == 0))){
                    resultados.setText("El año es Bisiesto");
                }else {
                    resultados.setText("El año no es Bisiesto");
                }
            }
        });
        return view;
    }
}