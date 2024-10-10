package com.tpi2024.cocina.mapper.receta;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tpi2024.cocina.domain.Receta;
import com.tpi2024.cocina.dto.receta.RecetaDto;
import com.tpi2024.cocina.mapper.paso.PasoMapper;

@Mapper(uses = { PasoMapper.class }) //agrega mapper de paso
public interface RecetaMapper {
    RecetaMapper INSTANCE = Mappers.getMapper(RecetaMapper.class);

    RecetaDto recetaToRecetaDto(Receta receta);

    Receta recetaDtoToReceta(RecetaDto recetaDto);
}
