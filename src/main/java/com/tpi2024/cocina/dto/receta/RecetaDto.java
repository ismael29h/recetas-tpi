package com.tpi2024.cocina.dto.receta;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tpi2024.cocina.domain.enums.DificultadEnum;
import com.tpi2024.cocina.dto.categoria.CategoriaDto;
import com.tpi2024.cocina.dto.paso.PasoDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Receta sin ID", description = "Usada para crear recetas")
public record RecetaDto(
                String nombre,
                String descripcion,
                @JsonFormat(shape = JsonFormat.Shape.STRING) DificultadEnum dificultad,
                CategoriaDto categoria,
                List<PasoDto> pasos

) {

}
