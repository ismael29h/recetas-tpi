package com.tpi2024.cocina.dto.ingrediente;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Ingrediente sin ID", description = "Usado en la creación de recetas")
public record IngredienteDto(
                String nombre, String descripcion) {

}
