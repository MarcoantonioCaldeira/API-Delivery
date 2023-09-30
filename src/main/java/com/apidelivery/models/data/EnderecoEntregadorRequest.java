package com.apidelivery.models.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EnderecoEntregadorRequest {

    private Integer CEP;
    private String Cidade;
    private String Bairro;
    private String Rua;
    private String num_casa;


    @NotBlank(message = "O campo CEP é obrigatorio")
    @NotNull(message = "O campo CEP é obrigatorio")
    public Integer getCEP() {
        return CEP;
    }

    public void setCEP(Integer CEP) {
        this.CEP = CEP;
    }

    @NotBlank(message = "O campo cidade é obrigatorio")
    @NotNull(message = "O campo cidade é obrigatorio")
    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    @NotBlank(message = "O campo bairro é obrigatorio")
    @NotNull(message = "O campo bairro é obrigatorio")
    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    @NotBlank(message = "O campo Rua é obrigatorio")
    @NotNull(message = "O campo Rua é obrigatorio")
    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    @NotBlank(message = "O numero da casa é obrigatorio")
    @NotNull(message = "O numero da casa é obrigatório.")
    public String getNum_casa() {
        return num_casa;
    }

    public void setNum_casa(String num_casa) {
        this.num_casa = num_casa;
    }

}
