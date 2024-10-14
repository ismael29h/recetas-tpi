package com.tpi2024.cocina.service.categoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpi2024.cocina.domain.Categoria;
import com.tpi2024.cocina.exception.NotFoundException;
import com.tpi2024.cocina.repository.categoria.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria getCategoriaById(int id) {
        Optional<Categoria> opcCategoria = categoriaRepository.findById(id);

        return opcCategoria.orElseThrow(() -> new NotFoundException("Categoria_ID: " + id));

    }

}
