package fgs.ffgs.resumocriacaofrangospring.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Criador_s1d")
public class Criador implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_criador")
	private Short idCriador;
	
	@Column(nullable = false, unique = true)
	private String nomeCriador;
	
	@OneToMany(mappedBy="criador", cascade = CascadeType.ALL)
	private List<Plantel> plantel;

	public Criador() {}

	public Criador(String nomeCriador, List<Plantel> plantel) {
		this.nomeCriador = nomeCriador;
		this.plantel = plantel;
	}

	public Criador(String nomeCriador) {
		this.nomeCriador = nomeCriador;
	}

	public Short getIdCriador() {
		return idCriador;
	}

	protected void setIdCriador(Short idCriador) {
		this.idCriador = idCriador;
	}

	public String getNomeCriador() {
		return nomeCriador;
	}

	public void setNomeCriador(String nomeCriador) {
		this.nomeCriador = nomeCriador;
	}

	public List<Plantel> getPlantel() {
		return plantel;
	}

	public void setPlantel(List<Plantel> plantel) {
		this.plantel = plantel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCriador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criador other = (Criador) obj;
		return idCriador == other.idCriador;
	}
	
	
	
}
