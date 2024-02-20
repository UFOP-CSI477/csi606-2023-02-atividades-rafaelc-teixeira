package com.example.APIBloodDonation.dto;

import com.example.APIBloodDonation.entity.Cidades;
import com.example.APIBloodDonation.entity.Pessoas;
import com.example.APIBloodDonation.entity.TiposSanguineos;
import lombok.Data;

@Data
public class PessoasDTO {

    private Long id;
    private String nome;
    private String rua;
    private String numero;
    private String complemento;
    private String rg;
    private Long cidadeId;
    private Long tipoSanguineosId;

    public Pessoas toEntity() {
        return new Pessoas(
                this.getId(),
                this.getNome(),
                this.getRua(),
                this.getNumero(),
                this.getComplemento(),
                this.getRg(),
                new Cidades(this.getCidadeId()),
                new TiposSanguineos(this.getTipoSanguineosId()),
                null,
                null
        );
    }
}