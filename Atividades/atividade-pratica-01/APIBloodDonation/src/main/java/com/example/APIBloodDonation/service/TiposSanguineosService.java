package com.example.APIBloodDonation.service;

import com.example.APIBloodDonation.dto.TiposSanguineosDTO;
import com.example.APIBloodDonation.entity.TiposSanguineos;
import com.example.APIBloodDonation.repository.TiposSanguineosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TiposSanguineosService {

    @Autowired
    private TiposSanguineosRepository tiposSanguineosRepository;

    public TiposSanguineos createBloodType(TiposSanguineosDTO tipoSanguineoDTO) {
        TiposSanguineos tipoSanguineo = tipoSanguineoDTO.toEntity();
        tipoSanguineo.setCreatedAt(LocalDateTime.now());
        tipoSanguineo.setUpdatedAt(LocalDateTime.now());

        return tiposSanguineosRepository.save(tipoSanguineo);
    }

    public TiposSanguineos updateBloodType(Long id, TiposSanguineosDTO tipoSanguineoDTO) throws Exception {
        TiposSanguineos tipoSanguineoToUpdate = tiposSanguineosRepository.findById(id)
                .orElseThrow(() -> new Exception("Tipo sanguíneo not found with id: " + id));

        TiposSanguineos tipoSanguineoUpdated = tipoSanguineoDTO.toEntity();
        tipoSanguineoUpdated.setId(tipoSanguineoToUpdate.getId());
        tipoSanguineoUpdated.setCreatedAt(tipoSanguineoToUpdate.getCreatedAt());
        tipoSanguineoUpdated.setUpdatedAt(LocalDateTime.now());

        return tiposSanguineosRepository.save(tipoSanguineoUpdated);
    }

    public void deleteBloodType(Long id) {
        tiposSanguineosRepository.deleteById(id);
    }

    public List<TiposSanguineos> getAllBloodTypes() {
        return tiposSanguineosRepository.findAll();
    }

    public TiposSanguineos getBloodTypeById(Long id) throws Exception {
        return tiposSanguineosRepository.findById(id)
                .orElseThrow(() -> new Exception("Tipo sanguíneo not found with id: " + id));
    }
}