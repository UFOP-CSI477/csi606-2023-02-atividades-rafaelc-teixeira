package com.example.APIBloodDonation.repository;

import com.example.APIBloodDonation.entity.Doacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoacoesRepository extends JpaRepository<Doacoes, Long> {
}
