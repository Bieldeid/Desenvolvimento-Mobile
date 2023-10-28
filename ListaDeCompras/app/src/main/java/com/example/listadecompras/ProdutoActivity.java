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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

        btnPesquisar.setOnClickListener( e -> pesquisar() );

        btnGravar.setOnClickListener( e -> gravar() );
        carregarFirebase();
    }

    public void salvarFirebase(Produto p) {
        String jsonLista = gson.toJson(p);

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

    private Produto paraEntidade(){
        Produto p = new Produto();
        p.setNomeProduto(txtNome.getText().toString());
        p.setTipoProduto(txtTipo.getText().toString());
        p.setQuantidade(Float.parseFloat(txtQuantidade
                .getText().toString()));
        p.setPrecoUnitario(Double.parseDouble(txtPreco
                .getText().toString()));
        return p;
    }

    private void gravar(){
        Produto p = paraEntidade();
        produtos.add(p);
        salvarFirebase(p);
        mostrarLista();
    }

    private void pesquisar(){
        String nome = txtNome.getText().toString();
        Log.d(APP_LISTA, "Pesquisando restaurante: + nome + );
        for (Produto p : produtos) {
            Log.d(APP_LISTA, "Restaurante: (" + p.getNomeProduto() + ") contém " +
                    p.getNomeProduto().contains( nome ) );
            if (p.getNomeProduto().contains(nome)){
                txtNome.setText(p.getNomeProduto());
                txtTipo.setText(p.getTipoProduto());
                txtQuantidade.setText(String.valueOf(p.getQuantidade()) );
                txtPreco.setText(String.valueOf(p.getPrecoUnitario()) );
            }
        }
    }

    private void mostrarLista(){
        for (Produto p: produtos){
            Log.d(APP_LISTA, p.toString());
        }
    }

    private void carregarFirebase() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            produtos.clear();
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(URL)
                    .get()
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String resposta = response.body().string();

                if (resposta != null && !resposta.isEmpty()) {
                    JsonParser parser = new JsonParser();
                    JsonElement element = parser.parse(resposta);

                    if (element != null && !element.isJsonNull() && element.isJsonObject()) {
                        JsonObject convertedObject = element.getAsJsonObject();

                        for (String chave : convertedObject.keySet()) {
                            JsonElement obj = convertedObject.get(chave);

                            if (obj != null && !obj.isJsonNull() && obj.isJsonObject()) {
                                Produto r = gson.fromJson(obj, Produto.class);
                                produtos.add(r);
                            }
                        }
                        Log.e(APP_LISTA, "Resposta: " + resposta);
                    } else {
                        Log.e(APP_LISTA, "Resposta do servidor não é um objeto JSON válido.");
                    }
                } else {
                    Log.e(APP_LISTA, "Resposta do servidor vazia ou nula.");
                }
            } catch (IOException e) {
                Log.e(APP_LISTA, "Erro: ", e);
                throw new RuntimeException(e);
            }
        });
    }


}
