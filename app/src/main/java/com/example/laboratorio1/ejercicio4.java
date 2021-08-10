package com.example.laboratorio1;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ejercicio4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ejercicio4 extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int d,m,a;
    View view;
    Button enviar;
    EditText dia,mes,anio;
    TextView resultados;


    public ejercicio4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ejercicio4.
     */
    // TODO: Rename and change types and number of parameters
    public static ejercicio4 newInstance(String param1, String param2) {
        ejercicio4 fragment = new ejercicio4();
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
        view =inflater.inflate(R.layout.fragment_ejercicio4, container, false);

        enviar = (Button) view.findViewById(R.id.eje4btn);
        dia = (EditText) view.findViewById(R.id.eje4dia);
        mes = (EditText) view.findViewById(R.id.eje4mes);
        anio = (EditText) view.findViewById(R.id.eje4anio);
        resultados = (TextView) view.findViewById(R.id.eje4res);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dia.getText().toString().isEmpty()){
                    Toast.makeText(getContext(),"Campo dia Vacio",Toast.LENGTH_LONG).show();
                    return;
                }
                if (mes.getText().toString().isEmpty()){
                    Toast.makeText(getContext(),"Campo mes vacio",Toast.LENGTH_LONG).show();
                    return;
                }
                if (anio.getText().toString().isEmpty()){
                    Toast.makeText(getContext(),"Campo año Vacio",Toast.LENGTH_LONG).show();
                    return;
                }

                int flag=0;
                try {
                    flag=1;
                    d=Integer.parseInt(dia.getText().toString());
                    flag=2;
                    m=Integer.parseInt(mes.getText().toString());
                    flag=3;
                    a=Integer.parseInt(anio.getText().toString());
                }catch (Exception e){
                    switch (flag){
                        case 1:
                            Toast.makeText(getContext(),"Error dato dia",Toast.LENGTH_LONG).show();
                            return;
                        case 2:
                            Toast.makeText(getContext(),"Error dato mes",Toast.LENGTH_LONG).show();
                            return;
                        case 3:
                            Toast.makeText(getContext(),"Error dato anio",Toast.LENGTH_LONG).show();
                            return;
                    }
                }
                if (d>31 || d==0){
                    Toast.makeText(getContext(),"No existen dias mayores a 31 o iguales a 0",Toast.LENGTH_LONG).show();
                    return;
                }
                if (m>12 || m==0){
                    Toast.makeText(getContext(),"No existen mese mayores a 12 o iguales a 0",Toast.LENGTH_LONG).show();
                    return;
                }
                if (a==0){
                    Toast.makeText(getContext(),"No existen años iguales a 0",Toast.LENGTH_LONG).show();
                    return;
                }

                Calendar c = Calendar.getInstance();
                int day = c.get(Calendar.DATE);
                int month = c.get(Calendar.MONTH)+1;
                int year = c.get(Calendar.YEAR);
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int min = c.get(Calendar.MINUTE);
                int sec = c.get(Calendar.SECOND);

                int mes_num=0;
                if ((month-m)>0){
                    mes_num=month-m;
                }else {
                    mes_num=m-month;
                }
                int dia_num=0;
                if (day-d>0){
                    dia_num=day-d;
                }else {
                    dia_num=d-day;
                }
                resultados.setText("Edad: "+(year-a)+"\n"+
                        "Meses: "+mes_num+"\n"+
                        "Dias: "+dia_num+"\n"+
                        "Horas: "+hour+"\n"+
                        "Minutos: "+min+"\n"+
                        "Segundos: "+sec+"\n"
                );
            }
        });


        return  view;
    }



}