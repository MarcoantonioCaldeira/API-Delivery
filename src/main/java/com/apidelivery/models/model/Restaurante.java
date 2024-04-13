package com.apidelivery.models.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="TB_RESTAURANTE")
public class Restaurante implements Serializable {

    private static final long serialVersionUID = -429507710884450944L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RESTAURANTE")
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    private String nome_proprietario;
    private String especialidade;
    private String foto_Restaurante;
    private String nome_restaurante;
    private String cpf_cnpj;
    private String telefone_Restaurante;
    private String email;
    private String descricao;
    private String senha;
    private String confirmarSenha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurante_end_id", referencedColumnName = "ID_END_RESTAURANTE")
    private EnderecoRestaurante endereco;

    @OneToMany(mappedBy = "restaurante", fetch = FetchType.LAZY)
    private List<ItemMenuRestaurante> itemMenuRestaurante;

    public Restaurante(String nome_proprietario, String especialidade, String foto_Restaurante, String nome_restaurante, String cpf_cnpj, String telefone_Restaurante, String email, String descricao, String senha, String confirmarSenha, EnderecoRestaurante endereco, List<ItemMenuRestaurante> itemMenuRestaurante) {
        this.nome_proprietario = nome_proprietario;
        this.especialidade = especialidade;
        this.foto_Restaurante = foto_Restaurante;
        this.nome_restaurante = nome_restaurante;
        this.cpf_cnpj = cpf_cnpj;
        this.telefone_Restaurante = telefone_Restaurante;
        this.email = email;
        this.descricao = descricao;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
        this.endereco = endereco;
        this.itemMenuRestaurante = itemMenuRestaurante;
    }

    public Restaurante() {
        itemMenuRestaurante = new ArrayList<>();
    }

    @Column(name = "NOME_RESTAURANTE", length = 100, nullable = false)
    public String getNome_restaurante() {
        return nome_restaurante;
    }

    public void setNome_restaurante(String nome_restaurante) {
        this.nome_restaurante = nome_restaurante;
    }


    @Column(name = "CPF_CNPJ", length=100)
    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }


    @Column(name = "TELEFONE", length = 100, nullable = false)
    public String getTelefone_Restaurante() {
        return telefone_Restaurante;
    }

    public void setTelefone_Restaurante(String telefone_Restaurante) {
        this.telefone_Restaurante = telefone_Restaurante;
    }


    public EnderecoRestaurante getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoRestaurante endereco) {
        this.endereco = endereco;
    }


    @Column(name = "EMAIL", length = 100, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name = "SENHA", length = 100, nullable = false)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Column(name = "CONFIRMAR_SENHA", length = 100, nullable = false)
    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    @Column(name = "NOME_PROPRIETARIO", length = 100, nullable = false)
    public String getNome_proprietario() {
        return nome_proprietario;
    }

    public void setNome_proprietario(String nome_proprietario) {
        this.nome_proprietario = nome_proprietario;
    }

    @Column(name = "ESPECIALIDADE", length = 100, nullable = false)
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Column(name = "FOTO_RESTAURANTE", length = 100)
    public String getFoto_Restaurante() {
        return foto_Restaurante;
    }

    public void setFoto_Restaurante(String foto_Restaurante) {
        this.foto_Restaurante = foto_Restaurante;
    }


    @Column(name = "DESCRICAO", length = 100, nullable = false)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ItemMenuRestaurante> getItemMenuRestaurante() {
        return itemMenuRestaurante;
    }

    public void setItemMenuRestaurante(List<ItemMenuRestaurante> itemMenuRestaurante) {
        this.itemMenuRestaurante = itemMenuRestaurante;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)

            return true;

        if (obj == null)

            return false;

        if (getClass() != obj.getClass())

            return false;

        Restaurante other = (Restaurante) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Restaurante [Nome do Proprietario=" + nome_proprietario + ", Especialidade=" + especialidade + ", Foto=" + foto_Restaurante + "Nome do Restaurante=" + nome_restaurante + "CPF_CNPJ=" + cpf_cnpj + "Telefone " + telefone_Restaurante + "Email" + email + "Descrição" + descricao + "Senha" + senha + "Confirmar Senha" + confirmarSenha + "Endereco " + endereco + "Itens do Menu" + itemMenuRestaurante + "]";
    }

}

