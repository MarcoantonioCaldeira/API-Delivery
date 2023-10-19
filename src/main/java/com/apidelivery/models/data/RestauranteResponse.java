package com.apidelivery.models.data;

import com.apidelivery.models.model.EnderecoRestaurante;


public class RestauranteResponse {

    private Long id;
    private String nome_proprietario;
    private String especialidade;
    private String foto_Restaurante;
    private String nome_restaurante;
    private String cnpj_cpf;
    private String telefone_Restaurante;
    private String email;
    private String descricao;
    private String senha;
    private String confirmarSenha;
    private EnderecoRestaurante endereco;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getNome_restaurante() {
        return nome_restaurante;
    }

    public void setNome_restaurante(String nome_restaurante) {
        this.nome_restaurante = nome_restaurante;
    }



    public String getCNPJ() {
        return cnpj_cpf;
    }

    public void setCNPJ(String cnpj_cpf) {
        this.cnpj_cpf = cnpj_cpf;
    }



    public String getTelefone_Restaurante() {
        return telefone_Restaurante;
    }

    public void setTelefone_Restaurante(String telefone_Restaurante) {
        this.telefone_Restaurante = telefone_Restaurante;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }



    public EnderecoRestaurante getRestaurante() {
        return endereco;
    }

    public void setRestaurante(EnderecoRestaurante endereco) {
        this.endereco = endereco;
    }



    public String getNome_proprietario() {
        return nome_proprietario;
    }

    public void setNome_proprietario(String nome_proprietario) {
        this.nome_proprietario = nome_proprietario;
    }



    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }



    public String getFoto_Restaurante() {
        return foto_Restaurante;
    }

    public void setFoto_Restaurante(String foto_Restaurante) {
        this.foto_Restaurante = foto_Restaurante;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return "Restaurante{" + ", Nome proprietario='" + nome_proprietario + '\'' + ", Especialidade='" + especialidade + '\'' + "Foto do Restaurante: " + foto_Restaurante + ", Nome do restaurante='" + nome_restaurante + '\'' + ", CNPJ_CPF='" + cnpj_cpf + '\'' + ", Telefone='" + telefone_Restaurante +
                '\'' + ", Email=" + email + '\'' + "Descricao=" + descricao + ", senha=" + senha + ", Confirmação de Senha=" + confirmarSenha + "Endereco " + endereco + '}';
    }
}
