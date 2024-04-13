package com.apidelivery.models.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ITEM_MENU_RESTAURANTE")
public class ItemMenuRestaurante implements Serializable {
    @Serial
    private static final long serialVersionUID = 2921851934051192771L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ITEM_MENU")
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String nomeItem;
    private String preco;
    @ManyToOne
    @JoinColumn(name="ID_RESTAURANTE")
    @JsonBackReference
    private Restaurante restaurante;

    @Column(name="NOME_ITEM", length=100, nullable=false)
    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }
    @Column(name="PRECO", length=100, nullable=false)
    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }


    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)

            return true;

        if (obj == null)

            return false;

        if (getClass() != obj.getClass())

            return false;

        ItemMenuRestaurante other = (ItemMenuRestaurante) obj;
        return Objects.equals(id, other.id);
    }

}
