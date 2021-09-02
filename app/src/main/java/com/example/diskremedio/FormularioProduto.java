package com.example.diskremedio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.diskremedio.Pattern.MedicineItemPattern;
import com.example.diskremedio.Pattern.SwitchPlus;
import com.example.diskremedio.banco.SqlServer_connection;
import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Locale;

public class FormularioProduto extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView img_medicine_f;
    String numerodeparcelas;
    ImageView imgvoltar_Adicionar_Produto_Main;
    LinearLayout LLhaveDiscount;
    LinearLayout LL_Have_Parcel_Ask;
    boolean ifHasDiscount = false;
    TextInputEditText numberofparcelsEdittext;
    boolean ifHasParcel = false;
    SwitchPlus hasDiscountSwitch;
    SwitchPlus hasparcel;
    TextInputEditText valor_desconto;
    Button salvarProduto;
    TextInputEditText preco_remedioF;
    TextInputEditText usosNindicadosF;
    TextInputEditText nome_produtof;
    TextInputEditText name_modeloF;
    TextInputEditText usosindicadosf;
    TextInputEditText fabricante_remedioF;
    TextInputEditText Quant_per_cxF;
    TextInputEditText quant_remedio_totalF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_produto);


        preco_remedioF = findViewById(R.id.preco_remediof);
        usosNindicadosF = findViewById(R.id.usosNindicadosF);
        nome_produtof = findViewById(R.id.nome_produtof);

        name_modeloF = findViewById(R.id.name_modeloF);
        Quant_per_cxF = findViewById(R.id.Quant_per_cxF);
        usosindicadosf = findViewById(R.id.usosindicadosf);
        quant_remedio_totalF = findViewById(R.id.quant_remedio_totalF);
        LL_Have_Parcel_Ask = findViewById(R.id.LL_Have_Parcel_Ask);
        fabricante_remedioF = findViewById(R.id.fabricante_remedioF);
        imgvoltar_Adicionar_Produto_Main = findViewById(R.id.imgvoltar_Adicionar_Produto_Main);
        preco_remedioF.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            private String current = "";

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    Locale myLocale = new Locale("pt", "BR");
                    //Nesse bloco ele monta a maskara para money
                    preco_remedioF.removeTextChangedListener(this);
                    String cleanString = s.toString().replaceAll("[R$,. ]", "");
                    float parsed = Float.parseFloat(cleanString);
                    String formatted = NumberFormat.getCurrencyInstance(myLocale).format((parsed / 100));
                    current = formatted;
                    preco_remedioF.setText(formatted);
                    preco_remedioF.setSelection(formatted.length());
                    //Nesse bloco ele faz a conta do total (Caso a qtde esteja preenchida)
                    preco_remedioF.addTextChangedListener(this);
                }
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        img_medicine_f = findViewById(R.id.img_medicine_f);
        salvarProduto = findViewById(R.id.salvarProduto);
        LLhaveDiscount = findViewById(R.id.LLhaveDiscount);
        hasparcel = findViewById(R.id.if_have_parcelsf);
        numberofparcelsEdittext = findViewById(R.id.numberParcelsf);
        valor_desconto = findViewById(R.id.valor_venda_com_desconto);
        hasDiscountSwitch = findViewById(R.id.if_Has_Discountf);
        salvarProduto.setOnClickListener(v -> {

                    img_medicine_f.invalidate();
                    BitmapDrawable drawable = (BitmapDrawable) img_medicine_f.getDrawable();
                    Bitmap bitmap = drawable.getBitmap();
                    MedicineItemPattern mip = new MedicineItemPattern(String.valueOf(System.currentTimeMillis()).substring(5), nome_produtof.getText().toString(),
                            name_modeloF.getText().toString(), fabricante_remedioF.getText().toString(), valor_desconto.getText().toString(), preco_remedioF.getText().toString(),
                            quant_remedio_totalF.getText().toString(), Quant_per_cxF.getText().toString(), usosindicadosf.getText().toString(),
                            usosNindicadosF.getText().toString(), BitMapToString(bitmap),"");
            SqlServer_connection.SqlServer_connection(getBaseContext()).addProduto(mip);
                });
        LL_Have_Parcel_Ask = findViewById(R.id.LL_Have_Parcel_Ask);

        imgvoltar_Adicionar_Produto_Main = findViewById(R.id.imgvoltar_Adicionar_Produto_Main);
        imgvoltar_Adicionar_Produto_Main.setOnClickListener(v -> {
            Intent a = new Intent(getBaseContext(), MainActivity.class);
            startActivity(a);
        });
        hasparcel.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ifHasParcel = isChecked;
            if (isChecked) {
                LL_Have_Parcel_Ask.setVisibility(View.VISIBLE);
                numberofparcelsEdittext.setText(numerodeparcelas);
            } else {
                LL_Have_Parcel_Ask.setVisibility(View.GONE);
            }
        });
        hasDiscountSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ifHasDiscount = isChecked;
                if (isChecked) {
                    LLhaveDiscount.setVisibility(View.VISIBLE);

                    valor_desconto.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        private String current = "";

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            if (!s.toString().equals(current)) {
                                Locale myLocale = new Locale("pt", "BR");
                                //Nesse bloco ele monta a maskara para money
                                valor_desconto.removeTextChangedListener(this);
                                String cleanString = s.toString().replaceAll("[R$,. ]", "");
                                float parsed = Float.parseFloat(cleanString);
                                String formatted = NumberFormat.getCurrencyInstance(myLocale).format((parsed / 100));
                                current = formatted;
                                valor_desconto.setText(formatted);
                                valor_desconto.setSelection(formatted.length());
                                //Nesse bloco ele faz a conta do total (Caso a qtde esteja preenchida)
                                valor_desconto.addTextChangedListener(this);
                            }
                        }


                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });
                } else {
                    LLhaveDiscount.setVisibility(View.GONE);
                }
            }
        });

        img_medicine_f.setOnClickListener(v -> {

            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                Intent takePictureIntent = new Intent("android.media.action.IMAGE_CAPTURE");


//                if (getApplicationContext().getpa) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//            }

        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img_medicine_f.setImageBitmap(imageBitmap);
        }
    }

    public String BitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String temp = Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }
}