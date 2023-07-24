package fgs.ffgs.resumocriacaofrangospring.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Plantel_s1d")
public class Plantel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_plantel")
	private Long idPlantel;
	
	@Column(nullable = false)
	private LocalDateTime dataDeRigitro;
	
	@Column(nullable = true)
	private LocalDateTime dataChegadaPinto;
	
	@Column(nullable = false)
	private float kgTotal;
	
	@Column(nullable = false)
	private float kgTotalDeUm;
	
	@Column(nullable = false)
	private float dispesaTotal;
	
	@Column(nullable = false)
	private float lucroSoComDeUm;
	
	@Column(nullable = false)
	private float lucroSemDispesa;
	
	@Column(nullable = false)
	private float deZE;
	
	@Column(nullable = false)
	private float totalApurado;
	
	@ManyToOne
	@JoinColumn(name = "id_criador",  nullable = false)
	private Criador criador;

	public Plantel() {
		this.dataDeRigitro = LocalDateTime.now();
	}

	public Plantel( LocalDateTime dataChegadaPinto, float kgTotal, float kgTotalDeUm,
			float dispesaTotal, float lucroSoComDeUm, float lucroSemDispesa, float deZE, float totalApurado,
			Criador criador) {
		super();
		this.dataDeRigitro = LocalDateTime.now();
		this.dataChegadaPinto = dataChegadaPinto;
		this.kgTotal = kgTotal;
		this.kgTotalDeUm = kgTotalDeUm;
		this.dispesaTotal = dispesaTotal;
		this.lucroSoComDeUm = lucroSoComDeUm;
		this.lucroSemDispesa = lucroSemDispesa;
		this.deZE = deZE;
		this.totalApurado = totalApurado;
		this.criador = criador;
	}



	public Long getIdPlantel() {
		return idPlantel;
	}

	protected void setIdPlantel(Long idPlantel) {
		this.idPlantel = idPlantel;
	}

	public LocalDateTime getDataDeRigitro() {
		return dataDeRigitro;
	}
	/*
	public void setDataDeRigitro(LocalDateTime dataDeRigitro) {
		this.dataDeRigitro = dataDeRigitro;
	}*/

	public LocalDateTime getDataChegadaPinto() {
		return dataChegadaPinto;
	}

	public void setDataChegadaPinto(LocalDateTime dataChegadaPinto) {
		this.dataChegadaPinto = dataChegadaPinto;
	}

	public float getKgTotal() {
		return kgTotal;
	}

	public void setKgTotal(float kgTotal) {
		this.kgTotal = kgTotal;
	}

	public float getKgTotalDeUm() {
		return kgTotalDeUm;
	}

	public void setKgTotalDeUm(float kgTotalDeUm) {
		this.kgTotalDeUm = kgTotalDeUm;
	}

	public float getDispesaTotal() {
		return dispesaTotal;
	}

	public void setDispesaTotal(float dispesaTotal) {
		this.dispesaTotal = dispesaTotal;
	}

	public float getLucroSoComDeUm() {
		return lucroSoComDeUm;
	}

	public void setLucroSoComDeUm(float lucroSoComDeUm) {
		this.lucroSoComDeUm = lucroSoComDeUm;
	}

	public float getLucroSemDispesa() {
		return lucroSemDispesa;
	}

	public void setLucroSemDispesa(float lucroSemDispesa) {
		this.lucroSemDispesa = lucroSemDispesa;
	}

	public float getDeZE() {
		return deZE;
	}

	public void setDeZE(float deZE) {
		this.deZE = deZE;
	}

	public float getTotalApurado() {
		return totalApurado;
	}

	public void setTotalApurado(float totalApurado) {
		this.totalApurado = totalApurado;
	}

	public Criador getCriador() {
		return criador;
	}

	public void setCriador(Criador criador) {
		this.criador = criador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(criador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plantel other = (Plantel) obj;
		return Objects.equals(criador, other.criador);
	}
	
	
}
