package com.apidelivery.models.data;

public class EnderecoRestauranteResponse {

    private String uf;
    private String cidade;
    private String bairro;
    private String numero_end;

    public String getUF() {
        return uf;
    }

    public void setUF(String UF) {
        this.uf = uf;
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

    public String getNumero_end() {
        return numero_end;
    }

    public void setNumero_end(String numero_end) {
        this.numero_end = numero_end;
    }

    @Override
    public String toString(){
        return "EntregadorRequest [Estado=" + uf + ", Cidade=" + cidade + ", Bairro="+ bairro + ", Numero ="+ numero_end + "]";
    }
}
