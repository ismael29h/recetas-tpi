package com.tpi2024.cocina.dto.error;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Error", description = "Esquema para indicar que existe un error")
public record ErrorDto(String error, String status) {

}
