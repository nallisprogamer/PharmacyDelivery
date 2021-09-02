package com.example.diskremedio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class contapessoa extends AppCompatActivity {
    ImageView imgvoltar_Adicionar_Pessoa_Main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contapessoa);
        imgvoltar_Adicionar_Pessoa_Main = findViewById(R.id.imgvoltar_Adicionar_Pessoa_Main);
        imgvoltar_Adicionar_Pessoa_Main.setOnClickListener(v -> {
            startActivity(new Intent(contapessoa.this,MainActivity.class));
        });
    }
}