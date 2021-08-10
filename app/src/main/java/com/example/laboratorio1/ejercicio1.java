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
 * Use the {@link ejercicio1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ejercicio1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View rootview;
    Button enviar;
    EditText txtnota;
    TextView resultado;

    public ejercicio1() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ejercicio1.
     */
    // TODO: Rename and change types and number of parameters
    public static ejercicio1 newInstance(String param1, String param2) {
        ejercicio1 fragment = new ejercicio1();
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
        rootview = inflater.inflate(R.layout.fragment_ejercicio1, container, false);
        enviar = (Button) rootview.findViewById(R.id.eje1btn);
        txtnota = (EditText) rootview.findViewById(R.id.eje1nota);
        resultado = (TextView) rootview.findViewById(R.id.eje1resul);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nota=txtnota.getText().toString();
                if (nota.isEmpty())
                {
                    Toast.makeText(getContext(),"El campo nota esta vacio",Toast.LENGTH_LONG).show();
                    return;
                }
                double nota_num;
                try {
                    nota_num= Double.parseDouble(nota);
                }catch (Exception e)
                {
                    Toast.makeText(getContext(),"Dato mal ingresado",Toast.LENGTH_LONG).show();
                    return;
                }

                if (nota_num<0){
                    Toast.makeText(getContext(),"ingreso de datos negativos", Toast.LENGTH_LONG).show();
                    return;
                }
                if (nota_num>20){
                    Toast.makeText(getContext(),"Ingreso de datos mayor a 20",Toast.LENGTH_LONG).show();
                    return;
                }

                if (nota_num>=0 & nota_num<=10.5) {
                    resultado.setText("ES UNA MALA NOTA =(");
                    return;
                }

                if (nota_num>10.5 & nota_num<= 14){
                    resultado.setText("ES UNA NOTA REGULAR =|");
                    //Toast.makeText(this,"ES UNA NOTA REGULAR =|",Toast.LENGTH_LONG).show();
                    return;
                }
                if (nota_num>14 & nota_num<=18){
                    resultado.setText("ES UNA NOTA BUENA =)");
//            Toast.makeText(this,"ES UNA NOTA BUENA =)",Toast.LENGTH_LONG).show();
                    return;
                }

                resultado.setText("ES UNA NOTA EXCELENTE =D");
//        Toast.makeText(this,"ES UNA NOTA EXCELENTE =D",Toast.LENGTH_LONG).show();
                return;
            }
        });
        return  rootview;
    }

}