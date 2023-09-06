package edu.curso.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityCalculo extends  AppCompatActivity{

    EditText InputPeso = findViewById(R.id.InputPeso);
    EditText InputAltura = findViewById(R.id.InputAltura);

    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.calculo_imc);



        Button btn = findViewById(R.id.btnCalculaIMC);

        btn.setOnClickListener(
                e-> {
                    Bundle bundle = new Bundle();

                    bundle.putFloat("Peso",Float.parseFloat(String.valueOf(InputPeso)));
                    bundle.putFloat("Altura",Float.parseFloat(String.valueOf(InputAltura)));

                    validarCampos();

                    Intent abrirActivityResultado = new Intent(
                        this, ActivityResultado.class
                    );

                    startActivity(abrirActivityResultado);
                }
        );



    }

    public void validarCampos(){

        Log.d("ActivityCalculo", "Gravando dados");
        Log.d("ActivityCalculo", "Peso: " + InputPeso.getText().toString());
        Log.d("ActivityCalculo", "Altura: " + InputAltura.getText().toString());
        if (InputPeso.getText() == null && InputAltura.getText() == null){
            Log.d("ActivityCalculo", "Preencher todos os campos!");
        } else {
            Log.d("ActivityCalculo", "Campos Preenchidos");
        }
    }
}
