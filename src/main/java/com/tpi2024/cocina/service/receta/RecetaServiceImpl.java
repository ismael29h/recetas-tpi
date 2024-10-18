package com.tpi2024.cocina.service.receta;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpi2024.cocina.domain.Categoria;
import com.tpi2024.cocina.domain.Ingrediente;
import com.tpi2024.cocina.domain.Paso;
import com.tpi2024.cocina.domain.Receta;
import com.tpi2024.cocina.dto.categoria.CategoriaListDto;
import com.tpi2024.cocina.dto.ingrediente.IngredienteGetDto;
import com.tpi2024.cocina.dto.receta.RecetaDto;
import com.tpi2024.cocina.dto.receta.RecetaGetDto;
import com.tpi2024.cocina.exception.NotFoundException;
import com.tpi2024.cocina.mapper.categoria.CategoriaMapper;
import com.tpi2024.cocina.mapper.ingrediente.IngredienteMapper;
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
    /* Crea nueva receta */
    public RecetaDto createReceta(RecetaDto recetaCreateDto) {
        // dto -> entidad
        Receta recetaCreate = RecetaMapper.INSTANCE.recetaDtoToReceta(recetaCreateDto);

        // obtengo categoria por ID y lo asigno (reemplazo) a receta
        Categoria categoria = categoriaService.getCategoriaById(recetaCreateDto.categoria().id());
        recetaCreate.setCategoria(categoria);

        // asigno receta a cada paso
        recetaCreate.getPasos().forEach(paso -> paso.setReceta(recetaCreate));

        // guardar
        Receta recetaCreated = recetaRepository.save(recetaCreate);

        return RecetaMapper.INSTANCE.recetaToRecetaDto(recetaCreated);
    }

    @Override
    /* Devuelve un DTO a partir de un ID */
    public RecetaGetDto getRecetaGetDtoById(int id) {
        return RecetaMapper.INSTANCE.recetaToRecetaGetDto(getRecetaById(id));
    }

    @Override
    /* Devuelve la entidad Receta a partir de su ID */
    public Receta getRecetaById(int id) {
        Optional<Receta> recetaGet = recetaRepository.findById(id);

        return recetaGet.orElseThrow(() -> new NotFoundException("Receta_ID: " + id));
    }

    @Override
    /* Retorna una lista de recetaDto que corresponde a una categoría */
    public CategoriaListDto getAllRecetaByCategoriaId(int id) {
        // obtener categoria con id
        Categoria categoria = categoriaService.getCategoriaById(id);

        // ent -> dto
        CategoriaListDto categoriaListDto = CategoriaMapper.INSTANCE.categoriaToCategoriaListDto(categoria);

        return categoriaListDto;
    }

    @Override
    /* Quita una receta de la persistencia */
    public boolean deleteReceta(int id) {
        if (recetaRepository.existsById(id)) {
            recetaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    /* Obtiene una lista de ingredientesGetDto que corresponde a una receta */
    public List<IngredienteGetDto> getAllIngredientesByRecetaId(int receta_id) {
        List<Ingrediente> ingredientes = new ArrayList<>();

        List<Paso> pasos = getRecetaById(receta_id).getPasos();

        for (Paso paso : pasos) {
            paso.getIngredientes().forEach(e -> ingredientes.add(e));
        }

        return IngredienteMapper.INSTANCE.ingredientesToIngredientesGetDtos(ingredientes);
    }

    /* Cálculo del tiempo total de una receta (usada en mapper) */
    public LocalTime calcTiempoTotal(Receta receta) {

        LocalTime tiempoTotal = LocalTime.of(0, 0, 0);

        for (Paso paso : receta.getPasos()) {
            tiempoTotal = tiempoTotal.plusHours(paso.getTiempo().getHour())
                    .plusMinutes(paso.getTiempo().getMinute())
                    .plusSeconds(paso.getTiempo().getSecond());

        }

        return tiempoTotal;
    }

}
