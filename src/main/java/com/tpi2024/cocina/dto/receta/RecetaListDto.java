package com.tpi2024.cocina.dto.receta;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tpi2024.cocina.domain.enums.DificultadEnum;

public record RecetaListDto(
        int id,
        String nombre,
        @JsonFormat(shape = JsonFormat.Shape.STRING) DificultadEnum dificultad,
        String descripcion,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss") LocalTime tiempoTotal) {

}
