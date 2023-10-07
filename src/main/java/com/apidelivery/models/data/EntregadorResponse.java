package com.apidelivery.models.data;

import com.apidelivery.models.model.EnderecoEntregador;

public class EntregadorResponse {

    private Long id;
    private String email;
    private String nome;
    private EnderecoEntregador endereco;

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

    public EnderecoEntregador getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntregador endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {return "EntregadorResponse [id=" + id + ", Nome=" + nome + ", email=" + email + ", Dados do Endereco" + endereco + " ]"; }

}
