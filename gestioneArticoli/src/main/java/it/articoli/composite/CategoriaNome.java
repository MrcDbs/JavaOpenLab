package it.articoli.composite;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CategoriaNome implements Serializable{

	private String nome;

	public CategoriaNome() {}
	
	public CategoriaNome(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof CategoriaNome) {
			CategoriaNome other = (CategoriaNome) obj;
			return Objects.equals(nome, other.nome);
		}
		return false;
	}
	
	
	@Column(name="nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
