package com.example.APIBloodDonation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "locais_coleta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocaisColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String rua;

    private String numero;

    private String complemento;

    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidades cidade;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public LocaisColeta(Long id) {
        this.id = id;
    }
}