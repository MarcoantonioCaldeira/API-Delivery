package com.apidelivery.models.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ITEM")
public class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = 2921851934051192771L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM")
    private Long id;
    private String nomeItem;
    private String preco;
    private LocalDate dataCadastro = LocalDate.now();


    @ManyToOne
    private Restaurante restaurante;

    public Item(){

    }

    public Item(String nomeItem, String preco){
        this.nomeItem = nomeItem;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)

            return true;

        if (obj == null)

            return false;

        if (getClass() != obj.getClass())

            return false;

        Item other = (Item) obj;
        return Objects.equals(id, other.id);
    }
}
