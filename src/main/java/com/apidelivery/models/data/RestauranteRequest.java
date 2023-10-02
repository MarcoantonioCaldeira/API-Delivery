package com.apidelivery.models.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RestauranteRequest {

    private String nome_restaurante;
    private String CNPJ;
    private String Telefone_Restaurante;
    private String Email;
    private String Senha;
    private String ConfirmarSenha;

    @NotBlank(message = "O nome do Restaurante é obrigatorio.")
    @NotNull(message = "O nome do Restaurante é obrigatorio.")
    public String getNome_restaurante() {
        return nome_restaurante;
    }

    public void setNome_restaurante(String nome_restaurante) {
        this.nome_restaurante = nome_restaurante;
    }

    @NotBlank(message = "O CNPJ é obrigatorio.")
    @NotNull(message = "O nome é obrigatório.")
    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    @NotBlank(message = "O nome é obrigatório.")
    @NotNull(message = "O nome é obrigatório.")
    public String getTelefone_Restaurante() {
        return Telefone_Restaurante;
    }

    public void setTelefone_Restaurante(String telefone_Restaurante) {
        Telefone_Restaurante = telefone_Restaurante;
    }


    @NotBlank(message = "O email é obrigatorio.")
    @NotNull(message = "O email é obrigatorio.")
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @NotBlank(message = "A senha é obrigatoria.")
    @NotNull(message = "A senha é obrigatoria.")
    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    @NotBlank(message = "A Confirmação de senha é obrigatoria.")
    @NotNull(message = "A Confirmação de senha é obrigatoria.")
    public String getConfirmarSenha() {
        return ConfirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        ConfirmarSenha = confirmarSenha;
    }

    @Override
    public String toString(){
        return "Restaurante[" + "Nome do Restaurante" + nome_restaurante + "CNPJ" + CNPJ + "Teleone" + Telefone_Restaurante + "Email" + Email + "Senha " + Senha + "Confirmação de Senha " + ConfirmarSenha + ']';
    }

}
