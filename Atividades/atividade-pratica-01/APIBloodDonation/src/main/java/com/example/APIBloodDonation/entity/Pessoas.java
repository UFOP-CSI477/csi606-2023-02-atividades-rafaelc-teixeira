package com.example.APIBloodDonation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "pessoas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String rua;

    private String numero;

    private String complemento;

    private String rg;

    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidades cidade;

    @ManyToOne
    @JoinColumn(name = "tipo_id", nullable = false)
    private TiposSanguineos tipoSanguineos;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Pessoas(Long id) {
        this.id = id;
    }
}