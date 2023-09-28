package com.apidelivery.models.data;

public class ClienteResponse {
    private Long id;
    private String email;
    private String nome;

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

    @Override
    public String toString() {return "ClienteResponse [id=" + id + ", Nome=" + nome + ", email=" + email + "]"; }
}
