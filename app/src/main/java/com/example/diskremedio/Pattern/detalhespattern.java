package com.example.diskremedio.Pattern;

public class detalhespattern {
    String nome_remedio;
    String utilidade_remedio;
    String contraseptivos_remedio;
    String quan_per_caixa;

    public detalhespattern(String nome_remedio, String utilidade_remedio, String contraseptivos_remedio, String quan_per_caixa, String ml_per_comprimido) {
        this.nome_remedio = nome_remedio;
        this.utilidade_remedio = utilidade_remedio;
        this.contraseptivos_remedio = contraseptivos_remedio;
        this.quan_per_caixa = quan_per_caixa;
        this.ml_per_comprimido = ml_per_comprimido;
    }

    public String getNome_remedio() {
        return nome_remedio;
    }

    public void setNome_remedio(String nome_remedio) {
        this.nome_remedio = nome_remedio;
    }

    public String getUtilidade_remedio() {
        return utilidade_remedio;
    }

    public void setUtilidade_remedio(String utilidade_remedio) {
        this.utilidade_remedio = utilidade_remedio;
    }

    public String getContraseptivos_remedio() {
        return contraseptivos_remedio;
    }

    public void setContraseptivos_remedio(String contraseptivos_remedio) {
        this.contraseptivos_remedio = contraseptivos_remedio;
    }

    public String getQuan_per_caixa() {
        return quan_per_caixa;
    }

    public void setQuan_per_caixa(String quan_per_caixa) {
        this.quan_per_caixa = quan_per_caixa;
    }

    public String getMl_per_comprimido() {
        return ml_per_comprimido;
    }

    public void setMl_per_comprimido(String ml_per_comprimido) {
        this.ml_per_comprimido = ml_per_comprimido;
    }

    String ml_per_comprimido;
}
