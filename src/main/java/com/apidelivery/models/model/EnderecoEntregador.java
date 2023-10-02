package com.apidelivery.models.model;

import com.apidelivery.models.pk.PrimaryKey;
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



	private String CEP;
	private String Cidade;
	private String Bairro;
	private String Rua;
	private String numero_casa;
	
	
	public EnderecoEntregador(String CEP, String Cidade, String Bairro, String Rua, String numero_casa) {
		this.CEP = CEP;
		this.Cidade = Cidade;
		this.Bairro = Bairro;
		this.Rua = Rua;
		this.numero_casa = numero_casa;
	}

	public EnderecoEntregador() {

	}

	@Column(name = "CEP", length=100)
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String CEP) {
		this.CEP = CEP;
	}


	@Column(name = "CIDADE", length=100)
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}


	@Column(name = "BAIRRO", length=100)
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}


	@Column(name = "RUA", length=100)
	public String getRua() {
		return Rua;
	}
	public void setRua(String rua) {
		Rua = rua;
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
