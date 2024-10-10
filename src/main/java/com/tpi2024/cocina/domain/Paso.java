package com.tpi2024.cocina.domain;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Paso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(length = 5000)
    private String descripcion;

    @Column(nullable = false)
    private LocalTime tiempo;

    @Column(nullable = false)
    private boolean esOpcional;

    @ManyToOne
    @JoinColumn(name = "receta_id", nullable = false)
    private Receta receta;

    @Builder.Default
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "paso_id")
    private List<Ingrediente> ingredientes = new ArrayList<>();
}
