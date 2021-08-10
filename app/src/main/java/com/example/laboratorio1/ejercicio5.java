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
 * Use the {@link ejercicio5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ejercicio5 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;
    Button enviar;
    EditText n1,n2,n3;
    int num1,num2,num3;
    TextView resultados;

    public ejercicio5() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ejercicio5.
     */
    // TODO: Rename and change types and number of parameters
    public static ejercicio5 newInstance(String param1, String param2) {
        ejercicio5 fragment = new ejercicio5();
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
        view = inflater.inflate(R.layout.fragment_ejercicio5, container, false);
        enviar = (Button) view.findViewById(R.id.eje5btn);
        n1 = (EditText) view.findViewById(R.id.eje5in1);
        n2 = (EditText) view.findViewById(R.id.eje5in2);
        n3 = (EditText) view.findViewById(R.id.eje5in3);
        resultados = (TextView) view.findViewById(R.id.eje5res);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(),"FUNCA",Toast.LENGTH_LONG).show();
                if (n1.getText().toString().isEmpty()){
                    Toast.makeText(getContext(),"Campo numero 1 vacio",Toast.LENGTH_LONG).show();
                    return;
                }
                if (n2.getText().toString().isEmpty()){
                    Toast.makeText(getContext(),"Campo numero 2 vacio",Toast.LENGTH_LONG).show();
                    return;
                }
                if (n3.getText().toString().isEmpty()){
                    Toast.makeText(getContext(),"Campo numero 3 vacio",Toast.LENGTH_LONG).show();
                    return;
                }

                num1 = Integer.parseInt(n1.getText().toString());
                num2 = Integer.parseInt(n2.getText().toString());
                num3 = Integer.parseInt(n3.getText().toString());

                long mcm = mcm(num1,num2,num3);
                resultados.setText("MCM="+String.valueOf(mcm));
            }
        });

        return view;
    }
    public static long mcm(int n1, int n2, int n3) {
        long aux1 = n1;
        long aux2 = n2;
        long aux3 = n3;
        while(!(aux1 == aux2 && aux2 == aux3)) {
            if(aux1 < aux2 || aux1 < aux3)
                aux1+=n1;
            else if(aux2 < aux1 || aux2 < aux3)
                aux2+=n2;
            else if(aux3 < aux1 || aux3 < aux2)
                aux3+=n3;
        }
        return aux1;
    }
}
