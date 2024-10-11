package com.tpi2024.cocina.mapper.categoria;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tpi2024.cocina.domain.Categoria;
import com.tpi2024.cocina.dto.categoria.CategoriaDto;
import com.tpi2024.cocina.dto.categoria.CategoriaListDto;
import com.tpi2024.cocina.mapper.receta.RecetaMapper;

@Mapper(uses = { RecetaMapper.class })
public interface CategoriaMapper {
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaDto categoriaToCategoriaDto(Categoria categoria);

    Categoria categoriaDtoToCategoria(CategoriaDto categoriaDto);

    CategoriaListDto categoriaToCategoriaListDto(Categoria categoria);

    Categoria categoriaListDtoToCategoria(CategoriaListDto categoriaListDto);
}
