package com.apidelivery.models.data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EntregadorRequest {

    private Long id;
    private String email;
    private String nome;
    private String Senha;
    private String confirmarSenha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Email(message = "email inválido")
    @NotBlank(message = "O email é obrigatório.")
    @NotNull(message = "O email é obrigatório.")
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

    @NotBlank(message = "A senha é obrigatória.")
    @NotNull(message = "A senha é obrigatória.")
    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    @NotBlank(message = "A confirmação de senha é obrigatória.")
    @NotNull(message = "A confirmação de senha é obrigatória.")
    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    @Override
    public String toString() {
        return "UserRequest [id=" + id + ", Nome=" + nome + ", email=" + email + ", Senha=" + Senha
                + ", Confirmação de Senha=" + confirmarSenha + "]";
    }
}
