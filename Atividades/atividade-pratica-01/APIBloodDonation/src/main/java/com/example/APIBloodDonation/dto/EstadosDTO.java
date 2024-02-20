package com.example.APIBloodDonation.dto;

import com.example.APIBloodDonation.entity.Estados;
import lombok.Data;

@Data
public class EstadosDTO {

    private Long id;
    private String nome;
    private String sigla;

    public Estados toEntity() {
        return new Estados(
                this.getId(),
                this.getNome(),
                this.getSigla(),
                null,
                null
        );
    }
}
