package com.unal.andromeda.repositories;

import com.unal.andromeda.entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer> {
    Optional<Enterprise> findByCode(String code);
}
