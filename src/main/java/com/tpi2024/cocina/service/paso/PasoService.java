package com.tpi2024.cocina.service.paso;

import java.util.List;

import com.tpi2024.cocina.domain.Paso;
import com.tpi2024.cocina.dto.ingrediente.IngredienteGetDto;
import com.tpi2024.cocina.dto.paso.PasoDto;

public interface PasoService {
    public void updatePaso(int id, PasoDto pasoDto);

    public Paso getPasoById(int id);

    public List<IngredienteGetDto> getAllIngredientesByPaso(int paso_id);
}
