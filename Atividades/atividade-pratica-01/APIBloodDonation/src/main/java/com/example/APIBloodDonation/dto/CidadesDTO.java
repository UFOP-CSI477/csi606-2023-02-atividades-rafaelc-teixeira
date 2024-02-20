package com.example.APIBloodDonation.dto;

import com.example.APIBloodDonation.entity.Cidades;
import com.example.APIBloodDonation.entity.Estados;
import lombok.Data;

@Data
public class CidadesDTO {

    private Long id;
    private String nome;
    private Long estadoId;

    public Cidades toEntity() {
        return new Cidades(
                this.getId(),
                this.getNome(),
                new Estados(this.getEstadoId()),
                null,
                null
        );
    }
}
