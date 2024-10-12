package com.tpi2024.cocina.service.paso;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpi2024.cocina.domain.Paso;
import com.tpi2024.cocina.dto.paso.PasoDto;
import com.tpi2024.cocina.mapper.paso.PasoMapper;
import com.tpi2024.cocina.repository.paso.PasoRepository;
import com.tpi2024.cocina.service.ingrediente.IngredienteService;

@Service
public class PasoServiceImpl implements PasoService {
    @Autowired
    private PasoRepository pasoRepository;

    @Autowired
    IngredienteService ingredienteService;

    @Override
    public void updatePaso(int id, PasoDto pasoDto) {
        List<Integer> ingredientesIDs = new ArrayList<>();

        Paso paso = getPasoById(id);

        Paso pasoMod = PasoMapper.INSTANCE.pasoDtoToPaso(pasoDto);

        paso.setDescripcion(pasoMod.getDescripcion());
        paso.setTiempo(pasoMod.getTiempo());
        paso.setEsOpcional(pasoMod.isEsOpcional());

        // resguardo de ids de los ingredientes que quedarán sueltos
        paso.getIngredientes().forEach(i -> ingredientesIDs.add(i.getId()));

        paso.setIngredientes(pasoMod.getIngredientes());

        pasoRepository.save(paso);

        // eliminación de ingredientes anteriores
        ingredientesIDs.forEach(e -> ingredienteService.deleteIngrediente(e));
    }

    @Override
    public Paso getPasoById(int id) {
        Optional<Paso> pasoGet = pasoRepository.findById(id);

        if (pasoGet.isPresent()) {
            return pasoGet.get();
        }

        return null;// error
    }
}