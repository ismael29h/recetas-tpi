package com.tpi2024.cocina.service.receta;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpi2024.cocina.domain.Categoria;
import com.tpi2024.cocina.domain.Receta;
import com.tpi2024.cocina.dto.receta.RecetaDto;
import com.tpi2024.cocina.dto.receta.RecetaGetDto;
import com.tpi2024.cocina.mapper.receta.RecetaMapper;
import com.tpi2024.cocina.repository.receta.RecetaRepository;
import com.tpi2024.cocina.service.categoria.CategoriaService;

@Service
public class RecetaServiceImpl implements RecetaService {
    @Autowired
    private RecetaRepository recetaRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public RecetaDto createReceta(RecetaDto recetaCreateDto) {
        // dto -> entidad
        Receta recetaCreate = RecetaMapper.INSTANCE.recetaDtoToReceta(recetaCreateDto);

        // obtengo categoria por ID y lo asigno (reemplazo) a receta
        Categoria categoria = categoriaService.getCategoriaById(recetaCreateDto.categoria().id());
        recetaCreate.setCategoria(categoria);

        // asigno receta a cada paso
        recetaCreate.getPasos().forEach(paso -> paso.setReceta(recetaCreate));

        // guardar: cascade all
        Receta recetaCreated = recetaRepository.save(recetaCreate);

        return RecetaMapper.INSTANCE.recetaToRecetaDto(recetaCreated);
    }

    @Override
    public RecetaGetDto getRecetaGetDtoById(int id) {
        Optional<Receta> recetaGet = recetaRepository.findById(id);

        if (recetaGet.isPresent()) {
            return RecetaMapper.INSTANCE.recetaToRecetaGetDto(recetaGet.get());
        }

        return null; // ERROR
    }
}
