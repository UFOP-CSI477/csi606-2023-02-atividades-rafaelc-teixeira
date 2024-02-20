package com.example.APIBloodDonation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "doacoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoas pessoa;

    @ManyToOne
    @JoinColumn(name = "local_id", nullable = false)
    private LocaisColeta local;

    @Column(name = "data")
    private LocalDateTime data;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Doacoes(Long id) {
        this.id = id;
    }
}