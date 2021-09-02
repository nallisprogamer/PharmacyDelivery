package com.example.diskremedio.Pattern;

public class Addrespattern {
    String nome_endereco;
    String endereco;
    String ifselected;

    public Addrespattern(String nome_endereco, String endereco, String ifselected) {
        this.nome_endereco = nome_endereco;
        this.endereco = endereco;
        this.ifselected = ifselected;
    }

    public String getNome_endereco() {
        return nome_endereco;
    }

    public String getifselected() {
        return ifselected;
    }

    public void setifselected(String ifselected) {
        this.ifselected = ifselected;
    }

    public void setNome_endereco(String nome_endereco) {
        this.nome_endereco = nome_endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}