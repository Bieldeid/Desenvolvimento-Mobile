package mobile.fatec.agendadecontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText InputNome;
    EditText InputEmail;
    EditText InputTelefone;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputNome = (EditText) findViewById(R.id.InputNome);
        InputEmail = (EditText) findViewById(R.id.InputEmail);
        InputTelefone = (EditText) findViewById(R.id.InputTelefone);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastraAgenda();
            }
        });

    }

    public void cadastraAgenda(){
        Log.d("MainActivity", "Gravando dados...");
        Log.d("MainAcitivy", "Nome: " + InputNome.getText().toString());
        Log.d("MainAcitivy", "Email: " + InputEmail.getText().toString());
        Log.d("MainAcitivy", "Telefone: " + InputTelefone.getText().toString());
    }

}