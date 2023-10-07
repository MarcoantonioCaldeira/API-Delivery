package com.apidelivery.models.data;

import com.apidelivery.models.model.FormaPagamento;

public class ClienteResponse {
    private Long id;
    private String email;
    private String nome;

    private FormaPagamento formaPagamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {return "ClienteResponse [id=" + id + ", Nome=" + nome + ", email=" + email + ", Froma de Pagamento= " + formaPagamento + " ]"; }

}
