package com.apidelivery.models.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EnderecoEntregadorRequest {

    private String CEP;
    private String Cidade;
    private String Bairro;
    private String Rua;
    private String numero_casa;


    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }


    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }


    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }


    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }


    public String getNum_casa() {
        return numero_casa;
    }

    public void setNum_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }

    @Override
    public String toString(){
        return "EntregadorRequest [CEP=" + CEP + ", Cidade=" + Cidade + ", Bairro="+ Bairro + ", Rua="+ Rua +",  Numero da casa="+ numero_casa + "]";
    }
}
