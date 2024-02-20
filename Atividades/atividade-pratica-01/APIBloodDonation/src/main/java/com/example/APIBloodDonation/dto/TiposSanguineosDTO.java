package com.example.APIBloodDonation.dto;

import com.example.APIBloodDonation.entity.TiposSanguineos;
import lombok.Data;

@Data
public class TiposSanguineosDTO {

    private Long id;
    private String tipo;
    private String fator;

    public TiposSanguineos toEntity() {
        return new TiposSanguineos(
                this.getId(),
                this.getTipo(),
                this.getFator(),
                null,
                null
        );
    }

}