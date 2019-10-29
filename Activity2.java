package com.example.trabajopractico1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class Activity2 extends AppCompatActivity {


    public void IngText(View vista)
    {

        int cont = 0;
        TextView texto;
        texto = (TextView)findViewById(R.id.txtact2);
        Toast mimensaje;
        String  mensajeamostrar;

        CheckBox check1;
        check1 = (CheckBox)findViewById(R.id.check);
        int text = texto.getText().length();

        if (text == 0 )
        {
            mensajeamostrar = "No ha ingresado ninguna palabra";
            mimensaje = Toast.makeText(this, mensajeamostrar, Toast.LENGTH_SHORT);
            mimensaje.show();
        }
        else {
            if (check1.isChecked() == true) {
                if (texto.length() < 10) {
                    mensajeamostrar = "Su texto tiene menos de 10 caracteres";
                    mimensaje = Toast.makeText(this, mensajeamostrar, Toast.LENGTH_SHORT);
                    mimensaje.show();

                } else {
                    for (int i = 0; i < texto.getText().length(); i++) {

                        String uncaracter;
                        uncaracter = texto.getText().toString().substring(i, i + 1);

                        if (uncaracter.compareTo("a") == 0) {
                            cont++;
                        }

                    }

                    mensajeamostrar = cont + "" + " son la cantidad de A";
                    mimensaje = Toast.makeText(this, mensajeamostrar, Toast.LENGTH_SHORT);
                    mimensaje.show();

                }
            } else {

                for (int i = 0; i < texto.getText().length(); i++) {

                    String uncaracter;
                    uncaracter = texto.getText().toString().substring(i, i + 1);

                    if (uncaracter.compareTo("a") == 0) {
                        cont++;
                    }

                }

                mensajeamostrar = cont + "" + " son la cantidad de A";
                mimensaje = Toast.makeText(this, mensajeamostrar, Toast.LENGTH_SHORT);
                mimensaje.show();


            }


        }

    }
    public void volver (View view)
    {
        Intent i = new Intent(this,Actividad1.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto2);
    }
}
