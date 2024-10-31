package com.example.loschanchosapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import com.example.loschanchosapp.UsuarioApi;
import com.example.loschanchosapp.Usuario;
import com.example.loschanchosapp.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.os.Bundle;
import android.util.Log;


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


        ///////////////
        //botões de input e avancar de tela

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


    //cadastrar usuario a partir do input
    private void cadastrarUsuarioNaApi(String nome) {
        // Inicializando a API
        UsuarioApi usuarioApi = ApiClient.getClient().create(UsuarioApi.class);

        // Criando um novo usuário com o nome fornecido
        Usuario usuario = new Usuario();
        usuario.setNome(nome);

        // Chamando o endpoint para cadastrar o usuário
        Call<Usuario> call = usuarioApi.cadastrarUsuario(usuario);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()) {
                    Usuario novoUsuario = response.body();
                    Log.d("API", "Usuário cadastrado: " + novoUsuario.getNome());
                    // Avançar para a próxima tela após cadastro bem-sucedido
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                } else {
                    Log.e("API", "Erro ao cadastrar usuário: " + response.code());
                    Toast.makeText(MainActivity.this, "Erro ao cadastrar usuário.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("API", "Erro de comunicação: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Erro de comunicação com a API.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

