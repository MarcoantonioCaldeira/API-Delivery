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
    private String cvvCartao;
    private String nome_Apelido;
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


    @Column(name = "NUMERO_CARTAO", length=100)
    public String getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(String num_cartao) {
        this.num_cartao = num_cartao;
    }

    @Column(name = "NOME_IMPRESSO", length=100)
    public String getNomeImpresso() {
        return nomeImpresso;
    }

    public void setNomeImpresso(String nomeImpresso) {
        this.nomeImpresso = nomeImpresso;
    }

    @Column(name = "VALIDADE", length=100)
    public String getValidadeCartao() {
        return validadeCartao;
    }

    public void setValidadeCartao(String validadeCartao) {
        this.validadeCartao = validadeCartao;
    }

    @Column(name = "CVV", length=100)
    public String getCvvCartao() {
        return cvvCartao;
    }

    public void setCvvCartao(String cvvCartao) {
        this.cvvCartao = cvvCartao;
    }

    @Column(name = "NOME_APELIDO", length=100)
    public String getNome_Apelido() {
        return nome_Apelido;
    }

    public void setNome_Apelido(String nome_Apelido) {
        this.nome_Apelido = nome_Apelido;
    }

    @Column(name = "CPF_CNPJ", length=100)
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

    @Override
    public String toString(){
        return "Forma de Pagamento [Tipo=" + tipoPagamento + ", Numero do Cartão=" + num_cartao + ", Nome Impresso=" + nomeImpresso + "CVV="  + cvvCartao + "Validade=" + validadeCartao + "Nome Apelido=" + nome_Apelido + "CPF_CNPJ=" + cpf_cnpj +"]";
    }


}
