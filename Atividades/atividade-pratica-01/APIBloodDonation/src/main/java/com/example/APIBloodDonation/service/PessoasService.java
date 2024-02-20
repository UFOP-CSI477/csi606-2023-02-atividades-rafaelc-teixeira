package com.example.APIBloodDonation.service;

import com.example.APIBloodDonation.dto.PessoasDTO;
import com.example.APIBloodDonation.entity.Cidades;
import com.example.APIBloodDonation.entity.Pessoas;
import com.example.APIBloodDonation.entity.TiposSanguineos;
import com.example.APIBloodDonation.repository.CidadesRepository;
import com.example.APIBloodDonation.repository.PessoasRepository;
import com.example.APIBloodDonation.repository.TiposSanguineosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PessoasService {

    @Autowired
    private PessoasRepository pessoasRepository;

    @Autowired
    private CidadesRepository cidadesRepository;

    @Autowired
    private TiposSanguineosRepository tiposSanguineosRepository;

    public Pessoas createPerson(PessoasDTO pessoaDTO) throws Exception {
        Cidades cidade = cidadesRepository.findById(pessoaDTO.getCidadeId())
                .orElseThrow(() -> new Exception("Cidade not found with id: " + pessoaDTO.getCidadeId()));

        TiposSanguineos tiposSanguineos = tiposSanguineosRepository.findById(pessoaDTO.getTipoSanguineosId())
                .orElseThrow(() -> new Exception("Cidade not found with id: " + pessoaDTO.getTipoSanguineosId()));

        Pessoas pessoas = pessoaDTO.toEntity();
        pessoas.setCidade(cidade);
        pessoas.setTipoSanguineos(tiposSanguineos);
        pessoas.setCreatedAt(LocalDateTime.now());
        pessoas.setUpdatedAt(LocalDateTime.now());

        return pessoasRepository.save(pessoas);
    }

    public Pessoas updatePerson(Long id, PessoasDTO pessoaDTO) throws Exception {
        Pessoas pessoaToUpdate = pessoasRepository.findById(id)
                .orElseThrow(() -> new Exception("Pessoa not found with id: " + id));

        Pessoas pessoaUpdated = pessoaDTO.toEntity();
        pessoaUpdated.setId(pessoaToUpdate.getId());
        pessoaUpdated.setCreatedAt(pessoaToUpdate.getCreatedAt());
        pessoaUpdated.setUpdatedAt(LocalDateTime.now());

        return pessoasRepository.save(pessoaUpdated);
    }

    public void deletePerson(Long id) {
        pessoasRepository.deleteById(id);
    }

    public List<Pessoas> getAllPersons() {
        return pessoasRepository.findAll();
    }

    public Pessoas getPersonById(Long id) throws Exception {
        return pessoasRepository.findById(id)
                .orElseThrow(() -> new Exception("Pessoa not found with id: " + id));
    }

    public Pessoas getPersonByName(String nome) throws Exception {
        return pessoasRepository.findByNome(nome)
                .orElseThrow(() -> new Exception("Pessoa not found with name: " + nome));
    }
}