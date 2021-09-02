package com.example.diskremedio.Pattern;

public class Person {
    public String getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(String idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumerotelefone() {
        return numerotelefone;
    }

    public void setNumerotelefone(String numerotelefone) {
        this.numerotelefone = numerotelefone;
    }

    public String getDatadenascimento() {
        return datadenascimento;
    }

    public void setDatadenascimento(String datadenascimento) {
        this.datadenascimento = datadenascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getIfmoraemapartamento() {
        return ifmoraemapartamento;
    }

    public void setIfmoraemapartamento(String ifmoraemapartamento) {
        this.ifmoraemapartamento = ifmoraemapartamento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAndar_apartamento() {
        return andar_apartamento;
    }

    public void setAndar_apartamento(String andar_apartamento) {
        this.andar_apartamento = andar_apartamento;
    }

    public String getBloco_apartamento() {
        return bloco_apartamento;
    }

    public void setBloco_apartamento(String bloco_apartamento) {
        this.bloco_apartamento = bloco_apartamento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNumerodacasa() {
        return numerodacasa;
    }

    public void setNumerodacasa(String numerodacasa) {
        this.numerodacasa = numerodacasa;
    }

    public String getPergunta_seguranca() {
        return pergunta_seguranca;
    }

    public void setPergunta_seguranca(String pergunta_seguranca) {
        this.pergunta_seguranca = pergunta_seguranca;
    }

    public String getResposta_seguranca() {
        return resposta_seguranca;
    }

    public void setResposta_seguranca(String resposta_seguranca) {
        this.resposta_seguranca = resposta_seguranca;
    }

    public Person(String idPessoa, String nome, String numerotelefone,
                  String datadenascimento, String endereco, String cep, String ifmoraemapartamento,
                  String numerodacasa, String senha, String andar_apartamento, String bloco_apartamento,
                  String cpf, String rg, String pergunta_seguranca, String resposta_seguranca,String admin) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.numerotelefone = numerotelefone;
        this.admin = admin;
        this.datadenascimento = datadenascimento;
        this.endereco = endereco;
        this.cep = cep;
        this.numerodacasa = numerodacasa;
        this.ifmoraemapartamento = ifmoraemapartamento;
        this.senha = senha;
        this.andar_apartamento = andar_apartamento;
        this.bloco_apartamento = bloco_apartamento;
        this.cpf = cpf;
        this.rg = rg;
        this.pergunta_seguranca = pergunta_seguranca;
        this.resposta_seguranca = resposta_seguranca;
    }

    public String idPessoa;//
    public String nome;
    public String numerotelefone;
    public String admin;
    public String datadenascimento;
    public String endereco;
    public String cep;
    public String ifmoraemapartamento;
    public String senha;//
    public String andar_apartamento;
    public String bloco_apartamento;
    public String cpf;
    public String rg;
    public String numerodacasa;
    public String pergunta_seguranca;
    public String resposta_seguranca;

}
