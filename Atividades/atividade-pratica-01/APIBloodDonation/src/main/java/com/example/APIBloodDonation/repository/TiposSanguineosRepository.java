package com.example.APIBloodDonation.repository;

import com.example.APIBloodDonation.entity.TiposSanguineos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposSanguineosRepository extends JpaRepository<TiposSanguineos, Long>{
}
