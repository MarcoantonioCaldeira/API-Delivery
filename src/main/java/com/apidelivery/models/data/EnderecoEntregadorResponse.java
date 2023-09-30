package com.apidelivery.models.data;

public class EnderecoEntregadorResponse {

    private String Cidade;
    private String Bairro;
    private String Rua;
    private String num_casa;


    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public String getNum_casa() {
        return num_casa;
    }

    public void setNum_casa(String num_casa) {
        this.num_casa = num_casa;
    }

    @Override
    public String toString() {
        return "EnderecoClienteResponse [Cidade = " + Cidade  + "Bairro = " + Bairro + ", Rua = " + Rua + ", Numero=" + num_casa + "]";
    }

}
