package com.apidelivery.models.data;

public class RestauranteResponse {

    private String nome_restaurante;


    public String getNome_restaurante() {
        return nome_restaurante;
    }

    public void setNome_restaurante(String nome_restaurante) {
        this.nome_restaurante = nome_restaurante;
    }

    @Override
    public String toString(){
        return "Restaurante[" + "Nome do Restaurante" + nome_restaurante +']';
    }
}
