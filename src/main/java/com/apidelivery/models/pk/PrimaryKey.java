package com.apidelivery.models.pk;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@MappedSuperclass
public class PrimaryKey implements Serializable{
	
	private static final long serialVersionUID = -5454450226405752569L;
	
	private Long id;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		PrimaryKey other = (PrimaryKey) obj;
		return Objects.equals(id, other.id);
	}
	
}
