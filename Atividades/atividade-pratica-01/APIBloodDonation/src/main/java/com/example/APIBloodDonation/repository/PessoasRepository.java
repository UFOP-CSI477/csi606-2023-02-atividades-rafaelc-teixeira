package com.example.APIBloodDonation.repository;

import com.example.APIBloodDonation.entity.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoasRepository extends JpaRepository<Pessoas, Long>{
    Optional<Pessoas> findByNome(String nome);
}
