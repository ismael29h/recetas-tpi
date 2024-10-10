package com.tpi2024.cocina.dto.paso;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tpi2024.cocina.dto.ingrediente.IngredienteDto;

public record PasoDto(
                String descripcion,
                // Deserializar tiempo
                // @JsonProperty
                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss") LocalTime tiempo,
                boolean esOpcional,
                List<IngredienteDto> ingredientes) {

}
