package com.example.APIBloodDonation.repository;

import com.example.APIBloodDonation.entity.LocaisColeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocaisColetaRepository extends JpaRepository<LocaisColeta, Long>{
    Optional<LocaisColeta> findByNome(String nome);
}
