package com.apidelivery.models.data;

import com.apidelivery.models.model.EnderecoCliente;
import com.apidelivery.models.model.EnderecoRestaurante;
import com.apidelivery.models.model.FormaPagamento;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteRequest {

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


    @Email(message = "email inválido")
    @NotBlank(message = "O email é obrigatório.")
    @NotNull(message = "O email é obrigatório.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @NotBlank(message = "telefone é obrigatorio.")
    @NotNull(message = "telefone é obrigatorio.")
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    @NotBlank(message = "O nome do Cliente é obrigatorio.")
    @NotNull(message = "O nome do Cliente é obrigatorio.")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    @NotBlank(message = "A senha é obrigatória.")
    @NotNull(message = "A senha é obrigatória.")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String Senha) {
        this.senha = Senha;
    }
    @NotBlank(message = "A confirmação de senha é obrigatória.")
    @NotNull(message = "A confirmação de senha é obrigatória.")
    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmar_senha) {
        this.confirmarSenha = confirmar_senha;
    }



    @Override
    public String toString() {
        return "UserRequest [id=" + id + ", Forma de pagamento " + formaPagamento + " + Nome=" + nome + ", Telefone="+ telefone +", email=" + email + ", Senha=" + senha
                + ", Confirmação de Senha=" + confirmarSenha + "Endereço " + endereco + "]";
    }

}
