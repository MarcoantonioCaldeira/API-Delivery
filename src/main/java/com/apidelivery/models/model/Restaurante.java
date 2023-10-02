package com.apidelivery.models.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import com.apidelivery.models.model.EnderecoRestaurante;

@Entity
@Table(name="TB_RESTAURANTE")
public class Restaurante implements Serializable{


    private static final long serialVersionUID = -429507710884450944L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_RESTAURANTE")
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =  id;
    }



    private String nome_restaurante;
    private String CNPJ;
    private String Telefone_Restaurante;
    private String email;

    private String Senha;

    private String ConfirmarSenha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RESTAURANTE_END_ID", referencedColumnName = "ID_END_RESTAURANTE")
    private EnderecoRestaurante endereco;


    public Restaurante(String nome_restaurante, String CNPJ, String Telefone_Restaurante){
        this.nome_restaurante = nome_restaurante;
        this.CNPJ = CNPJ;
        this.Telefone_Restaurante = Telefone_Restaurante;
    }

    public Restaurante(){

    }

    @Column(name="NOME_RESTAURANTE", length=100, nullable=false)
    public String getNome_restaurante() {
        return nome_restaurante;
    }
    public void setNome_restaurante(String nome_restaurante) {
        this.nome_restaurante = nome_restaurante;
    }


    @Column(name="NUMERO_CNPJ", length=100, nullable=false)
    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }


    @Column(name="TELEFONE", length=100, nullable=false)
    public String getTelefone_Restaurante() {
        return Telefone_Restaurante;
    }
    public void setTelefone_Restaurante(String telefone_Restaurante) {
        Telefone_Restaurante = telefone_Restaurante;
    }


    public EnderecoRestaurante getEndereco() {
        return endereco;
    }
    public void setEndereco(EnderecoRestaurante endereco) {
        this.endereco = endereco;
    }

    @Column(name="EMAIL", length=100, nullable=false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="SENHA", length=100, nullable=false)
    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
    @Column(name="CONFIRMAR_SENHA", length=100, nullable=false)
    public String getConfirmarSenha() {
        return ConfirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        ConfirmarSenha = confirmarSenha;
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
    public String toString(){
        return "Restaurante{" + "Nome do Restaurante" + nome_restaurante + "CNPJ" + CNPJ + "Teleone" + Telefone_Restaurante + '}';
    }

}
