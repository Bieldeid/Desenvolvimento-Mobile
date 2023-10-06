package com.example.agendacontato;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ContatoActivity  extends AppCompatActivity {

    public static final String APP_AGENDA = "APP Agenda";

    private List<Contato> contatos = new ArrayList<>();
    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtTelefone;

    private Button btnGravar;
    private Button btnPesquisar;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.contato_activity);

        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefone = findViewById(R.id.txtTelefone);

        btnGravar = findViewById(R.id.btnGravar);
        btnPesquisar = findViewById(R.id.btnPesquisar);



    }

    private void salvarPrefs(){
        Log.d(APP_AGENDA, "salvarPrefs acionado");
        SharedPreferences shared = getSharedPreferences("AGENDA", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String strLista = gson.toJson(contatos);
        Log.d(APP_AGENDA, "Contato salvo no SharedPreferences");
        Log.d(APP_AGENDA, strLista);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("LISTA", strLista);
        editor.apply();
    }

    private void carregarPrefs(){
        SharedPreferences shared = getSharedPreferences("AGENDA", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String strLista = shared.getString("LISTA", "[]");
        Log.d(APP_AGENDA, "JSON Lido: " + strLista);
        Type listType = new TypeToken<ArrayList<Contato>>(){}.getType();
        ArrayList<Contato> list = gson.fromJson(strLista, listType);
        if (list != null) {
            contatos.clear();
            contatos.addAll(list);
        }
        Log.d(TAG, "Contatos da lista lida no sharedPreferences");
        if (contatos != null{
            for (Contato c: contatos){
                Log.d(APP_AGENDA, c.toString());
            }
        }
    }

}
