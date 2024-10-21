package com.tpi2024.cocina.dto.ingrediente;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Ingrediente con ID", description = "Usado cuando el cliente lo solicita")
public record IngredienteGetDto(
                int id, String nombre) {

}
