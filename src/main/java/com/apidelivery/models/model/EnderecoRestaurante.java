package com.apidelivery.models.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="TB_ENDERECO_RESTAURANTE")
public class EnderecoRestaurante implements Serializable {


    @Serial
    private static final long serialVersionUID = -6923179675619975770L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID_END_RESTAURANTE")
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero_end;
    private String complemento;


    public EnderecoRestaurante(String cep, String uf, String cidade, String bairro, String rua, String numero_end, String complemento){
        this.cep = cep;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero_end = numero_end;
        this.complemento = complemento;
    }


    public EnderecoRestaurante(){

    }

    @Column(name = "CEP", length=100)
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Column(name = "UF", length=100)
    public String getUF() {
        return uf;
    }


    public void setUF(String uf) {
        this.uf = uf;
    }

    @Column(name = "CIDADE", length=100)
    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    @Column(name = "BAIRRO", length=100)
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Column(name = "RUA", length=100)
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Column(name = "NUMERO_ENDERECO", length=100)
    public String getNumero_end() {
        return numero_end;
    }

    public void setNumero_end(String numero_end) {
        this.numero_end = numero_end;
    }


    @Column(name = "COMPLEMENTO", length=100)
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)

            return true;

        if (obj == null)

            return false;

        if (getClass() != obj.getClass())

            return false;

        EnderecoRestaurante other = (EnderecoRestaurante) obj;
        return Objects.equals(id, other.id);
    }

}
