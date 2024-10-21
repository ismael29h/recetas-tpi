package com.tpi2024.cocina.dto.paso;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tpi2024.cocina.dto.ingrediente.IngredienteDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Paso de una receta", description = "Usado en la creación de recetas")
public record PasoDto(
        String descripcion,
        // Deserializar tiempo
        // @JsonProperty
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss") @Schema(type = "String", example = "12:30:00") LocalTime tiempo,
        boolean esOpcional,
        List<IngredienteDto> ingredientes) {

}
