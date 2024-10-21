package com.tpi2024.cocina.dto.paso;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tpi2024.cocina.dto.ingrediente.IngredienteGetDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Paso con ID", description = "Usado cuando el cliente lo solicita")
public record PasoGetDto(
                int id,
                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss") @Schema(type = "String", example = "12:30:00") LocalTime tiempo,
                List<IngredienteGetDto> ingredientes // id, nombre
) {

}
