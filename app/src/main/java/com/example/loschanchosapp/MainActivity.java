package com.example.loschanchosapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText inputNome;
    private Button botaoAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Referenciando os elementos
        inputNome = findViewById(R.id.inputNome);
        botaoAvancar = findViewById(R.id.botaoAvancar);

        // Listener para o botão
        botaoAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verificação de preenchimento
                String nome = inputNome.getText().toString().trim();
                if (TextUtils.isEmpty(nome)) {
                    // Exibir mensagem de erro se o campo estiver vazio
                    Toast.makeText(MainActivity.this, "Por favor, insira seu nome.", Toast.LENGTH_SHORT).show();
                } else {
                    // Se o campo estiver preenchido, avançar para a próxima tela
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
            }
        });

        // Ajuste das margens do sistema para evitar sobreposição
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
