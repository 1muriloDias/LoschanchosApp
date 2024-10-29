package com.example.loschanchosapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class goodTruck extends AppCompatActivity {

    private TextInputEditText inputNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tucca);

        // Inicializa o TextInputEditText
        inputNome = findViewById(R.id.inputDoacaoBanco);  // Certifique-se de que o ID está correto

        Button btn_endpage = findViewById(R.id.buttonavancartelafinal);
        ImageView btn_voltar = findViewById(R.id.arrowback);

        btn_endpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verificação de preenchimento
                String nome = inputNome.getText().toString().trim();
                if (TextUtils.isEmpty(nome)) {
                    // Exibir mensagem de erro se o campo estiver vazio
                    Toast.makeText(goodTruck.this, "Por favor, insira sua doação.", Toast.LENGTH_SHORT).show();
                } else {
                    // Se o campo estiver preenchido, avançar para a próxima tela
                    Intent intent = new Intent(goodTruck.this, endpage.class);
                    startActivity(intent);
                }
            }
        });

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Voltar para a tela de saúde
                Intent intent = new Intent(goodTruck.this, saude.class);
                startActivity(intent);
            }
        });

        // Ajuste de padding para evitar sobreposição com as barras de sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
