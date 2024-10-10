package com.tpi2024.cocina.mapper.ingrediente;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tpi2024.cocina.domain.Ingrediente;
import com.tpi2024.cocina.dto.ingrediente.IngredienteDto;

@Mapper
public interface IngredienteMapper {
    IngredienteMapper INSTANCE = Mappers.getMapper(IngredienteMapper.class);

    IngredienteDto ingredienteToIngredienteDto(Ingrediente ingrediente);

    Ingrediente ingredienteDtoToIngrediente(IngredienteDto ingredienteDto);
}
