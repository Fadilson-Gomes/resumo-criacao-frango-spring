package fgs.ffgs.resumocriacaofrangospring.dto;

import jakarta.validation.constraints.NotBlank;

public record CriadorDto(@NotBlank String nomeCriador) {}
