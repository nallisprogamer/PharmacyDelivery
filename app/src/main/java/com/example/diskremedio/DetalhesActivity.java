package com.example.diskremedio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diskremedio.Pattern.MedicineItemPattern;

public class DetalhesActivity extends AppCompatActivity {
    ImageView detalhes_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        Intent a = getIntent();
        String nome = a.getStringExtra("nome");
        String modelo = a.getStringExtra("modelo");
        String fabricante = a.getStringExtra("fabricante");
        String preco = a.getStringExtra("desconto");
        String preco_original = a.getStringExtra("preco_original");
        String quant_cartela = a.getStringExtra("quant_cartela");
        String quant_per_cx = a.getStringExtra("quant_per_cx");
        String usosindicados = a.getStringExtra("usosindicados");
        String usosNindicados = a.getStringExtra("usosNindicados");
        String quant_produto = a.getStringExtra("quant_produto");
        String imgbitmap = a.getStringExtra("imgbitmap");
        String id = a.getStringExtra("id");
        MedicineItemPattern mip = new MedicineItemPattern(id, nome, modelo, fabricante
                , preco, preco_original, quant_cartela, quant_per_cx, usosindicados, usosNindicados,imgbitmap,quant_produto);

        ImageView ftp = findViewById(R.id.img_medicine_details);

        ftp.setImageBitmap(StringToBitMap(imgbitmap));
        ImageView detalhes_main = findViewById(R.id.detalhes_main);
        detalhes_main.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(),MainActivity.class );
            startActivity(intent);
        });
        TextView nomep = findViewById(R.id.nome_remedio);
        TextView usosindicadosp = findViewById(R.id.usosIndicados);
        TextView usosNindicadosp = findViewById(R.id.usosNindicados);
        TextView quantp = findViewById(R.id.nome_quant_item);
        Button lessp = findViewById(R.id.lessbutton);
        Button morep = findViewById(R.id.morebutton);
        Button addtocartp = findViewById(R.id.addtocart);
        usosindicadosp.setText(mip.getUsosindicados());
        usosNindicadosp.setText(mip.getUsosNindicados());
        nomep.setText(nome);
        addtocartp.setOnClickListener(v -> {
            mip.setQuant_produto(quantp.getText().toString());
        });
        lessp.setOnClickListener(v -> {
            String quant = quantp.getText().toString();
            int quantN = Integer.parseInt(quant);
            if (quantN > 1) {
                int quantidade = quantN - 1;
                quantp.setText("" + quantidade);
            }
        });
        morep.setOnClickListener(v -> {
            String quant = quantp.getText().toString();
            int quantN = Integer.parseInt(quant);
            int quantidade = quantN + 1;
            quantp.setText("" + quantidade);
        });

    }
    public Bitmap StringToBitMap(String encodedString){
        try{
            byte [] encodeByte = Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }
        catch(Exception e){
            e.getMessage();
            return null;
        }
    }
}