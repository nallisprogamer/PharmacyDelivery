package com.example.diskremedio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.diskremedio.Adapter.AdapterCategorias;
import com.example.diskremedio.Adapter.AdapterMediceItem;
import com.example.diskremedio.Adapter.ProdutosAdapter;
import com.example.diskremedio.Pattern.CategoriaMain;
import com.example.diskremedio.Pattern.MedicineItemPattern;
import com.example.diskremedio.Pattern.Person;
import com.example.diskremedio.Pattern.Produtopattern;
import com.example.diskremedio.banco.SqlServer_connection;
import com.example.diskremedio.banco.sqlite;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<MedicineItemPattern> cartList;
    DrawerLayout drawerLayout;
    ImageView imgChamarLS;
    ImageView cart_img_main_img;
    TextView cart_img_quant_main_img;
    LinearLayout your_information_lateralString;
    ArrayList<MedicineItemPattern> lista;
    Person pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        TextView nomepessalS = findViewById(R.id.nome_da_pessoa_lateralString);
        TextView numero_telefone_lateralString = findViewById(R.id.numero_telefone_lateralString);
        LinearLayout parent_addnewproduct = findViewById(R.id.parent_addnewproduct);
        parent_addnewproduct.setOnClickListener(v -> {
            Intent a = new Intent(getBaseContext(), FormularioProduto.class);
            startActivity(a);
        });
        if (nomepessalS.getText().equals("Seu nome")) {
            String nome = getIntent().getStringExtra("nome");
            String numero_telefone = getIntent().getStringExtra("numero_telefone");
            if (nome == null) {
                pessoa = sqlite.getINSTANCE(getBaseContext()).getRegisterAcountPessoa();

                if (pessoa.nome.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogCustom);
                    builder.setTitle(R.string.usefull_information)
                            .setMessage("Para que esse aplicativo funcione corretamente algumas informações são necessárias")
                            .setCancelable(true)
                            .setPositiveButton("Ceder informações", (dialog, which) -> startActivity(new Intent(MainActivity.this, Login.class)));
                    androidx.appcompat.app.AlertDialog alert = builder.create();
                    alert.show();
                    nomepessalS.setText(R.string.your_name);
                    numero_telefone_lateralString.setText(R.string.informe_seu_numero_telefone);
                } else {
                    nomepessalS.setText(pessoa.nome);
                    numero_telefone_lateralString.setText(pessoa.numerotelefone);
                }
            } else {
                nomepessalS.setText(nome);
                numero_telefone_lateralString.setText(numero_telefone);
            }
        }

        your_information_lateralString = findViewById(R.id.your_information_lateralString);
        drawerLayout = findViewById(R.id.drawerlayout);
        imgChamarLS = findViewById(R.id.imgChamarLS);
        cart_img_main_img = findViewById(R.id.cart_img_main_img);
        cart_img_quant_main_img = findViewById(R.id.cart_img_quant_main_img);
        imgChamarLS.setOnClickListener(v -> {
            openDrawer(drawerLayout);
        });
        your_information_lateralString.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Login.class));
        });
        cart_img_main_img.setOnClickListener(v -> {
            Intent in = new Intent(MainActivity.this, CartActivity.class);
            in.putExtra("quantlist", 0);
            startActivity(in);
        });
        cartList = new ArrayList<>();
        if (cartList.size() > 0) {
            cart_img_quant_main_img.setVisibility(View.VISIBLE);
            cart_img_quant_main_img.setText(cartList.size());
        }
        RecyclerView rv_categorias_main = findViewById(R.id.rv_categorias_main);

        TextView categorias_populares_txt = findViewById(R.id.categorias_populares_txt);
        TextView ver_todas_txt = findViewById(R.id.ver_todas_txt);
        RecyclerView rv_medicine_main = findViewById(R.id.rv_medicine_main);
        TextInputEditText textInput = findViewById(R.id.textInput);
        textInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    lista = new ArrayList<>(SqlServer_connection.SqlServer_connection(getBaseContext()).getMediceserver());
                    ArrayList<MedicineItemPattern> lista2 = new ArrayList<>();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getNome().startsWith(s+"")) {
                            lista2.add(lista.get(i));
                        }
                    }

                    GridLayoutManager layoutManager = new GridLayoutManager(getBaseContext(),2, RecyclerView.VERTICAL,false);
//                    List<MedicineItemPattern> a = sqlite.getINSTANCE(getBaseContext()).getListCarrinho();
                    ProdutosAdapter adapter =new  ProdutosAdapter(getBaseContext(), lista2);
                    rv_medicine_main.setHasFixedSize(false);
                    rv_medicine_main.setLayoutManager(layoutManager);
                    rv_medicine_main.setAdapter(adapter);

//                    AdapterMediceItem adapterMediceItem = new AdapterMediceItem(getBaseContext(), lista2);
//                    rv_medicine_main.setAdapter(adapterMediceItem);
                    rv_medicine_main.setVisibility(View.VISIBLE);
                    rv_categorias_main.setVisibility(View.GONE);
                    categorias_populares_txt.setVisibility(View.GONE);
                    ver_todas_txt.setVisibility(View.GONE);

                } else {
                    categorias_populares_txt.setVisibility(View.VISIBLE);
                    ver_todas_txt.setVisibility(View.VISIBLE);
                    rv_categorias_main.setVisibility(View.VISIBLE);
                    rv_medicine_main.setVisibility(View.GONE);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
        List<CategoriaMain> categorias = new ArrayList<>();
        categorias.add(new CategoriaMain(R.drawable.mascara, "Mascaras"));
        categorias.add(new CategoriaMain(R.drawable.handwash, "Higiêne das mãos"));
        categorias.add(new CategoriaMain(R.drawable.bebidas, "Bebidas saúdaveis"));
        categorias.add(new CategoriaMain(R.drawable.sup_vit, "Suplementos e vitaminas"));
        AdapterCategorias adapter = new AdapterCategorias(this, categorias);
        rv_categorias_main.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(MainActivity.this, 2);
        rv_categorias_main.setLayoutManager(manager);
    }


    public void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.setOnSystemUiVisibilityChangeListener(visibility -> {
        });
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(drawerLayout.getWindowToken(), 0);
        drawerLayout.openDrawer(GravityCompat.START);
    }



}
