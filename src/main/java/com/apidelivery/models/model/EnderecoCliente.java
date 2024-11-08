package com.apidelivery.models.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="TB_ENDERECO_CLIENTE")
public class EnderecoCliente implements Serializable {

    @Serial
    private static final long serialVersionUID = 3300710347277034767L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID_END_CLIENTE")
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

    @Column(name = "NUMERO_ENDERECO", length=100)
    public String getNumero_end() {
        return numero_end;
    }

    public void setNumero_end(String numero_end) {
        this.numero_end = numero_end;
    }

    @Column(name = "CEP", length=100)
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Column(name = "COMPLEMENTO", length=100)
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Column(name = "RUA", length=100)
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)

            return true;

        if (obj == null)

            return false;

        if (getClass() != obj.getClass())

            return false;

        EnderecoCliente other = (EnderecoCliente) obj;
        return Objects.equals(id, other.id);
    }
}
