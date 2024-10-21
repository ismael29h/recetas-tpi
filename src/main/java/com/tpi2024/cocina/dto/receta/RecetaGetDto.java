package com.tpi2024.cocina.dto.receta;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tpi2024.cocina.domain.enums.DificultadEnum;
import com.tpi2024.cocina.dto.categoria.CategoriaDto;
import com.tpi2024.cocina.dto.paso.PasoGetDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Receta con ID", description = "Usada cuando el cliente lo solicita")
public record RecetaGetDto(
                int id,
                String nombre,
                String descripcion,
                @JsonFormat(shape = JsonFormat.Shape.STRING) DificultadEnum dificultad,
                CategoriaDto categoria, // id,nombre
                List<PasoGetDto> pasos // id,tiempo,ingredientes
) {

}
