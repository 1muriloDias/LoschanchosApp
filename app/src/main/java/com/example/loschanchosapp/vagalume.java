package com.example.loschanchosapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class vagalume extends AppCompatActivity {

    private TextInputEditText inputNome;
    private Long usuarioId = 1L; // Substitua pelo ID real do usuário logado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vagalume);

        // Inicializa os elementos de layout
        inputNome = findViewById(R.id.inputDoacaoBanco);
        Button btn_endpage = findViewById(R.id.buttonavancartelafinal);
        ImageView btn_voltar = findViewById(R.id.arrowback);

        btn_endpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obter a descrição da doação
                String descricaoDoacao = inputNome.getText().toString().trim();
                if (TextUtils.isEmpty(descricaoDoacao)) {
                    Toast.makeText(vagalume.this, "Por favor, insira sua doação.", Toast.LENGTH_SHORT).show();
                } else {
                    // Criar a instância da API
                    DoacaoApi doacaoApi = ApiClient.getClient().create(DoacaoApi.class);

                    // Configurar a doação com a descrição
                    Doacao doacao = new Doacao();
                    doacao.setDescricao(descricaoDoacao);

                    // Enviar a doação para o backend
                    Call<Doacao> call = doacaoApi.criarDoacao(usuarioId, doacao);
                    call.enqueue(new Callback<Doacao>() {
                        @Override
                        public void onResponse(Call<Doacao> call, Response<Doacao> response) {
                            if (response.isSuccessful()) {
                                Doacao novaDoacao = response.body();
                                Log.d("API", "Doação criada: " + novaDoacao.getDescricao());
                                // Avançar para a próxima tela após o sucesso
                                Intent intent = new Intent(vagalume.this, endpage.class);
                                startActivity(intent);
                            } else {
                                Log.e("API", "Erro ao criar doação: " + response.code());
                            }
                        }

                        @Override
                        public void onFailure(Call<Doacao> call, Throwable t) {
                            Log.e("API", "Erro de comunicação: " + t.getMessage());
                        }
                    });
                }
            }
        });

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Voltar para a tela roupa_t4
                Intent intent = new Intent(vagalume.this, roupa_t4.class);
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
