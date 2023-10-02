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


    private String UF;
    private String Cidade;
    private String Bairro;
    private String numero_end;

    @Column(name = "UF", length=100)
    public String getUF() {
        return UF;
    }


    public void setUF(String UF) {
        this.UF = UF;
    }

    @Column(name = "CIDADE", length=100)
    public String getCidade() {
        return Cidade;
    }


    public void setCidade(String cidade) {
        Cidade = cidade;
    }


    @Column(name = "BAIRRO", length=100)
    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    @Column(name = "NUMERO_ENDERECO", length=100)
    public String getNumero_end() {
        return numero_end;
    }

    public void setNumero_end(String numero_end) {
        this.numero_end = numero_end;
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
