package com.apidelivery.models.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ItemMenuResponse {
    private Long id;
    private String nomeItem;
    private String preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    @Override
    public String toString(){
        return "Restaurante[" + ", Nome do Item='" + nomeItem  + ", Preço='" + preco + ']';
    }

}
