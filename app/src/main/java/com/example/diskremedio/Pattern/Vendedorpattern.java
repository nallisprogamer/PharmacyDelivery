package com.example.diskremedio.Pattern;

public class Vendedorpattern {
    public String nomeVendedor;
    public String codigo;
    public String comissao;
    public String idinterno;
    public String nivel;

    public String getIdinterno() {
        return idinterno;
    }

    public String getnivel() {
        return nivel;
    }

    public void setIdinterno(String idinterno) {
        this.idinterno = idinterno;
    }

    public void setnivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getComissao() {
        return comissao;
    }

    public void setComissao(String comissao) {
        this.comissao = comissao;
    }


}
