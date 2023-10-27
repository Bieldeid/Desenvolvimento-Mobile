package com.example.listadecompras;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ProdutoActivity extends AppCompatActivity {
    private static final String URL = "https://lista-de-mercado-71a38-default-rtdb.firebaseio.com/lista.json";
    public static final MediaType JSON = MediaType.get("application/json");
    public  static final String APP_LISTA = "APP Lista";

    private List<Produto> produtos = new ArrayList<>();
    private EditText txtNome;
    private EditText txtTipo;
    private EditText txtQuantidade;
    private EditText txtPreco;

    private Button btnGravar;
    private Button btnPesquisar;

    private Gson gson = new Gson();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.compras_layout);

        txtNome = findViewById(R.id.txtNome);
        txtTipo = findViewById(R.id.txtTipo);
        txtQuantidade = findViewById(R.id.txtQuantidade);
        txtPreco = findViewById(R.id.txtPreco);

        btnGravar = findViewById(R.id.btnGravar);
        btnPesquisar = findViewById(R.id.btnPesquisar);

        btnGravar.setOnClickListener( e -> gravar() );
        carregarFirebase();
    }

    public void carregarFirebase( Produto l ) {
        String jsonLista = gson.toJson(l);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(jsonLista, JSON);
            Request request = new Request.Builder()
                    .url(URL)
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                Log.e(APP_LISTA, "Resposta: " + response.body().string());
            } catch (IOException e) {
                Log.e(APP_LISTA, "Erro: ", e);
                throw new RuntimeException(e);
            }
            handler.post(() -> {

            });
        });
    }

    private void gravar(){

    }

    private void carregarFirebase(){
        
    }

}
