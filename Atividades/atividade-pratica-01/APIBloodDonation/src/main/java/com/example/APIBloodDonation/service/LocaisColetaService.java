package com.example.APIBloodDonation.service;

import com.example.APIBloodDonation.dto.LocaisColetaDTO;
import com.example.APIBloodDonation.entity.Cidades;
import com.example.APIBloodDonation.entity.LocaisColeta;
import com.example.APIBloodDonation.repository.CidadesRepository;
import com.example.APIBloodDonation.repository.LocaisColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LocaisColetaService {

    @Autowired
    private LocaisColetaRepository locaisColetaRepository;

    @Autowired
    private CidadesRepository cidadesRepository;

    public LocaisColeta createLocal(LocaisColetaDTO localColetaDTO) throws Exception {
        Cidades cidade = cidadesRepository.findById(localColetaDTO.getCidadeId())
                .orElseThrow(() -> new Exception("Cidade not found with id: " + localColetaDTO.getCidadeId()));

        LocaisColeta localColeta = localColetaDTO.toEntity();
        localColeta.setCidade(cidade);
        localColeta.setCreatedAt(LocalDateTime.now());
        localColeta.setUpdatedAt(LocalDateTime.now());

        return locaisColetaRepository.save(localColeta);
    }

    public LocaisColeta updateLocal(Long id, LocaisColetaDTO localColetaDTO) throws Exception {
        LocaisColeta localColetaToUpdate = locaisColetaRepository.findById(id)
                .orElseThrow(() -> new Exception("Local de coleta not found with id: " + id));

        LocaisColeta localColetaUpdated = localColetaDTO.toEntity();
        localColetaUpdated.setId(localColetaToUpdate.getId());
        localColetaUpdated.setCreatedAt(localColetaToUpdate.getCreatedAt());
        localColetaUpdated.setUpdatedAt(LocalDateTime.now());

        return locaisColetaRepository.save(localColetaUpdated);
    }

    public void deleteLocal(Long id) {
        locaisColetaRepository.deleteById(id);
    }

    public List<LocaisColeta> getAllLocal() {
        return locaisColetaRepository.findAll();
    }

    public LocaisColeta getLocalById(Long id) throws Exception {
        return locaisColetaRepository.findById(id)
                .orElseThrow(() -> new Exception("Local de coleta not found with id: " + id));
    }

    public LocaisColeta getLocalByName(String nome) throws Exception {
        return locaisColetaRepository.findByNome(nome)
                .orElseThrow(() -> new Exception("Local de coleta not found with name: " + nome));
    }
}