package com.tpi2024.cocina.dto.paso;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tpi2024.cocina.dto.ingrediente.IngredienteGetDto;

public record PasoGetDto(
        int id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss") LocalTime tiempo,
        List<IngredienteGetDto> ingredientes // id, nombre
) {

}
