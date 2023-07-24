package fgs.ffgs.resumocriacaofrangospring.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record PlantelDto(LocalDateTime dataChegadaPinto, 
										
										@NotNull float kgTotal,
										
										float kgTotalDeUm,
										
										@NotNull float dispesaTotal,
										
										float lucroSoComDeUm,
										
										@NotNull float lucroSemDispesa,
	
										@NotNull float deZE,
	
										@NotNull float totalApurado,
	
										@NotNull Short idCriador) {}
