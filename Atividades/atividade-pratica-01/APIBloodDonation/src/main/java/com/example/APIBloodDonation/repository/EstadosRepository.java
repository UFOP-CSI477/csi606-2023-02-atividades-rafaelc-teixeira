package com.example.APIBloodDonation.repository;

import com.example.APIBloodDonation.entity.Estados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadosRepository extends JpaRepository<Estados, Long> {
    Optional<Estados> findByNome(String nome);
}
