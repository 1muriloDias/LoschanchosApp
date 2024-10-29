package com.example.loschanchosapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class roupa_t4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_roupa_t4);

        ImageView btn_voltar = findViewById(R.id.arrowback);
        ImageView btn_ONG1 = findViewById(R.id.imagealimento);
        ImageView btn_ONG2 = findViewById(R.id.imagegoodtruck);
        ImageView btn_ONG3 = findViewById(R.id.imagecaosemfome);

        //burro do front colocou uns ids de fdp


        //cidadao pro mundo
        btn_ONG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifique se 'tela2' é realmente o nome da sua classe atual

                Intent intent = new Intent(roupa_t4.this, cidadaoProMundo.class);
                startActivity(intent);
            }
        });


        //instituto cinco elementos, eu espero...
        btn_ONG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifique se 'tela2' é realmente o nome da sua classe atual

                Intent intent = new Intent(roupa_t4.this, cincoElementos.class);
                startActivity(intent);
            }
        });

        //vagalume

        btn_ONG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifique se 'tela2' é realmente o nome da sua classe atual

                Intent intent = new Intent(roupa_t4.this, vagalume.class);
                startActivity(intent);
            }
        });



        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifique se 'tela2' é realmente o nome da sua classe atual

                Intent intent = new Intent(roupa_t4.this, MainActivity3.class);
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