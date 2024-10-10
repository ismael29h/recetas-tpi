package com.tpi2024.cocina.controller.receta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpi2024.cocina.dto.receta.RecetaDto;
import com.tpi2024.cocina.service.receta.RecetaService;

@RestController
@RequestMapping("/recetas")
public class RecetaController {
    @Autowired
    private RecetaService recetaService;

    // 1 - Creación de recetas
    @PostMapping()
    public ResponseEntity<RecetaDto> createReceta(@RequestBody RecetaDto recetaDto) {
        RecetaDto recetaCreatedDto = recetaService.createReceta(recetaDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(recetaCreatedDto);

    }

}
