package com.apidelivery.models.data;

import com.apidelivery.models.model.EnderecoCliente;
import com.apidelivery.models.model.FormaPagamento;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteRequest {

    private String email;
    private String telefone;
    private String nome;
    private String senha;
    private String confirmarSenha;
    private FormaPagamento formaPagamento;
    private EnderecoCliente endereco;


    @Email(message = "e-mail inválido")
    @NotBlank(message = "e-mail obrigatório.")
    @NotNull(message = "e-mail obrigatório.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @NotBlank(message = "telefone obrigatorio.")
    @NotNull(message = "telefone é obrigatorio.")
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    @NotBlank(message = "nome é obrigatorio.")
    @NotNull(message = "nome é obrigatorio.")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    @NotBlank(message = "senha é obrigatória.")
    @NotNull(message = "senha é obrigatória.")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String Senha) {
        this.senha = Senha;
    }
    @NotBlank(message = "confirmação de senha é obrigatória.")
    @NotNull(message = "confirmação de senha é obrigatória.")
    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmar_senha) {
        this.confirmarSenha = confirmar_senha;
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

    @Override
    public String toString() {
        return "UserRequest [Email=" + email + ", Telefone=" + telefone + ", nome=" + nome + ", senha=" + senha + ", Confirmação de Senha=" + confirmarSenha + ", Forma de Pagamento=" + formaPagamento + ", Endereço=" + endereco + "]";
    }
}
