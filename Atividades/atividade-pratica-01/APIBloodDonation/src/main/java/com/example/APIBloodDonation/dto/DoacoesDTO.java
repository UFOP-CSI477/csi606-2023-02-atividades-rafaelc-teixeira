package com.example.APIBloodDonation.dto;

import com.example.APIBloodDonation.entity.Doacoes;
import com.example.APIBloodDonation.entity.LocaisColeta;
import com.example.APIBloodDonation.entity.Pessoas;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DoacoesDTO {

    private Long id;
    private Long pessoaId;
    private Long localId;
    private LocalDateTime data;

    public Doacoes toEntity() {
        return new Doacoes(
                this.getId(),
                new Pessoas(this.getPessoaId()),
                new LocaisColeta(this.getLocalId()),
                this.getData(),
                null,
                null
        );
    }

}