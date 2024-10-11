package com.tpi2024.cocina.dto.categoria;

import java.util.List;

import com.tpi2024.cocina.dto.receta.RecetaListDto;

public record CategoriaListDto(
        List<RecetaListDto> recetas) {

}
