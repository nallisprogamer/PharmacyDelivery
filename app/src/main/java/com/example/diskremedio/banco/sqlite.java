package com.example.diskremedio.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.diskremedio.Pattern.MedicineItemPattern;
import com.example.diskremedio.Pattern.Person;
import com.example.diskremedio.Pattern.Price;
import com.example.diskremedio.Pattern.Produtopattern;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class sqlite extends SQLiteOpenHelper {


    public static final String DB_NAME = "informacoes_off";
    public static final int bd_version = 1;
    private static sqlite INSTANCE;

    public sqlite(Context context) {
        super(context, DB_NAME, null, bd_version);
    }

    public static sqlite getINSTANCE(Context context) {
        INSTANCE = new sqlite(context);
        return INSTANCE;
    }

    public void atualizarAcount(String idinterno, String nome, String admin, String numerotelefone,
                                String datanascimento, String endereco, String cep, String ifmoraemapartamento,
                                String numerocasa, String senha, String andar_apartamento, String bloco_apartamento,
                                String rg, String cpf, String perguntaseguranca, String respostaseguranca) {
        Log.d("banco", "atualizarAcount");
        try {
            SQLiteDatabase db = getReadableDatabase();

            ContentValues values = new ContentValues();
            values.put("nome", nome);
            values.put("admin", admin);
            values.put("numerotelefone", numerotelefone);
            values.put("datadenascimento", datanascimento);
            values.put("endereco", endereco);
            values.put("cep", cep);
            values.put("ifmoraemapartamento", ifmoraemapartamento);
            values.put("numerodacasa", numerocasa);
            values.put("senha", senha);
            values.put("andar_apartamento", andar_apartamento);
            values.put("bloco_apartamento", bloco_apartamento);
            values.put("cpf", cpf);
            values.put("rg", rg);
            values.put("pergunta_seguranca", perguntaseguranca);
            values.put("resposta_seguranca", respostaseguranca);
            String Selection = "idinterno =?";
            String[] Selectionargs = {idinterno};
            db.update("Dadospessoais", values, Selection, Selectionargs);
        } catch (Error | Exception e) {
            System.out.println("Erro na atualização da conta " + e);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  Carrinho (code TEXT, nome TEXT, modelo TEXT,fabricante TEXT," +
                "disconto TEXT,preco_original TEXT,quant_cartela TEXT,quant_per_cx TEXT,usosindicados TEXT," +
                "usosNindicados TEXT,imgbitmap TEXT)");
        db.execSQL("CREATE TABLE  Dadospessoais(idinterno INTEGER PRIMARY KEY , nome TEXT, numerotelefone TEXT," +
                " datadenascimento TEXT, endereco TEXT, cep TEXT, ifmoraemapartamento TEXT, numerodacasa TEXT, senha TEXT,andar_apartamento TEXT," +
                "bloco_apartamento,cpf,rg,pergunta_seguranca,resposta_seguranca,idPessoa,admin)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("fazer o onupgrade");
    }

    public void deleteItemlistCarrinho(String id) {
        Log.d("banco", "deleteItemCarrinho");
        SQLiteDatabase db = getWritableDatabase();
        String Selection = "code=? ";
        String[] Selectionargs = {id};
        db.delete("Carrinho", Selection, Selectionargs);


    }

    public ArrayList<MedicineItemPattern> getListCarrinho() {
        Log.d("banco", "getListCarrinho");
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM Carrinho", new String[]{});
        ArrayList<MedicineItemPattern> carrinho = new ArrayList<>();
        while (cursor.moveToNext()) {
            String code = cursor.getString(cursor.getColumnIndex("code"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String modelo = cursor.getString(cursor.getColumnIndex("modelo"));
            String fabricante = cursor.getString(cursor.getColumnIndex("fabricante"));
            String preco = cursor.getString(cursor.getColumnIndex("preco"));
            String preco_original = cursor.getString(cursor.getColumnIndex("preco_original"));
            String quant_cartela = cursor.getString(cursor.getColumnIndex("quant_cartela"));
            String Quant_per_cx = cursor.getString(cursor.getColumnIndex("Quant_per_cx"));
            String usosindicados = cursor.getString(cursor.getColumnIndex("usosindicados"));
            String usosNindicados = cursor.getString(cursor.getColumnIndex("usosNindicados"));
            String imgbitmap = cursor.getString(cursor.getColumnIndex("imgbitmap"));
            MedicineItemPattern remedio = new MedicineItemPattern(code, nome, modelo, fabricante, preco,
                    preco_original, quant_cartela, Quant_per_cx, usosindicados, usosNindicados, imgbitmap,"0");
            carrinho.add(remedio);
        }

        return carrinho;
    }

    public long addlistcarrinho(MedicineItemPattern mip) {
        Log.d("banco", "addItemCarrinho");
        long resultEvento = 0;
        try {
            SQLiteDatabase db = getReadableDatabase();
            ContentValues valores = new ContentValues();
            valores.put("code", mip.getId());
            valores.put("nome", mip.getNome());
            valores.put("usosindicados", mip.getUsosindicados());
            valores.put("usosNindicados", mip.getUsosNindicados());
            valores.put("modelo", mip.getModelo());
            valores.put("fabricante", mip.getFabricante());
            valores.put("disconto", mip.getDesconto());
            valores.put("preco_original", mip.getPreco_original());
            valores.put("quant_cartela", mip.getQuant_cartela());
            valores.put("Quant_per_cx", mip.getQuant_per_cx());
            valores.put("imgbitmap", mip.getBitmapImg());
            resultEvento = db.insert("Carrinho", null, valores);

        } catch (Exception e) {
            System.out.println("erro na insersao dos Produtos " + e);
        }
        return resultEvento;
    }

    public Person getRegisterAcountPessoa() {
        Log.d("banco", "getAcountPessoa");
        SQLiteDatabase db = getReadableDatabase();
        Person persons_information = null;
        Cursor cursor = db.rawQuery("SELECT * FROM Dadospessoais", new String[]{});
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            persons_information = new Person("" + cursor.getInt(cursor.getColumnIndex("idPessoa")),
                    cursor.getString(cursor.getColumnIndex("nome")), cursor.getString(cursor.getColumnIndex("numerotelefone")),
                    cursor.getString(cursor.getColumnIndex("datadenascimento")), cursor.getString(cursor.getColumnIndex("endereco")),
                    cursor.getString(cursor.getColumnIndex("cep")), cursor.getString(cursor.getColumnIndex("ifmoraemapartamento")), cursor.getString(cursor.getColumnIndex("numerodacasa")),
                    cursor.getString(cursor.getColumnIndex("senha")), cursor.getString(cursor.getColumnIndex("andar_apartamento")), cursor.getString(cursor.getColumnIndex("bloco_apartamento")),
                    cursor.getString(cursor.getColumnIndex("cpf")), cursor.getString(cursor.getColumnIndex("rg")),
                    cursor.getString(cursor.getColumnIndex("pergunta_seguranca")), cursor.getString(cursor.getColumnIndex("resposta_seguranca")), cursor.getString(cursor.getColumnIndex("admin")));
        } else {
            persons_information = new Person("", "", "", "",
                    "", "", "", "", "", "", "", "", "", "", "", "");
        }
        return persons_information;
    }

    public void adddadospessoais(String idinterno, String nome, String admin, String numerotelefone,
                                 String datanascimento, String endereco, String cep, String ifmoraemapartamento,
                                 String numerocasa, String senha, String andar_apartamento, String bloco_apartamento,
                                 String rg, String cpf, String pergunta_seguranca, String resposta_seguranca) {
        Log.d("SQLbanco", "SQL_addAcount");
        new Thread(new Runnable() {
            @Override
            public void run() {
                SQLiteDatabase db = getReadableDatabase();
                ContentValues valores = new ContentValues();
                valores.put("idPessoa", idinterno);
                valores.put("nome", nome);
                valores.put("numerotelefone", numerotelefone);

                if (ifmoraemapartamento.equals("false")) {
                    valores.put("andar_apartamento", "false");
                    valores.put("bloco_apartamento", "false");
                } else {
                    valores.put("andar_apartamento", andar_apartamento);
                    valores.put("bloco_apartamento", bloco_apartamento);
                }
                valores.put("andar_apartamento", andar_apartamento);
                valores.put("bloco_apartamento", bloco_apartamento);
                valores.put("numerotelefone", numerotelefone);
                valores.put("endereco", endereco);
                valores.put("numerodacasa", numerocasa);
                valores.put("datadenascimento", datanascimento);
                valores.put("cep", cep);
                valores.put("ifmoraemapartamento", ifmoraemapartamento);
                valores.put("senha", senha);
                valores.put("rg", rg);
                valores.put("cpf", cpf);
                valores.put("pergunta_seguranca", pergunta_seguranca);
                valores.put("resposta_seguranca", resposta_seguranca);
                db.insert("Dadospessoais", null, valores);
            }
        }).start();

    }

    public int getidPessoa() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT idPessoa FROM Dadospessoais", new String[]{});
        cursor.moveToFirst();
        int idPessoa = 0;
        if (cursor.getCount() == 1) {
            idPessoa = cursor.getInt(cursor.getColumnIndex("idPessoa"));
        }

        return idPessoa;
    }

}
