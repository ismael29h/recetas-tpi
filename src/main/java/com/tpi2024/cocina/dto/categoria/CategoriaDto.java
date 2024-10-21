package com.tpi2024.cocina.dto.categoria;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Categoria", description = "Usado al crear recetas")
public record CategoriaDto(
                int id, String nombre) {

}
