package com.unal.andromeda.repositories;

import com.unal.andromeda.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Optional<Profile> findByCode(String code);
}
