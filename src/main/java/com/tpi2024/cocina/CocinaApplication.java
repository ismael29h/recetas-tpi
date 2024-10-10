package com.tpi2024.cocina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tpi2024.cocina.domain.Categoria;
import com.tpi2024.cocina.repository.categoria.CategoriaRepository;

@SpringBootApplication
public class CocinaApplication {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CocinaApplication.class, args);
	}

	// Categorías precargadas
	@Bean
	public CommandLineRunner demoData() {
		return (args) -> {
			Categoria categoriaVegana = Categoria.builder()
					.nombre("Vegana")
					.build();

			Categoria categoriaVegetariana = Categoria.builder()
					.nombre("Vegetariana")
					.build();

			Categoria categoriaCarnes = Categoria.builder()
					.nombre("Carne")
					.build();

			categoriaRepository.save(categoriaVegana);
			categoriaRepository.save(categoriaVegetariana);
			categoriaRepository.save(categoriaCarnes);
		};
	}
}
