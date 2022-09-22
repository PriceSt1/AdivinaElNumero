package com.borjas.adivinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static int puntuacionJ1 = 0;
    private static int puntuacionJ2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] numUser = new String[1];

        // Declaramos e instanciamos las variables
        TextView tvExplain = findViewById(R.id.tv_Explain);
        Button btnAdivinar = findViewById(R.id.btn_Adivina);
        Button btnRandom = findViewById(R.id.btn_Random);
        EditText etEntrada = findViewById(R.id.et_Num);
        TextView tvPuntuacionJ1 = findViewById(R.id.tv_puntuacionJ1);
        TextView tvPuntuacionJ2 = findViewById(R.id.tv_puntuacionJ2);
        NumeroSecreto numeroSecreto = new NumeroSecreto();


        //Bloque de codigo el cual Sobreescribo el texto de todos los objetos

        tvExplain.setText("¡Introduce un numero del 0 al 10 e intenta adivinar en que numero pienso! \n" +
                "Pulsa el boton adivinar para adivinar el numero y el circulo de flechas para generar uno nuevo \n ¡SUERTE!");
        btnAdivinar.setText("Adivinar");
        btnRandom.setText(null);
        etEntrada.setText("¡Pulsame!");


        //Creo un metodo que ejecute una accion al clicar el boton adivinar


        btnAdivinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numUser[0] = String.valueOf(etEntrada.getText());
                if (numUser[0].equals(numeroSecreto.numToString())){
                    mostrarToast("¡Enhorabuena es el mismo numero!");
                    puntuacionJ1++;
                    tvPuntuacionJ1.setText(String.valueOf(puntuacionJ1));
                }else {
                    mostrarToast("¡Vuelve a intentarlo o cambia de numero!");
                    puntuacionJ2++;
                    tvPuntuacionJ2.setText(String.valueOf(puntuacionJ2));
                }
            }
        });

        //Creo un metodo que ejecute una accion al clicar el boton Random

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               numeroSecreto.generarNumRand();
            }
        });

        //Creo un metodo el cual vacie de texto el campo para introducir un numero

        etEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEntrada.setText(null);
            }
        });

    }

    //Un metodo que me permita generar un toast comodamente

    private void mostrarToast(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}