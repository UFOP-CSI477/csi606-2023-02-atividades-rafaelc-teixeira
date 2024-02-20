package com.example.APIBloodDonation.repository;

import com.example.APIBloodDonation.entity.Cidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadesRepository extends JpaRepository<Cidades, Long>{
        Optional<Cidades> findByNome(String nome);
}
