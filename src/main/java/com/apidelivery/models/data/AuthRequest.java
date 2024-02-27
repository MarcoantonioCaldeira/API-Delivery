package com.apidelivery.models.data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AuthRequest {

    private String email;
    private String senha;

    @Email(message = "email inválido")
    @NotBlank(message = "O email é obrigatório.")
    @NotNull(message = "O email é obrigatório.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank(message = "A senha é obrigatória.")
    @NotNull(message = "A senha é obrigatória.")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString(){
        return "AuthRequest[Email="+ email+ " + Senha=" + senha + "]";
    }

}
