package com.apidelivery.models.data;

public class EnderecoRestauranteResponse {

    private String UF;
    private String Cidade;
    private String Bairro;
    private String numero_end;

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
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

    public String getNumero_end() {
        return numero_end;
    }

    public void setNumero_end(String numero_end) {
        this.numero_end = numero_end;
    }

    @Override
    public String toString(){
        return "EntregadorRequest [Estado=" + UF + ", Cidade=" + Cidade + ", Bairro="+ Bairro + ", Numero ="+ numero_end + "]";
    }
}
