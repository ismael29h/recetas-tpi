package com.tpi2024.cocina.controller.receta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpi2024.cocina.dto.categoria.CategoriaListDto;
import com.tpi2024.cocina.dto.ingrediente.IngredienteGetDto;
import com.tpi2024.cocina.dto.paso.PasoDto;
import com.tpi2024.cocina.dto.receta.RecetaDto;
import com.tpi2024.cocina.dto.receta.RecetaGetDto;
import com.tpi2024.cocina.service.paso.PasoService;
import com.tpi2024.cocina.service.receta.RecetaService;

@RestController
@RequestMapping("/recetas")
public class RecetaController {
    @Autowired
    private RecetaService recetaService;

    @Autowired
    private PasoService pasoService;

    // 1 - Creación de recetas
    @PostMapping()
    public ResponseEntity<RecetaDto> createReceta(@RequestBody RecetaDto recetaDto) {
        RecetaDto recetaCreatedDto = recetaService.createReceta(recetaDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(recetaCreatedDto);

    }

    // 2 - Obtener receta por ID
    @GetMapping("/{id}")
    public ResponseEntity<RecetaGetDto> getRecetaById(@PathVariable int id) {
        RecetaGetDto recetaGetDto = recetaService.getRecetaGetDtoById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(recetaGetDto);
    }

    // 3 - Obtener listado de recetas por categoria
    @GetMapping("/categoria/{id}")
    public ResponseEntity<CategoriaListDto> getAllRecetaByCategoriaId(@PathVariable int id) {
        CategoriaListDto categoriaListDto = recetaService.getAllRecetaByCategoriaId(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoriaListDto);
    }

    // 4 - Eliminar receta
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecetaById(@PathVariable int id) {
        if (recetaService.deleteReceta(id)) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    // 5 - Actualizar paso
    @PutMapping("/pasos/{paso_id}")
    public ResponseEntity<?> updatePaso(
            @PathVariable int paso_id,
            @RequestBody PasoDto pasoDto) {

        pasoService.updatePaso(paso_id, pasoDto);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // 6 - Obtener todos los ingredientes dada una receta y su paso
    @GetMapping("/{receta_id}/ingredientes")
    public ResponseEntity<List<IngredienteGetDto>> getAllIngredientes(@PathVariable int receta_id) {
        List<IngredienteGetDto> ingredienteGetDtos = recetaService.getAllIngredientesByRecetaId(receta_id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ingredienteGetDtos);
    }

    // 6 - Obtener ingredientes de un paso
    @GetMapping("/pasos/{paso_id}/ingredientes")
    public ResponseEntity<List<IngredienteGetDto>> getAllIngredientesByPaso(@PathVariable int paso_id) {

        List<IngredienteGetDto> ingredienteGetDtos = pasoService.getAllIngredientesByPaso(paso_id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ingredienteGetDtos);
    }
}
