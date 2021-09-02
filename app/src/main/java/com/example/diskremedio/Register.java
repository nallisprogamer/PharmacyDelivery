package com.example.diskremedio;

import static android.R.layout.simple_spinner_dropdown_item;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.diskremedio.Pattern.Person;
import com.example.diskremedio.banco.SqlServer_connection;
import com.example.diskremedio.banco.sqlite;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {
    ImageView imgvoltar_register_Main;
    Spinner Asksecurity;
    String perguntaseguranca,respostaseguranca;
    AlertDialog alertDialog;
    Button save_informations_userAcont;
    EditText nome,numberphone, data_nascimento, endereco, cepEdittext, numero_casa,securityAnswer_vendedor, password, repeatpassword, andar_apartamento, bloco_apartamento, rg_formulario, cpf_formulario;
    CheckBox ifmoraemapartamento;
    TextInputLayout andar_apartamentoL, bloco_condominioL, numero_casaL;
    boolean iflivinginapartmentB = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //findViewById
        imgvoltar_register_Main = findViewById(R.id.imgvoltar_register_Main);
        Asksecurity = findViewById(R.id.Asksecurity);
        nome = (TextInputEditText) findViewById(R.id.username_formulario);
        numberphone = (TextInputEditText) findViewById(R.id.numberphone_formulario);
        data_nascimento = (TextInputEditText) findViewById(R.id.data_nascimento_formulario);
        ifmoraemapartamento = findViewById(R.id.ifmoraemapartamento_formulario);
        endereco = (TextInputEditText) findViewById(R.id.endereco_formulario);
        andar_apartamento = (TextInputEditText) findViewById(R.id.andar_apartamento_formulario);
        andar_apartamentoL = (TextInputLayout) findViewById(R.id.andar_apartamentoL);
        numero_casaL = (TextInputLayout) findViewById(R.id.numero_casaL);
        bloco_condominioL = (TextInputLayout) findViewById(R.id.bloco_condominioL);
        bloco_apartamento = (TextInputEditText) findViewById(R.id.bloco_apartamento_formulario);
        cepEdittext = (TextInputEditText) findViewById(R.id.cep_formulario);
        securityAnswer_vendedor = (TextInputEditText) findViewById(R.id.securityAnswer_vendedor);
        numero_casa = (TextInputEditText) findViewById(R.id.numero_casa_formulario);
        password = (TextInputEditText) findViewById(R.id.password_formulario);
        rg_formulario = (TextInputEditText) findViewById(R.id.rg_formulario);
        cpf_formulario = (TextInputEditText) findViewById(R.id.cpf_formulario);
        repeatpassword = (TextInputEditText) findViewById(R.id.repeatpassword_formulario);
        save_informations_userAcont = findViewById(R.id.save_informations_userAcont_formulario);
        numero_casaL.setHint(R.string.number_houses);
        //mascaras
        SimpleMaskFormatter cep = new SimpleMaskFormatter("NNNNN-NNN");
        MaskTextWatcher smfcep = new MaskTextWatcher(cepEdittext, cep);
        SimpleMaskFormatter nascimento = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher nascimentof = new MaskTextWatcher(data_nascimento, nascimento);
        SimpleMaskFormatter numberf = new SimpleMaskFormatter("(NN) NNNNN-NNNN");
        MaskTextWatcher mtw = new MaskTextWatcher(numberphone, numberf);
        SimpleMaskFormatter rg = new SimpleMaskFormatter("NN.NNN.NNN-N");
        MaskTextWatcher mtwrg = new MaskTextWatcher(rg_formulario, rg);
        SimpleMaskFormatter cpf = new SimpleMaskFormatter("NNN.NNN.NNN/NN");
        MaskTextWatcher mtwcpf = new MaskTextWatcher(cpf_formulario, cpf);

        //aplicando as mascaras
        numberphone.addTextChangedListener(mtw);
        data_nascimento.addTextChangedListener(nascimentof);
        cepEdittext.addTextChangedListener(smfcep);
        rg_formulario.addTextChangedListener(mtwrg);
        cpf_formulario.addTextChangedListener(mtwcpf);

        List<String> categorias = new ArrayList<>();
        categorias.add("Número da sorte");
        categorias.add("Nome da mãe");
        categorias.add("Cor preferida");
        categorias.add("Apelido de infancia");
        categorias.add("Mês favorito");
        ArrayAdapter<String> arrayAdapter_categoria = new ArrayAdapter<>(this, R.layout.simple_spinner_layout, categorias);
        Asksecurity.setAdapter(arrayAdapter_categoria);
        Asksecurity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                perguntaseguranca = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                perguntaseguranca = "Número da sorte";
            }
        });



        Intent i = getIntent();
        String edit_Acount = i.getStringExtra("edit_Acount");
        Person person = sqlite.getINSTANCE(getBaseContext()).getRegisterAcountPessoa();

        if (edit_Acount != null) {
            nome.setText(person.nome);
            numberphone.setText(person.numerotelefone);
            data_nascimento.setText(person.datadenascimento);
            endereco.setText(person.endereco);
            cepEdittext.setText(person.cep);
            numero_casa.setText(person.numerodacasa);
            password.setText(person.senha);
            repeatpassword.setText(person.senha);
            ifmoraemapartamento.setChecked(Boolean.parseBoolean(person.ifmoraemapartamento));
            if (ifmoraemapartamento.isChecked()) {
                andar_apartamentoL.setVisibility(View.VISIBLE);
            }
            andar_apartamento.setText(person.andar_apartamento);
            bloco_apartamento.setText(person.bloco_apartamento);
            rg_formulario.setText(person.rg);
            cpf_formulario.setText(person.cpf);
            save_informations_userAcont.setText(R.string.atualizar);
            if (person.ifmoraemapartamento.equals("true")) {
                numero_casaL.setHint(R.string.number_houses);
                andar_apartamento.setText(person.andar_apartamento);
                bloco_apartamento.setText(person.bloco_apartamento);

            }
            save_informations_userAcont.setOnClickListener(v -> {
                List<String> Errormensage = new ArrayList<>();
                new Thread(() -> {
                    if (nome.getText().toString().isEmpty()) {
                        Errormensage.add("1");
                    }

                    if (data_nascimento.getText().toString().isEmpty()) {
                        Errormensage.add("3");

                    }
                    if (cepEdittext.getText().toString().isEmpty()) {
                        Errormensage.add("5");
                    }
                    if (numero_casa.getText().toString().isEmpty()) {
                        Errormensage.add("6");

                    }
                    if (password.getText().toString().isEmpty()) {
                        Errormensage.add("7");
                    }
                    if (repeatpassword.getText().toString().isEmpty()) {
                        Errormensage.add("8");
                    }
                    if (!repeatpassword.getText().toString().equals(password.getText().toString())) {
                        Errormensage.add("9");//senhas diferentes
                    }
                    if (andar_apartamento.getText().toString().isEmpty() && iflivinginapartmentB) {
                        Errormensage.add("a");// iflivinginapartment == true
                    }
                    if (bloco_apartamento.getText().toString().isEmpty() && iflivinginapartmentB) {
                        Errormensage.add("b");// iflivinginapartment == true
                    }
                    if (rg_formulario.getText().toString().isEmpty()) {
                        Errormensage.add("c");
                    }
                    if (cpf_formulario.getText().toString().isEmpty()) {
                        Errormensage.add("d");
                    }
                    if (cpf_formulario.getText().toString().isEmpty()) {
                        Errormensage.add("d");
                    }
                    if (endereco.getText().toString().isEmpty()) {
                        Errormensage.add("4");

                    }
                    if (securityAnswer_vendedor.getText().toString().isEmpty()) {
                        Errormensage.add("e");

                    }
                    runOnUiThread(() -> {
                        StringBuilder a = new StringBuilder();
                        for (int i1 = 0; i1 < Errormensage.size(); i1++) {
                            a.append(Errormensage.get(i1));
                        }
                        if (a.toString().contains("1")) {
                            nome.setError(getString(R.string.empty_field));
                        }

                        if (a.toString().contains("3")) {
                            data_nascimento.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("4")) {
                            endereco.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("5")) {
                            cepEdittext.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("6")) {
                            numero_casa.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("7")) {
                            password.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("e")) {
                            securityAnswer_vendedor.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("8")) {
                            repeatpassword.setError(getString(R.string.empty_field));
                        } else {
                            if (a.toString().contains("9")) {//senhas não batem
                                repeatpassword.setError("As senha não são iguais");
                            }
                        }
                        if (a.toString().contains("a")) {
                            andar_apartamento.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("b")) {
                            bloco_apartamento.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("c")) {
                            bloco_apartamento.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("d")) {
                            bloco_apartamento.setError(getString(R.string.empty_field));
                        }
                        if (a.length() == 0) {

                            SqlServer_connection.SqlServer_connection(getBaseContext()).atualizarAcountPerson(nome.getText().toString(),
                                    "false", numberphone.getText().toString(), data_nascimento.getText().toString(), endereco.getText().toString(),
                                    cepEdittext.getText().toString(), String.valueOf(ifmoraemapartamento.isChecked()), numero_casa.getText().toString(), password.getText().toString(),
                                    andar_apartamento.getText().toString(), bloco_apartamento.getText().toString(), rg_formulario.getText().toString(), cpf_formulario.getText().toString(),
                                    perguntaseguranca,securityAnswer_vendedor.getText().toString());

                            sqlite.getINSTANCE(getApplicationContext()).atualizarAcount(person.idPessoa, nome.getText().toString(),
                                    "false", numberphone.getText().toString(), data_nascimento.getText().toString(), endereco.getText().toString(),
                                    cepEdittext.getText().toString(), String.valueOf(ifmoraemapartamento.isChecked()), numero_casa.getText().toString(), password.getText().toString(),
                                    andar_apartamento.getText().toString(), bloco_apartamento.getText().toString(), rg_formulario.getText().toString(), cpf_formulario.getText().toString(),perguntaseguranca,securityAnswer_vendedor.getText().toString());
                            Intent i1 = new Intent(getBaseContext(), MainActivity.class);
                            startActivity(i1);
                        }
                    });
                }).start();

            });
        } else {
            save_informations_userAcont.setOnClickListener(v -> {
                List<String> Errormensage = new ArrayList<>();
                new Thread(() -> {
                    if (nome.getText().toString().isEmpty()) {
                        Errormensage.add("1");
                    }
                    if (data_nascimento.getText().toString().isEmpty()) {
                        Errormensage.add("3");

                    }
                    if (endereco.getText().toString().isEmpty()) {
                        Errormensage.add("4");

                    }
                    if (cepEdittext.getText().toString().isEmpty()) {
                        Errormensage.add("5");
                    }
                    if (numero_casa.getText().toString().isEmpty()) {
                        Errormensage.add("6");

                    }
                    if (password.getText().toString().isEmpty()) {
                        Errormensage.add("7");
                    }
                    if (repeatpassword.getText().toString().isEmpty()) {
                        Errormensage.add("8");
                    }
                    if (!repeatpassword.getText().toString().equals(password.getText().toString())) {
                        Errormensage.add("9");//senhas diferentes
                    }
                    if (andar_apartamento.getText().toString().isEmpty() && iflivinginapartmentB) {
                        Errormensage.add("a");// iflivinginapartment == true
                    }
                    if (bloco_apartamento.getText().toString().isEmpty() && iflivinginapartmentB) {
                        Errormensage.add("b");// iflivinginapartment == true
                    }
                    if (rg_formulario.getText().toString().isEmpty()) {
                        Errormensage.add("c");
                    }
                    if (cpf_formulario.getText().toString().isEmpty()) {
                        Errormensage.add("d");
                    }
                    runOnUiThread(() -> {
                        StringBuilder a = new StringBuilder();
                        for (String erro : Errormensage) {
                            a.append(erro);
                        }
                        if (a.toString().contains("1")) {
                            nome.setError(getString(R.string.empty_field));
                        }

                        if (a.toString().contains("3")) {
                            data_nascimento.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("4")) {
                            endereco.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("5")) {
                            cepEdittext.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("6")) {
                            numero_casa.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("7")) {
                            password.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("8")) {
                            repeatpassword.setError(getString(R.string.empty_field));
                        } else {
                            if (a.toString().contains("9")) {//senhas não batem
                                repeatpassword.setError("As senha não são iguais");
                            }
                        }
                        if (a.toString().contains("a")) {
                            andar_apartamento.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("b")) {
                            bloco_apartamento.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("c")) {
                            bloco_apartamento.setError(getString(R.string.empty_field));
                        }
                        if (a.toString().contains("d")) {
                            bloco_apartamento.setError(getString(R.string.empty_field));
                        }
                        if (a.length() == 0) {

//                            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getBaseContext());
//                            View securityView = View.inflate(v.getContext(), R.layout.new_iten_spinner, null);
//
//                            dialogBuilder.setView(securityView);
//                            alertDialog = dialogBuilder.create();
//                            alertDialog.show();

                            String idinterno = String.valueOf(System.currentTimeMillis()).substring(5);
                            sqlite.getINSTANCE(getApplicationContext()).adddadospessoais(idinterno,nome.getText().toString(), "false",
                                    numberphone.getText().toString(), data_nascimento.getText().toString(), endereco.getText().toString(), cepEdittext.getText().toString(),
                                    String.valueOf(ifmoraemapartamento.isChecked()), numero_casa.getText().toString(), password.getText().toString(), andar_apartamento.getText().toString(),
                                    bloco_apartamento.getText().toString(), rg_formulario.getText().toString(), cpf_formulario.getText().toString(),
                                    perguntaseguranca,securityAnswer_vendedor.getText().toString());

                            SqlServer_connection.SqlServer_connection(getBaseContext()).addAcountPerson(idinterno, nome.getText().toString(),
                                    "false", numberphone.getText().toString(), data_nascimento.getText().toString(), endereco.getText().toString(),
                                    cepEdittext.getText().toString(), String.valueOf(ifmoraemapartamento.isChecked()), numero_casa.getText().toString(), password.getText().toString(),
                                    andar_apartamento.getText().toString(), bloco_apartamento.getText().toString(), rg_formulario.getText().toString(), cpf_formulario.getText().toString(),
                                    perguntaseguranca,securityAnswer_vendedor.getText().toString());
                            Intent i12 = new Intent(getBaseContext(), MainActivity.class);
                            i12.putExtra("nome", nome.getText().toString());
                            i12.putExtra("numero_telefone", numberphone.getText().toString());
                            startActivity(i12);
                        }
                    });
                }).start();

            });


        }


        ifmoraemapartamento.setOnCheckedChangeListener((buttonView, isChecked) -> {
            iflivinginapartmentB = isChecked;
            if (iflivinginapartmentB) {
                andar_apartamentoL.setHint(R.string.andar_apartamento);
                bloco_condominioL.setHint(R.string.bloco_apartamento);
                andar_apartamentoL.setVisibility(View.VISIBLE);
                bloco_condominioL.setVisibility(View.VISIBLE);
            } else {
                andar_apartamentoL.setVisibility(View.GONE);
                bloco_condominioL.setVisibility(View.GONE);
            }
        });

        imgvoltar_register_Main.setOnClickListener(v -> {
            Intent i13 = new Intent(getBaseContext(), MainActivity.class);
            startActivity(i13);
        });


    }
}