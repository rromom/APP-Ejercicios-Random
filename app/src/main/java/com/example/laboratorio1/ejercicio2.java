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
 * Use the {@link ejercicio2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ejercicio2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText A,B,C;
    TextView resultados;
    Button enviar;
    View view;

    public ejercicio2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ejercicio2.
     */
    // TODO: Rename and change types and number of parameters
    public static ejercicio2 newInstance(String param1, String param2) {
        ejercicio2 fragment = new ejercicio2();
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
        view= inflater.inflate(R.layout.fragment_ejercicio2, container, false);
        enviar = (Button) view.findViewById(R.id.eje2btn);
        A = (EditText) view.findViewById(R.id.eje2A);
        B = (EditText) view.findViewById(R.id.eje2B);
        C = (EditText) view.findViewById(R.id.eje2C);
        resultados = (TextView) view.findViewById(R.id.eje2res);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A.getText().toString().isEmpty() || B.getText().toString().isEmpty() || C.getText().toString().isEmpty()){
                    Toast.makeText(getContext(),"Valor de A,B,C vacios",Toast.LENGTH_LONG).show();
                    return;
                }
                double numa,numb,numc;
                try {
                    numa=Double.parseDouble(A.getText().toString());
                }catch (Exception e){
                    Toast.makeText(getContext(),"ERROR del Dato A",Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    numb=Double.parseDouble(B.getText().toString());
                }catch (Exception e){
                    Toast.makeText(getContext(),"ERROR del Dato B",Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    numc=Double.parseDouble(C.getText().toString());
                }catch (Exception e){
                    Toast.makeText(getContext(),"ERROR del Dato C",Toast.LENGTH_LONG).show();
                    return;
                }
                Mensaje(numa,numb,numc);
            }
        });
        return  view;
    }


    private void Mensaje(double a,double b,double c){

        if (a==0){
            resultados.setText("No tiene solucion Division para 0");
            return;
        }

        double raiz = (b*b)-(4*a*c);
        if (raiz < 0){
            resultados.setText("No tiene solucion existen numeros imaginarios");
            return;
        }
        raiz=Math.sqrt(raiz);
        double resp1=(-b+raiz)/(2*a);
        double resp2=(-b-raiz)/(2*a);

        resultados.setText("Respuesta 1:\n"+resp1+"\nRespuesta 2:\n"+resp2);
    }
}