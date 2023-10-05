package com.apidelivery.models.model;


import jakarta.persistence.*;


import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name="TB_CLIENTE")
public class Cliente implements Serializable{



	private static final long serialVersionUID = 6679001107878287172L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_CLIENTE")
	private Long id;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pagamento_id", referencedColumnName = "ID_PAGAMENTO")
	private FormaPagamento formaPagamento;

	
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


	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
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
	public boolean equals(Object obj) {
		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Cliente [nome=" + this.getNome() + ", Email=" + email + ", telefone=" + telefone + "senha=" + Senha + "Confirmação de Senha=" + confirmarSenha +"]";
	}
}
