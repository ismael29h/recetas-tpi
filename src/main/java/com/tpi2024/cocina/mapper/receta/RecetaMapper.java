package com.tpi2024.cocina.mapper.receta;

import java.time.LocalTime;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tpi2024.cocina.domain.Receta;
import com.tpi2024.cocina.dto.receta.RecetaDto;
import com.tpi2024.cocina.dto.receta.RecetaGetDto;
import com.tpi2024.cocina.dto.receta.RecetaListDto;
import com.tpi2024.cocina.mapper.paso.PasoMapper;
import com.tpi2024.cocina.service.receta.RecetaService;
import com.tpi2024.cocina.service.receta.RecetaServiceImpl;

@Mapper(uses = { PasoMapper.class }) // agrega mapper de paso
public interface RecetaMapper {
    RecetaMapper INSTANCE = Mappers.getMapper(RecetaMapper.class);

    RecetaDto recetaToRecetaDto(Receta receta);

    Receta recetaDtoToReceta(RecetaDto recetaDto);

    RecetaGetDto recetaToRecetaGetDto(Receta receta);

    Receta recetaGetDtoToReceta(RecetaGetDto recetaGetDto);

    default RecetaListDto recetaToRecetaListDto(Receta receta) {
        RecetaService recetaService = new RecetaServiceImpl();

        LocalTime tiempoTotal = recetaService.calcTiempoTotal(receta);

        return new RecetaListDto(
                receta.getId(),
                receta.getNombre(),
                receta.getDificultad(),
                receta.getDescripcion(),
                tiempoTotal);

    };

    Receta recetaListDtoToReceta(RecetaListDto recetaListDto);
}
