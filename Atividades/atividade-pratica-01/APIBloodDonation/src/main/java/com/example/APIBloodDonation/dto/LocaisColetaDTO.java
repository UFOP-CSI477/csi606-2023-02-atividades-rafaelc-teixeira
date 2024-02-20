package com.example.APIBloodDonation.dto;

import com.example.APIBloodDonation.entity.Cidades;
import com.example.APIBloodDonation.entity.LocaisColeta;
import lombok.Data;

@Data
public class LocaisColetaDTO {

    private Long id;
    private String nome;
    private String rua;
    private String numero;
    private String complemento;
    private Long cidadeId;

    public LocaisColeta toEntity() {
        return new LocaisColeta(
                this.getId(),
                this.getNome(),
                this.getRua(),
                this.getNumero(),
                this.getComplemento(),
                new Cidades(this.getCidadeId()),
                null,
                null
        );
    }
}