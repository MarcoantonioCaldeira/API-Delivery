package com.apidelivery.models.data;

import com.apidelivery.models.model.EnderecoCliente;
import com.apidelivery.models.model.FormaPagamento;

public class ClienteResponse {
    private Long id;
    private FormaPagamento formaPagamento;
    private EnderecoCliente endereco;
    private String email;
    private String telefone;
    private String nome;
    private String senha;
    private String confirmarSenha;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }


    public EnderecoCliente getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoCliente endereco) {
        this.endereco = endereco;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String Senha) {
        this.senha = Senha;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmar_senha) {
        this.confirmarSenha = confirmar_senha;
    }

    @Override
    public String toString() {
        return "UserRequest [Email=" + email + ", Telefone=" + telefone + ", nome=" + nome + ", senha=" + senha + ", Confirmação de Senha=" + confirmarSenha + ", Forma de Pagamento=" + formaPagamento + ", Endereço=" + endereco + "]";
    }

}
