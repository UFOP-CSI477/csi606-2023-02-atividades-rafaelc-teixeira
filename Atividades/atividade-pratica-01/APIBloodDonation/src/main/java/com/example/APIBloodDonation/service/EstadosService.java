package com.example.APIBloodDonation.service;

import com.example.APIBloodDonation.dto.EstadosDTO;
import com.example.APIBloodDonation.entity.Estados;
import com.example.APIBloodDonation.repository.EstadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EstadosService {

    @Autowired
    private EstadosRepository estadosRepository;

    public Estados createState(EstadosDTO estadoDTO) {
        Estados estados = estadoDTO.toEntity();
        estados.setCreatedAt(LocalDateTime.now());
        estados.setUpdatedAt(LocalDateTime.now());

        return estadosRepository.save(estados);
    }

    public Estados updateState(Long id, EstadosDTO estadoDTO) throws Exception {
        Estados estado = estadosRepository.findById(estadoDTO.getId())
                .orElseThrow(() -> new Exception("Estado not found with id: " + id));

        Estados updatedEstado = estadoDTO.toEntity();
        updatedEstado.setId(estado.getId());
        updatedEstado.setCreatedAt(estado.getCreatedAt());
        updatedEstado.setUpdatedAt(LocalDateTime.now());

        return estadosRepository.save(updatedEstado);
    }

    public void deleteState(Long id) {
        estadosRepository.deleteById(id);
    }

    public List<Estados> getAllStates() {
        return estadosRepository.findAll();
    }

    public Estados getStateById(Long id) throws Exception {
        return estadosRepository.findById(id)
                .orElseThrow(() -> new Exception("Estado not found with id: " + id));
    }

    public Estados getStateByName(String nome) throws Exception {
        return estadosRepository.findByNome(nome)
                .orElseThrow(() -> new Exception("Estado not found with name: " + nome));
    }

}