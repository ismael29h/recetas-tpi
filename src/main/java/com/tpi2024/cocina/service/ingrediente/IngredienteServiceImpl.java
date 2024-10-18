package com.tpi2024.cocina.service.ingrediente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpi2024.cocina.repository.ingrediente.IngredienteRepository;

@Service
public class IngredienteServiceImpl implements IngredienteService {
    @Autowired
    IngredienteRepository ingredienteRepository;

    @Override
    /* Elimina un ingrediente por su ID */
    public void deleteIngrediente(int id) {
        ingredienteRepository.deleteById(id);
    }

}
