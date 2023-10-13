package com.apidelivery.models.data;

public class EnderecoRestauranteResponse {

    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero_end;
    private String complemento;

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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString(){
        return "EntregadorRequest [Estado=" + uf + ", Cidade=" + cidade + ", Bairro="+ bairro + ", Numero ="+ numero_end + "Rua" + rua + "CEP" + cep + "Complemento " + complemento + "]";
    }

}
