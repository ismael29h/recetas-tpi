package com.tpi2024.cocina.mapper.paso;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tpi2024.cocina.domain.Paso;
import com.tpi2024.cocina.dto.paso.PasoDto;
import com.tpi2024.cocina.mapper.ingrediente.IngredienteMapper;

@Mapper(uses = { IngredienteMapper.class }) // incluye el mapper de ingrediente
public interface PasoMapper {
    PasoMapper INSTANCE = Mappers.getMapper(PasoMapper.class);

    PasoDto pasoToPasoDto(Paso paso);

    Paso pasoDtoToPaso(PasoDto pasoDto);
}
