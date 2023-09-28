package com.apidelivery.models.model;

import com.apidelivery.models.pk.PrimaryKey;
//import com.apidelivery.models.model.EnderecoEntregador;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENTREGADORES")
public class Entregador extends PrimaryKey{


	private static final long serialVersionUID = -522379480005861691L;
	
	private String nome;
	private String sobrenome;
	private String email;
	private String cpf;
	private String telefone;
	private String cnh;
	private Integer TipoEntrega;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ENDERECO_ID")
	private EnderecoEntregador endereco;
	private String Senha;
	private String confirmarSenha;
	
	
	public Entregador(String nome, String sobrenome, String email, String cpf, String telefone, String cnh, Integer TipoEntrega, EnderecoEntregador endereco, String Senha, String confirmarSenha) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.cnh = cnh;
		this.TipoEntrega = TipoEntrega;
		this.endereco = endereco;
		this.Senha = Senha;
		this.confirmarSenha = confirmarSenha;
	}



	@Column(name = "NOME", length=100, nullable=false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "SOBRENOME", length=100, nullable=false)
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Column(name = "EMAIL", length=100, nullable=false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	 @Column(name = "CPF", length=11, nullable=false)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	 @Column(name = "TELEFONE")
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "CNH")
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	@Column(name = "TIPO_ENTREGA")
	public Integer getTipoEntrega() {
		return TipoEntrega;
	}
	public void setTipoEntrega(Integer tipoEntrega) {
		TipoEntrega = tipoEntrega;
	}

	@Column(name="ENDERECO", length=100, nullable=false)
	public EnderecoEntregador getEndereco(){
		return endereco;
	}
	public void setEndereco(EnderecoEntregador endereco) {
		this.endereco = endereco;
	}


	@Column(name = "SENHA", nullable = false)
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}

	@Column(name="CONFIRMAR_SENHA", length=100, nullable=false)
	public String getConfirmarSenha() {
		return confirmarSenha;
	}
	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}


	@Override
	public String toString(){
		return "Entregador{" + ", nome='" + nome + '\'' + ", sobrenome='" + sobrenome + '\'' + "email: " + email + ", cpf='" + cpf + '\'' + ", telefone='" + telefone + '\'' + ", cnh='" + cnh + '\'' + ", tipoEntrega=" + TipoEntrega + ", endereco=" + endereco +
		", senha=" + Senha + ", Confirmação de Senha=" + confirmarSenha + '}';
	}

}
