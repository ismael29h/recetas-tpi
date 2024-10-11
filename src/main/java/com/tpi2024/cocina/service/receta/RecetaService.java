package com.tpi2024.cocina.service.receta;

import com.tpi2024.cocina.dto.categoria.CategoriaListDto;
import com.tpi2024.cocina.dto.receta.RecetaDto;
import com.tpi2024.cocina.dto.receta.RecetaGetDto;

public interface RecetaService {
    public RecetaDto createReceta(RecetaDto recetaCreateDto);

    public RecetaGetDto getRecetaGetDtoById(int id);

    public CategoriaListDto getAllRecetaByCategoriaId(int id);
}
