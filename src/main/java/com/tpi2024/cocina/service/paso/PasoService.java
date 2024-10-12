package com.tpi2024.cocina.service.paso;

import com.tpi2024.cocina.domain.Paso;
import com.tpi2024.cocina.dto.paso.PasoDto;

public interface PasoService {
    public void updatePaso(int id, PasoDto pasoDto);

    public Paso getPasoById(int id);

}
