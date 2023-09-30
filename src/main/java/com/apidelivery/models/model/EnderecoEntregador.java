package com.apidelivery.models.model;

import com.apidelivery.models.pk.PrimaryKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ENDERECO_ENTREGADOR")
public class EnderecoEntregador extends PrimaryKey{

	private Integer CEP;
	private String Cidade;
	private String Bairro;
	private String Rua;
	private String numero_casa;
	
	
	public EnderecoEntregador(Integer CEP, String Cidade, String Bairro, String Rua, String numero_casa) {
		this.CEP = CEP;
		this.Cidade = Cidade;
		this.Bairro = Bairro;
		this.Rua = Rua;
		this.numero_casa = numero_casa;
	}

	public EnderecoEntregador() {

	}

	@Column(name = "CEP", length=100, nullable=false)
	public Integer getCEP() {
		return CEP;
	}
	public void setCEP(Integer CEP) {
		CEP = CEP;
	}


	@Column(name = "CIDADE", length=100, nullable=false)
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}


	@Column(name = "BAIRRO", length=100, nullable=false)
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}


	@Column(name = "RUA", length=100, nullable=false)
	public String getRua() {
		return Rua;
	}
	public void setRua(String rua) {
		Rua = rua;
	}


	@Column(name = "NUM_CASA", length=5, nullable=false)
	public String getNumero_casa() {
		return numero_casa;
	}
	public void setNumero_casa(String numero_casa) {
		this.numero_casa = numero_casa;
	}

}
