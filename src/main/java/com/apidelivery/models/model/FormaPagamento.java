package com.apidelivery.models.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "FORMA_PAGAMENTO")
public class FormaPagamento implements Serializable {
    @Serial
    private static final long serialVersionUID = -3807401246204416694L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID_PAGAMENTO")
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    private Integer tipoPagamento;
    private String num_cartao;
    private String nomeImpresso;
    private String validadeCartao;
    private String CvvCartao;
    private String Nome_Apelido;
    private String cpf_cnpj;

    public Integer getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(Integer tipoPagamento) {
        if(tipoPagamento != 1 && tipoPagamento != 2){
            throw new IllegalArgumentException("Valor de tipoPagamento inválido. Use 1 para Débito e 2 para Crédito.");
        }
        this.tipoPagamento = tipoPagamento;
    }


    public String getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(String num_cartao) {
        this.num_cartao = num_cartao;
    }


    public String getNomeImpresso() {
        return nomeImpresso;
    }

    public void setNomeImpresso(String nomeImpresso) {
        this.nomeImpresso = nomeImpresso;
    }


    public String getValidadeCartao() {
        return validadeCartao;
    }

    public void setValidadeCartao(String validadeCartao) {
        this.validadeCartao = validadeCartao;
    }


    public String getCvvCartao() {
        return CvvCartao;
    }

    public void setCvvCartao(String cvvCartao) {
        CvvCartao = cvvCartao;
    }


    public String getNome_Apelido() {
        return Nome_Apelido;
    }

    public void setNome_Apelido(String nome_Apelido) {
        Nome_Apelido = nome_Apelido;
    }


    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)

            return true;

        if (obj == null)

            return false;

        if (getClass() != obj.getClass())

            return false;

        FormaPagamento other = (FormaPagamento) obj;
        return Objects.equals(id, other.id);
    }


}
