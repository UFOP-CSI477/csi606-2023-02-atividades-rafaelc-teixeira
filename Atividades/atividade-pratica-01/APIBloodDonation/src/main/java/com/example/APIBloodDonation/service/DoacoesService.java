package com.example.APIBloodDonation.service;

import com.example.APIBloodDonation.dto.DoacoesDTO;
import com.example.APIBloodDonation.entity.Doacoes;
import com.example.APIBloodDonation.entity.LocaisColeta;
import com.example.APIBloodDonation.entity.Pessoas;
import com.example.APIBloodDonation.repository.DoacoesRepository;
import com.example.APIBloodDonation.repository.LocaisColetaRepository;
import com.example.APIBloodDonation.repository.PessoasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DoacoesService {

    @Autowired
    private DoacoesRepository doacoesRepository;

    @Autowired
    private PessoasRepository pessoasRepository;

    @Autowired
    private LocaisColetaRepository locaisColetaRepository;

    public Doacoes createDonation(DoacoesDTO doacaoDTO) throws Exception {
        Pessoas pessoa = pessoasRepository.findById(doacaoDTO.getPessoaId())
                .orElseThrow(() -> new Exception("Pessoa not found with id: " + doacaoDTO.getPessoaId()));

        LocaisColeta localColeta = locaisColetaRepository.findById(doacaoDTO.getLocalId())
                .orElseThrow(() -> new Exception("Local de coleta not found with id: " + doacaoDTO.getLocalId()));

        Doacoes doacao = doacaoDTO.toEntity();
        doacao.setPessoa(pessoa);
        doacao.setLocal(localColeta);
        doacao.setCreatedAt(LocalDateTime.now());
        doacao.setUpdatedAt(LocalDateTime.now());

        return doacoesRepository.save(doacao);
    }

    public Doacoes updateDonation(Long id, DoacoesDTO doacaoDTO) throws Exception {
        Doacoes doacaoToUpdate = doacoesRepository.findById(id)
                .orElseThrow(() -> new Exception("Doacao not found with id: " + id));

        Doacoes doacaoUpdated = doacaoDTO.toEntity();
        doacaoUpdated.setId(doacaoToUpdate.getId());
        doacaoUpdated.setCreatedAt(doacaoToUpdate.getCreatedAt());
        doacaoUpdated.setUpdatedAt(LocalDateTime.now());

        return doacoesRepository.save(doacaoUpdated);
    }

    public void deleteDonation(Long id) {
        doacoesRepository.deleteById(id);
    }

    public List<Doacoes> getAllDonations() {
        return doacoesRepository.findAll();
    }

    public Doacoes getDonationById(Long id) throws Exception {
        return doacoesRepository.findById(id)
                .orElseThrow(() -> new Exception("Doacao not found with id: " + id));
    }
}