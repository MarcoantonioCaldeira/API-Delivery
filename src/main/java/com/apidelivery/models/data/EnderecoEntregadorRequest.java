package com.apidelivery.models.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EnderecoEntregadorRequest {

    private String cep;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero_casa;


    public String getCEP() {
        return cep;
    }

    public void setCEP(String cep) {
        this.cep = cep;
    }


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }


    public String getNum_casa() {
        return numero_casa;
    }

    public void setNum_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }

    @Override
    public String toString(){
        return "EntregadorRequest [CEP=" + cep + ", Cidade=" + cidade + ", Bairro="+ bairro + ", Rua="+ rua +",  Numero da casa="+ numero_casa + "]";
    }
}
