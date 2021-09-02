package com.example.diskremedio.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.diskremedio.Pattern.MedicineItemPattern;
import com.example.diskremedio.Pattern.Person;
import com.example.diskremedio.Pattern.Produtopattern;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SqlServer_connection {

    //add SQL to every sout in catch
    private static SqlServer_connection INSTANCE;
    private static Context context;

    public SqlServer_connection(Context context) {
        SqlServer_connection.context = context;
    }

    public static SqlServer_connection SqlServer_connection(Context context) {
        INSTANCE = new SqlServer_connection(context);
        return INSTANCE;
    }

    public List<MedicineItemPattern> getMediceserver() {
        Log.d("banco", "SQLgetMediceserver");
        List<MedicineItemPattern> lista_remedios = new ArrayList<>();
        try {
            String sql = "select * from Produtos";
            PreparedStatement pst = ConnetionClass.connectar().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                lista_remedios.add(new MedicineItemPattern(String.valueOf(System.currentTimeMillis()).substring(5), rs.getString("nome")
                        , rs.getString("modelo"), rs.getString("fabricante"), rs.getString("desconto"),
                        rs.getString("preco_original"), rs.getString("Quant_cartela"), rs.getString("Quant_per_cx"),
                        rs.getString("usosindicados"), rs.getString("usosNindicados"), rs.getString("imgbitmap"),"0"));
            }
        } catch (Error | Exception e) {
            System.out.println("Erro no SQLgetRemedio " + e);
        }
        return lista_remedios;
    }

    public void atualizarAcountPerson(String nome, String admin, String numerotelefone,
                                      String datanascimento, String endereco, String cep, String ifmoraemapartamento,
                                      String numerocasa, String senha, String andar_apartamento, String bloco_apartamento,
                                      String rg, String cpf, String perguntaseguranca, String respostaseguranca) {
        Log.d("banco", "atualizarAcount");
        try {

            String sql = "UPDATE  DadosPessoais SET (nome,admin,datadenascimento,endereco,cep,ifmoraemapartamento," +
                    "numerodacasa,senha,andar_apartamento,bloco_apartamento,cpf,rg,pergunta_seguranca,resposta_seguranca) VALUES(" + nome + "," + admin + "," + numerotelefone + "," + datanascimento + ","
                    + endereco + "," + cep + "," + ifmoraemapartamento + "," + numerocasa + "," + senha + "," + andar_apartamento + "," + bloco_apartamento + "," + cpf + "," + rg + "," + perguntaseguranca + "," + respostaseguranca + ") WHERE idPessoa =? " + getidPessoa();


        } catch (Error | Exception e) {
            System.out.println("Erro na atualização da conta " + e);
        }
    }

    private int getidPessoa() {
        int id = 0;
        id = sqlite.getINSTANCE(context).getidPessoa();
        return id;
    }

    public void addAcountPerson(String idinterno, String nome, String admin, String numerotelefone,
                                String datanascimento, String endereco, String cep, String ifmoraemapartamento,
                                String numerocasa, String senha, String andar_apartamento, String bloco_apartamento,
                                String rg, String cpf, String pergunta_seguranca, String resposta_seguranca) {
        Log.d("SQLbanco", "SQL_addAcount");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    String sql = "INSERT INTO Cadastros (nome,numerotelefone,datadenascimento,endereco,cep,ifmoraemapartamento," +
                            "numerodacasa,senha,andar_apartamento,bloco_apartamento,cpf,rg,idPessoa,resposta_seguranca,pergunta_seguranca,admin) VALUES(?,?,?," +
                            "?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                    PreparedStatement pst = ConnetionClass.connectar().prepareStatement(sql);


                    pst.setString(1, nome);
                    pst.setString(2, numerotelefone);
                    pst.setString(3, datanascimento);
                    pst.setString(4, endereco);
                    pst.setString(5, cep);
                    pst.setString(6, ifmoraemapartamento);
                    pst.setString(7, numerocasa);
                    pst.setString(8, senha);
                    if (ifmoraemapartamento.equals("false")) {
                        pst.setString(9, "false");
                        pst.setString(10, "false");
                    } else {
                        pst.setString(9, andar_apartamento);
                        pst.setString(10, bloco_apartamento);
                    }

                    pst.setString(11, cpf);
                    pst.setString(12, rg);
                    pst.setInt(13, getidPessoa());
                    pst.setString(14, resposta_seguranca);
                    pst.setString(15, pergunta_seguranca);
                    pst.setString(16, admin);
                    pst.executeUpdate();
                } catch (Error | Exception e) {
                    System.out.println("SQL_addAcount erro na inserção da conta " + e);
                }
            }
        }).start();

    }

    public Person getLoginAcount() {
        Person person = null;
        try {
            String sql = "SELECT  * FROM Dadospessoais WHERE idPessoa like (CAST(" + getidPessoa() + " as int))";
            PreparedStatement pst = ConnetionClass.connectar().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                person = new Person(rs.getString("idPessoa"), rs.getString("nome"), rs.getString("numerotelefone"),
                        rs.getString("datadenascimento"), rs.getString("endereco"),
                        rs.getString("cep"), rs.getString("ifmoraemapartamento"), rs.getString("numerodacasa"),
                        rs.getString("senha"), rs.getString("andar_apartamento"), rs.getString("bloco_apartamento"),
                        rs.getString("cpf"), rs.getString("rg"), rs.getString("pergunta_seguranca"),
                        rs.getString("resposta_seguranca"),
                        rs.getString("admin"));
            }
        } catch (Error | Exception e) {
            System.out.println("Erro na coleta da conta completa " + e);
        }

        return person;
    }

    public List<String> getLogin(String cpf, String senha) {
        List<String> person = new ArrayList<>();
        try {
            String sql = "SELECT pergunta_seguranca, resposta_seguranca,idPessoa FROM Cadastros WHERE cpf like'" + cpf + "' AND senha like'" + senha + "';";
            PreparedStatement pst = ConnetionClass.connectar().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                person.add(rs.getString("pergunta_seguranca"));
                person.add(rs.getString("resposta_seguranca"));
                person.add(rs.getString("idPessoa"));
            }
        } catch (Error | Exception e) {
            System.out.println("Erro na checagem da conta " + e);
        }
        return person;
    }
    public void addProduto(MedicineItemPattern mip) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    String sql = "INSERT INTO Produtos (nome,modelo,fabricante,desconto,preco_original," +
                            "Quant_per_cx,quant_cartela,usosindicados,usosNindicados,imgbitmap) VALUES(?,?,?,?,?,?,?,?,?,?);";
                    PreparedStatement pst = ConnetionClass.connectar().prepareStatement(sql);
                    pst.setString(1, mip.getNome());
                    pst.setString(2, mip.getModelo());
                    pst.setString(3, mip.getFabricante());
                    pst.setString(4, mip.getDesconto());
                    pst.setString(5, mip.getPreco_original());
                    pst.setString(6, mip.getQuant_per_cx());
                    pst.setString(7, mip.getQuant_cartela());
                    pst.setString(8, mip.getUsosindicados());
                    pst.setString(9, mip.getUsosNindicados());
                    pst.setString(10, mip.getBitmapImg());
                    pst.executeUpdate();

                } catch (Error | Exception e) {
                    System.out.println("SQL_addAcount erro na inserção da conta " + e);
                }
            }
        }).start();

    }
}
