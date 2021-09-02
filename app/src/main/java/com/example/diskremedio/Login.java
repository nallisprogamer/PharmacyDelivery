package com.example.diskremedio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.diskremedio.Pattern.Person;
import com.example.diskremedio.banco.SqlServer_connection;
import com.example.diskremedio.banco.SyncAllDatabase;
import com.example.diskremedio.banco.sqlite;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    ImageView imgvoltar_sua_conta_Main;
    Button register, entrar;
    EditText cpf_login, password_login;
    Context context;
    AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Person person = sqlite.getINSTANCE(getApplicationContext()).getRegisterAcountPessoa();
        register = findViewById(R.id.register_acount);
        entrar = findViewById(R.id.entrar_acount);
        imgvoltar_sua_conta_Main = findViewById(R.id.imgvoltar_sua_contaa_Main);
        cpf_login = findViewById(R.id.cpf_login);
        SimpleMaskFormatter cpf = new SimpleMaskFormatter("NNN.NNN.NNN/NN");
        MaskTextWatcher mtwcpf = new MaskTextWatcher(cpf_login, cpf);
        cpf_login.addTextChangedListener(mtwcpf);
        password_login = findViewById(R.id.password_login);
        register.setOnClickListener(v -> {
            Intent i = new Intent(getBaseContext(), Register.class);
            startActivity(i);
        });
        imgvoltar_sua_conta_Main.setOnClickListener(v -> {
            startActivity(new Intent(Login.this, MainActivity.class));
        });
        entrar.setOnClickListener(v -> {
            String cpf1, senha;
            boolean a = true;
            if (cpf_login.getText().toString().isEmpty()) {
                cpf_login.setError(getString(R.string.empty_field));
                a = false;
            }
            if (password_login.getText().toString().isEmpty()) {
                password_login.setError(getString(R.string.empty_field));
                a = false;
            }
            if (a) {
                cpf1 = cpf_login.getText().toString();
                senha = password_login.getText().toString();
                List<String> personString = new ArrayList<>(SqlServer_connection.SqlServer_connection(getBaseContext()).getLogin(cpf1, senha));
                android.app.AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Login.this);
                if (personString.size() > 1) {
                    View Obview = LayoutInflater.from(getBaseContext()).inflate(R.layout.new_iten_spinner, null);
                    TextInputLayout nome_objetivo_dialog = Obview.findViewById(R.id.Name_level_criationL);
                    TextView textTop_new_item_spinner = Obview.findViewById(R.id.textTop_new_item_spinner);
                    Button addLevel = Obview.findViewById(R.id.addLevel);
                    addLevel.setText(R.string.respostaSeguranca);
                    addLevel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String resposta = nome_objetivo_dialog.getEditText().getText().toString();
                            if (resposta.equals("")) {
                                nome_objetivo_dialog.setError(getString(R.string.empty_field));
                            } else {
                                if (resposta.equals(personString.get(1))) {
                                    Person person = SqlServer_connection.SqlServer_connection(getBaseContext()).getLoginAcount();
                                    if(sqlite.getINSTANCE(getBaseContext()).getRegisterAcountPessoa().nome.equals("")){
//                                    sqlite.getINSTANCE(getBaseContext()).adddadospessoais(person.nome, person.nomedaempresa, person.numerotelefone, person.datadenascimento,
//                                            person.endereco, person.cep, person.ifmoraemapartamento, person.numerodacasa, person.senha, person.andar_apartamento, person.bloco_apartamento,
//                                            person.rg, person.cpf, person.pergunta_seguranca, person.resposta_seguranca, person.idPessoa);
                                        SyncAllDatabase.pegando_dados_online(getBaseContext());
                                        Intent i = new Intent(Login.this,Register.class);
                                        i.putExtra("edit_Acount","true");
                                        startActivity(i);
                                    }else {
                                        Intent i = new Intent(Login.this,Register.class);
                                        startActivity(i);

                                    }
                                    alert.dismiss();
                                }
                            }
                        }
                    });
                    TextView pergunta_seguranca_new_item_spinner = Obview.findViewById(R.id.pergunta_seguranca_new_item_spinner);
                    pergunta_seguranca_new_item_spinner.setText(personString.get(0));
                    textTop_new_item_spinner.setText(getText(R.string.perguntaSeguranca));
                    nome_objetivo_dialog.setHint(getText(R.string.respostaSeguranca));
                    dialogBuilder.setView(Obview);
                    alert = dialogBuilder.create();
                    alert.show();
                } else {
                    Toast.makeText(Login.this, R.string.contanaoencontrada, Toast.LENGTH_LONG).show();
                }

//                if (pessoaon!=null) {
//                    Intent i = new Intent(getBaseContext(), Register.class);
//               +     i.putExtra("edit_Acount", "true");
//                    startActivity(i);
//                }else {
//                    Toast.makeText(LoginActivity.this, "Conta não encontrada", Toast.LENGTH_SHORT).show();
//                }
            }

        });
    }

}