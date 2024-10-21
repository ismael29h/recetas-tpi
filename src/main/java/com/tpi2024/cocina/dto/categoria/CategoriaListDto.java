package com.tpi2024.cocina.dto.categoria;

import java.util.List;

import com.tpi2024.cocina.dto.receta.RecetaListDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Lista de recetas", description = "Usado cuando el cliente lo solicita")
public record CategoriaListDto(
                List<RecetaListDto> recetas) {

}
