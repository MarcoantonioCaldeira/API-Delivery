package com.apidelivery.models.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EnderecoEntregadorRequest {

    private String CEP;
    private String Cidade;
    private String Bairro;
    private String Rua;
    private String numero_casa;


    //@NotBlank(message = "O campo CEP é obrigatorio")
    //@NotNull(message = "O campo CEP é obrigatorio")
    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    //@NotBlank(message = "O campo cidade é obrigatorio")
    //@NotNull(message = "O campo cidade é obrigatorio")
    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    //@NotBlank(message = "O campo bairro é obrigatorio")
    //@NotNull(message = "O campo bairro é obrigatorio")
    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    //@NotBlank(message = "O campo Rua é obrigatorio")
    //@NotNull(message = "O campo Rua é obrigatorio")
    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    //@NotBlank(message = "O numero da casa é obrigatorio")
    //@NotNull(message = "O numero da casa é obrigatorio")
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
