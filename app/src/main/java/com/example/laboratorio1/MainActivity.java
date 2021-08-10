package com.example.laboratorio1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity{
    FragmentTransaction transaction;
    ejercicio1 eje1;
    ejercicio2 eje2;
    ejercicio3 eje3;
    ejercicio4 eje4;
    ejercicio5 eje5;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eje1 = new ejercicio1();
        spinner  = (Spinner) findViewById(R.id.spinnermain);
        getSupportFragmentManager().beginTransaction().add(R.id.contenido,eje1).commit();
        String [] opciones = {"Estado Estudiante","Raices de una Ecuacion","Año Bisiesto","Mi edad Exacta","MCM"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,opciones);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                transaction = getSupportFragmentManager().beginTransaction();
                switch (position){
                    case 0:
                        eje1= new ejercicio1();
                        transaction.replace(R.id.contenido,eje1);
                        transaction.addToBackStack(null);
                        break;
                    case 1:
                        eje2 = new ejercicio2();
                        transaction.replace(R.id.contenido,eje2);
                        transaction.addToBackStack(null);
                        break;
                    case 2:
                        eje3 = new ejercicio3();
                        transaction.replace(R.id.contenido,eje3);
                        transaction.addToBackStack(null);
                        break;
                    case 3:
                        eje4 = new ejercicio4();
                        transaction.replace(R.id.contenido,eje4);
                        transaction.addToBackStack(null);
                        break;
                    case 4:
                        eje5 = new ejercicio5();
                        transaction.replace(R.id.contenido,eje5);
                        transaction.addToBackStack(null);
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void clik(View v){
        transaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.btneje1:
                eje1= new ejercicio1();
                transaction.replace(R.id.contenido,eje1);
                transaction.addToBackStack(null);
                break;
            case R.id.btneje2:
                eje2 = new ejercicio2();
                transaction.replace(R.id.contenido,eje2);
                transaction.addToBackStack(null);
                break;
            case R.id.btneje3:
                eje3 = new ejercicio3();
                transaction.replace(R.id.contenido,eje3);
                transaction.addToBackStack(null);
                break;
            case R.id.btneje4:
                eje4 = new ejercicio4();
                transaction.replace(R.id.contenido,eje4);
                transaction.addToBackStack(null);
                break;
            case R.id.btneje5:
                eje5 = new ejercicio5();
                transaction.replace(R.id.contenido,eje5);
                transaction.addToBackStack(null);
                break;

        }
        transaction.commit();
    }

}