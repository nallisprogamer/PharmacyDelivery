package com.example.diskremedio.Pattern;

public class MedicineItemPattern {
    private String nome;
    private String modelo;
    private String fabricante;
    private String desconto;
    private String preco_original;
    private String quant_cartela;
    private String quant_per_cx;
    private String id;
    private String usosindicados;
    private String usosNindicados;
    private String bitmapImg;
    private String quant_produto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getPreco_original() {
        return preco_original;
    }

    public void setPreco_original(String preco_original) {
        this.preco_original = preco_original;
    }

    public String getQuant_cartela() {
        return quant_cartela;
    }

    public void setQuant_cartela(String quant_cartela) {
        this.quant_cartela = quant_cartela;
    }

    public String getQuant_per_cx() {
        return quant_per_cx;
    }

    public void setQuant_per_cx(String quant_per_cx) {
        this.quant_per_cx = quant_per_cx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsosindicados() {
        return usosindicados;
    }

    public void setUsosindicados(String usosindicados) {
        this.usosindicados = usosindicados;
    }

    public String getUsosNindicados() {
        return usosNindicados;
    }

    public void setUsosNindicados(String usosNindicados) {
        this.usosNindicados = usosNindicados;
    }

    public String getBitmapImg() {
        return bitmapImg;
    }

    public void setBitmapImg(String bitmapImg) {
        this.bitmapImg = bitmapImg;
    }

    public String getQuant_produto() {
        return quant_produto;
    }

    public void setQuant_produto(String quant_produto) {
        this.quant_produto = quant_produto;
    }

    public MedicineItemPattern(String id,String nome, String modelo, String fabricante, String desconto, String preco_original, String quant_cartela, String quant_per_cx,
                               String usosindicados, String usosNindicados, String bitmapImg, String quant_produto) {
        this.nome = nome;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.desconto = desconto;
        this.preco_original = preco_original;
        this.quant_cartela = quant_cartela;
        this.quant_per_cx = quant_per_cx;
        this.id = id;
        this.usosindicados = usosindicados;
        this.usosNindicados = usosNindicados;
        this.bitmapImg = bitmapImg;
        this.quant_produto = quant_produto;
    }
}
