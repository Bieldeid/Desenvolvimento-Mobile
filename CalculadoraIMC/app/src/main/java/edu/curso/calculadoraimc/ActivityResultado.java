package edu.curso.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityResultado extends  AppCompatActivity{
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado_imc);
        Button btn= findViewById(R.id.btnVoltar);

        Bundle bund = getIntent().getExtras();
        float peso = bund.getFloat("Peso");
        float altura = bund.getFloat("Altura");

        btn.setOnClickListener(
                e -> {
                    Intent voltarActivityCalculo = new Intent(
                        this, ActivityCalculo.class
                    );
                    startActivity(voltarActivityCalculo);
                }
        );

    }
}
