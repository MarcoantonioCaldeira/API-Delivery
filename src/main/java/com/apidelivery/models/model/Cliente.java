package com.apidelivery.models.model;

import com.apidelivery.models.pk.PrimaryKey;

import jakarta.persistence.*;



@Entity
@Table(name="TB_CLIENTE")
public class Cliente extends PrimaryKey{
	
	private static final long serialVersionUID = 3771197349299941491L;
	
	private String email;

	private String telefone;
	
	private String nome;
	
	private String Senha;

	private String confirmarSenha;



	public Cliente(String email, String telefone, String nome, String Senha, String confirmarSenha) {
		this.email = email;
		this.telefone = telefone;
		this.nome = nome;
		this.Senha = Senha;
		this.confirmarSenha = confirmarSenha;
	}

	public Cliente() {

	}


	@Column(name="USERNAME", length=100, nullable=false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Column(name="EMAIL", length=100, nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="TELEFONE", length=100, nullable=false)
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	@Column(name="SENHA", length=100, nullable=false)
	public String getSenha() {
		return Senha;
	}


	public void setSenha(String Senha) {
		this.Senha = Senha;
	}

	@Column(name="CONFIRMAR_SENHA", length=100, nullable=false)
	public String getConfirmarSenha() {
		return confirmarSenha;
	}


	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	
	
	@Override
	public String toString() {
		return "Cliente [nome=" + this.getNome() + ", Email=" + email + ", telefone=" + telefone + "senha=" + Senha + "Confirmação de Senha=" + confirmarSenha +"]";
	}
}
