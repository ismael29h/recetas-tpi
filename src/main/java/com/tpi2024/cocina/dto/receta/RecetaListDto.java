package com.tpi2024.cocina.dto.receta;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tpi2024.cocina.domain.enums.DificultadEnum;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Lista de recetas", description = "Usada cuando se solicita una lista de recetas")
public record RecetaListDto(
                int id,
                String nombre,
                @JsonFormat(shape = JsonFormat.Shape.STRING) DificultadEnum dificultad,
                String descripcion,
                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss") @Schema(type = "String", example = "12:30:00") LocalTime tiempoTotal) {

}
