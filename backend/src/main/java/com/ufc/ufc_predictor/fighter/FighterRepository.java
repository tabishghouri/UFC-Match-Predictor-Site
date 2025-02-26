package com.ufc.ufc_predictor.fighter;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, String>{
  void deleteByFighterName(String fighterName);

  Optional<Fighter> findByFighterName(String name);

  boolean existsByFighterName(String fighterName);
}
