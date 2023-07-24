package fgs.ffgs.resumocriacaofrangospring.dto;

import java.util.List;

public record VerCriadorDto(Short idCriador, String nomeCriador, List<VerPlantelSemCriadorDto> plantel) { }
