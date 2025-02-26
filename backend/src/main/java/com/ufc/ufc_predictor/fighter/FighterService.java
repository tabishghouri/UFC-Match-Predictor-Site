package com.ufc.ufc_predictor.fighter;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FighterService {
  private final FighterRepository fighterRepository;

  @Autowired
  public FighterService(FighterRepository fighterRepository) {
    this.fighterRepository = fighterRepository;
  }

  // get all fighters
  public List<Fighter> getFighters() {
    return fighterRepository.findAll();
  }
  // search by fighter name
  public List<Fighter> getFightersByName(String searchName) {
    return fighterRepository.findAll().stream()
        .filter(fighter -> fighter.getFighterName().toLowerCase().contains(searchName.toLowerCase()))
        .collect(Collectors.toList());
  }
  // search by height (in cm)
  public List<Fighter> getFightersByHeight(Double height) {
    return fighterRepository.findAll().stream()
        .filter(fighter -> fighter.getHeightCm() != null && fighter.getHeightCm().equals(height))
        .collect(Collectors.toList());
  }

  // search by weight (in pounds)
  public List<Fighter> getFightersByWeight(Double weight) {
    return fighterRepository.findAll().stream()
        .filter(fighter -> fighter.getWeightPounds() != null && fighter.getWeightPounds().equals(weight))
        .collect(Collectors.toList());
  }

  // search by stance
  public List<Fighter> getFightersByStance(String stance) {
    return fighterRepository.findAll().stream()
        .filter(fighter -> fighter.getStance() != null && fighter.getStance().equalsIgnoreCase(stance))
        .collect(Collectors.toList());
  }

  // search by date of birth
  public List<Fighter> getFightersByDateOfBirth(LocalDate dateOfBirth) {
    return fighterRepository.findAll().stream()
        .filter(fighter -> fighter.getDateOfBirth() != null && fighter.getDateOfBirth().equals(dateOfBirth))
        .collect(Collectors.toList());
  }

  public Fighter addFighter(Fighter fighter) {
    fighterRepository.save(fighter);
    return fighter;
  }

  public Fighter updateFighter(Fighter updatedFighter) {
    Optional<Fighter> existingFighter = fighterRepository.findByFighterName(updatedFighter.getFighterName());

    if (existingFighter.isPresent()) {
      Fighter fighterToUpdate = existingFighter.get();

      fighterToUpdate.setHeightCm(updatedFighter.getHeightCm());
      fighterToUpdate.setWeightPounds(updatedFighter.getWeightPounds());
      fighterToUpdate.setReachCm(updatedFighter.getReachCm());
      fighterToUpdate.setStance(updatedFighter.getStance());
      fighterToUpdate.setDateOfBirth(updatedFighter.getDateOfBirth());
      fighterToUpdate.setFWins(updatedFighter.getFWins());
      fighterToUpdate.setWinRate(updatedFighter.getWinRate());
      fighterToUpdate.setFLosses(updatedFighter.getFLosses());
      fighterToUpdate.setLossRate(updatedFighter.getLossRate());
      fighterToUpdate.setFDraws(updatedFighter.getFDraws());
      fighterToUpdate.setDrawRate(updatedFighter.getDrawRate());
      fighterToUpdate.setFDcNc(updatedFighter.getFDcNc());
      fighterToUpdate.setDcNcRate(updatedFighter.getDcNcRate());
      fighterToUpdate.setCareerSLpM(updatedFighter.getCareerSLpM());
      fighterToUpdate.setCareerStrAcc(updatedFighter.getCareerStrAcc());
      fighterToUpdate.setCareerSApM(updatedFighter.getCareerSApM());
      fighterToUpdate.setCareerStrDef(updatedFighter.getCareerStrDef());
      fighterToUpdate.setCareerTDAvg(updatedFighter.getCareerTDAvg());
      fighterToUpdate.setCareerTDAcc(updatedFighter.getCareerTDAcc());
      fighterToUpdate.setCareerTDDef(updatedFighter.getCareerTDDef());
      fighterToUpdate.setCareerSubAvg(updatedFighter.getCareerSubAvg());

      fighterRepository.saveAndFlush(fighterToUpdate);
      return fighterToUpdate;
    }
    return null;
  }

  @Transactional
  public void deleteFighter(String fighterName) {
    if (fighterRepository.existsByFighterName(fighterName)) {
      fighterRepository.deleteByFighterName(fighterName);
    } else {
      throw new RuntimeException("Fighter not found: " + fighterName);
    }
  }

}
