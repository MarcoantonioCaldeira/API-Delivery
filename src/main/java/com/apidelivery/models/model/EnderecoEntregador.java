package com.apidelivery.models.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_ENDERECO_ENTREGADOR")
public class EnderecoEntregador implements Serializable {



	private static final long serialVersionUID = -5028565755605395463L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_ENDERECO_ENTREGADOR")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String cep;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero_casa;
	
	
	public EnderecoEntregador(String cep, String cidade, String bairro, String rua, String numero_casa) {
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero_casa = numero_casa;
	}

	public EnderecoEntregador() {

	}

	@Column(name = "CEP", length=100)
	public String getCEP() {
		return cep;
	}
	public void setCEP(String cep) {
		this.cep = cep;
	}


	@Column(name = "CIDADE", length=100)
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	@Column(name = "BAIRRO", length=100)
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	@Column(name = "RUA", length=100)
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}


	@Column(name = "NUM_CASA", length=5)
	public String getNumero_casa() {
		return numero_casa;
	}
	public void setNumero_casa(String numero_casa) {
		this.numero_casa = numero_casa;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		EnderecoEntregador other = (EnderecoEntregador) obj;
		return Objects.equals(id, other.id);
	}

}
