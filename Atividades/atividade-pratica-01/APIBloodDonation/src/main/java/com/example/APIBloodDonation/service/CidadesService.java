package com.example.APIBloodDonation.service;

import com.example.APIBloodDonation.dto.CidadesDTO;
import com.example.APIBloodDonation.entity.Cidades;
import com.example.APIBloodDonation.repository.CidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CidadesService {

    @Autowired
    private CidadesRepository cidadesRepository;

    public Cidades createCity(CidadesDTO cidadeDTO) {
        Cidades cidades = cidadeDTO.toEntity();
        cidades.setCreatedAt(LocalDateTime.now());
        cidades.setUpdatedAt(LocalDateTime.now());

        return cidadesRepository.save(cidades);

    }

    public Cidades updateCity(Long id, CidadesDTO cidadeDTO) throws Exception {
        Cidades cidade = cidadesRepository.findById(cidadeDTO.getId())
                .orElseThrow(() -> new Exception("Cidade not found with id: " + id));
        Cidades updatedCidade = cidadeDTO.toEntity();
        updatedCidade.setId(cidade.getId());
        updatedCidade.setCreatedAt(cidade.getCreatedAt());
        updatedCidade.setUpdatedAt(LocalDateTime.now());

        return cidadesRepository.save(updatedCidade);
    }

    public void deleteCity(Long id) {
        cidadesRepository.deleteById(id);
    }

    public List<Cidades> getAllCities() {
        return cidadesRepository.findAll();
    }

    public Cidades getCityById(Long id) throws Exception {
        return cidadesRepository.findById(id)
                .orElseThrow(() -> new Exception("Cidade not found with id: " + id));
    }

    public Cidades getCityByName(String nome) throws Exception{
        return cidadesRepository.findByNome(nome)
                .orElseThrow(() -> new Exception("Cidade not found with name: " + nome));
    }

}