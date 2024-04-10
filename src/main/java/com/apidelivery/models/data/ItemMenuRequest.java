package com.apidelivery.models.data;

import com.apidelivery.models.model.Restaurante;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ItemMenuRequest {
    private String nomeItem;
    private String preco;

    @NotBlank(message = "O nome do Item é obrigatorio.")
    @NotNull(message = "O nome do Item é obrigatorio.")
    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    @NotBlank(message = "O preço é obrigatorio.")
    @NotNull(message = "O preço do Item é obrigatorio.")
    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }


    @Override
    public String toString(){
        return "Restaurante[" + ", Nome do Item='" + nomeItem  + ", Especialidade='" + preco + ']';
    }

}
