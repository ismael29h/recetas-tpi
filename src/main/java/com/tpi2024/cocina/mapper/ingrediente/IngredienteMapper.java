package com.tpi2024.cocina.mapper.ingrediente;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tpi2024.cocina.domain.Ingrediente;
import com.tpi2024.cocina.dto.ingrediente.IngredienteDto;
import com.tpi2024.cocina.dto.ingrediente.IngredienteGetDto;

@Mapper
public interface IngredienteMapper {
    IngredienteMapper INSTANCE = Mappers.getMapper(IngredienteMapper.class);

    IngredienteDto ingredienteToIngredienteDto(Ingrediente ingrediente);

    Ingrediente ingredienteDtoToIngrediente(IngredienteDto ingredienteDto);

    IngredienteGetDto ingredienteToIngredienteGetDto(Ingrediente ingrediente);

    Ingrediente ingredienteGetDtoToIngrediente(IngredienteGetDto ingredienteGetDto);

    List<IngredienteGetDto> ingredientesToIngredientesGetDtos(List<Ingrediente> ingredientes);
}
