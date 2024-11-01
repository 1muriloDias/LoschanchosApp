package com.example.loschanchosapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        ImageView btn_voltar = findViewById(R.id.arrowback);
        ImageView btn_roupa = findViewById(R.id.imgAddRoupa);
        ImageView btn_alimento = findViewById(R.id.imgAddAlimento);
        ImageView btn_saude = findViewById(R.id.imgAddSaude);
        Button btn_fechar = findViewById(R.id.buttonT3);

        //volta para a tela inicial
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifique se 'tela2' é realmente o nome da sua classe atual

                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //botao para fechar esse negocin do krlh ai

        btn_fechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        // botao para roupas

        btn_roupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifique se 'tela2' é realmente o nome da sua classe atual

                Intent intent = new Intent(MainActivity3.this, roupa_t4.class);
                startActivity(intent);
            }
        });

        // botao para alimentos

        btn_alimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifique se 'tela2' é realmente o nome da sua classe atual

                Intent intent = new Intent(MainActivity3.this, alimento.class);
                startActivity(intent);
            }
        });

        //botao para saude

        // Corrigido o erro de capitalização para View.OnClickListener

        btn_saude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifique se 'tela2' é realmente o nome da sua classe atual

                Intent intent = new Intent(MainActivity3.this, saude.class);
                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}