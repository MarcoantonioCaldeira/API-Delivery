package com.apidelivery.models.data;

public class FormaPagamentoRequest {

    private Integer tipoPagamento;
    private String num_cartao;
    private String nomeImpresso;
    private String validadeCartao;
    private String cvvCartao;
    private String nome_Apelido;
    private String cpf_cnpj;

    public Integer getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(Integer tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }


    public String getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(String num_cartao) {
        this.num_cartao = num_cartao;
    }


    public String getNomeImpresso() {
        return nomeImpresso;
    }

    public void setNomeImpresso(String nomeImpresso) {
        this.nomeImpresso = nomeImpresso;
    }


    public String getValidadeCartao() {
        return validadeCartao;
    }

    public void setValidadeCartao(String validadeCartao) {
        this.validadeCartao = validadeCartao;
    }


    public String getCvvCartao() {
        return cvvCartao;
    }

    public void setCvvCartao(String cvvCartao) {
        this.cvvCartao = cvvCartao;
    }


    public String getNome_Apelido() {
        return nome_Apelido;
    }

    public void setNome_Apelido(String nome_Apelido) {
        this.nome_Apelido = nome_Apelido;
    }


    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    @Override
    public String toString(){
        return "Forma de Pagamento [Tipo=" + tipoPagamento + ", Numero do Cartão=" + num_cartao + ", Nome Impresso=" + nomeImpresso + "CVV="  + cvvCartao + "Validade=" + validadeCartao + "Nome Apelido=" + nome_Apelido + "CPF_CNPJ=" + cpf_cnpj +"]";
    }

}
