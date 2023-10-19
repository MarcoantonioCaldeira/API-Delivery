package com.apidelivery.models.model;


import com.apidelivery.models.model.EnderecoEntregador;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ENTREGADORES")
public class Entregador implements Serializable {

	private static final long serialVersionUID = 3307278768458796790L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_ENTREGADOR")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String nome;
	private String sobrenome;
	private String email;
	private String cpf;
	private String telefone;
	private String cnh;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "ID_ENDERECO_ENTREGADOR")
	private EnderecoEntregador endereco;
	private String senha;
	private String confirmarSenha;


	public Entregador(String nome, String sobrenome, String email, String cpf, String telefone, String cnh, EnderecoEntregador endereco, String senha, String confirmarSenha) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.cnh = cnh;
		this.endereco = endereco;
		this.senha = senha;
		this.confirmarSenha = confirmarSenha;
	}

	public Entregador() {

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

	 @Column(name = "CPF", length=30, nullable=false)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	 @Column(name = "TELEFONE", length=100, nullable=false)
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "CNH", length=100, nullable=false)
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public EnderecoEntregador getEndereco(){
		return endereco;
	}
	public void setEndereco(EnderecoEntregador endereco) {
		this.endereco = endereco;
	}


	@Column(name = "SENHA", length=100, nullable=false)
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name="CONFIRMAR_SENHA", length=100, nullable=false)
	public String getConfirmarSenha() {
		return confirmarSenha;
	}
	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		Entregador other = (Entregador) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString(){
		return "Entregador{" + ", nome='" + nome + '\'' + ", sobrenome='" + sobrenome + '\'' + "email: " + email + ", cpf='" + cpf + '\'' + ", telefone='" + telefone + '\'' + ", cnh='" + cnh + '\'' +  ", endereco=" + endereco +
		", senha=" + senha + ", Confirmação de Senha=" + confirmarSenha + '}';
	}

}
