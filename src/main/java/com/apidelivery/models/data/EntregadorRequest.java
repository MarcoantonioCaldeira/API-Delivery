package com.apidelivery.models.data;

import com.apidelivery.models.model.EnderecoEntregador;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EntregadorRequest {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    private String cnh;
    private String telefone;
    private Long tipoEntrega;
    private EnderecoEntregadorRequest endereco;
    private String senha;
    private String confirmarSenha;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank(message = "O nome é obrigatório.")
    @NotNull(message = "O nome é obrigatório.")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //@Email(message = "sobrenome inválido")
    @NotBlank(message = "O sobrenome é obrigatório.")
    @NotNull(message = "O sobrenome é obrigatório.")
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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



    @NotBlank(message = "CPF obrigatorio")
    @NotNull(message = "CPF obrigatorio")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @NotBlank(message = "CNH obrigatoria")
    @NotNull(message = "CNH obrigatoria")
    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    @NotBlank(message = "O telefone é obrigatorio.")
    @NotNull(message = "O telefone é obrigatorio.")
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    @NotNull(message = "Escolha o tipo de Entrega.")
    public Long getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(Long tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }


    @NotBlank(message = "A senha é obrigatória.")
    @NotNull(message = "A senha é obrigatória.")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @NotBlank(message = "A confirmação de senha é obrigatória.")
    @NotNull(message = "A confirmação de senha é obrigatória.")
    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    @NotBlank(message = "O endereco é obrigatorio")
    @NotNull(message = "O endereco é obrigatorio")
    public EnderecoEntregadorRequest getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntregadorRequest endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString(){
        return "EntregadorRequest [id=" + id + ", Nome=" + nome + ", Sobrenome="+ sobrenome + ", CPF="+ cpf +",  CNH="+ cnh + ", Telefone="+ telefone +", Tipo de Entrega  = "+ tipoEntrega + ",email=" + email +  "Endereco=" + endereco +
                "Senha=" + senha + ", Confirmação de Senha=" + confirmarSenha + "]";
    }

}
