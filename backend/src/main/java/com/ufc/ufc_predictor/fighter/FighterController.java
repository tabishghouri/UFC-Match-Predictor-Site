package com.ufc.ufc_predictor.fighter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/fighter")
public class FighterController {
  private final FighterService fighterService;
  private final FighterRepository fighterRepository;

  @Autowired
  public FighterController(FighterService fighterService, FighterRepository fighterRepository) {
    this.fighterService = fighterService;
      this.fighterRepository = fighterRepository;
  }

  @GetMapping
  public List<Fighter> getFighters(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) Double height,
      @RequestParam(required = false) Double weight,
      @RequestParam(required = false) String stance,
      @RequestParam(required = false) String dateOfBirth) {
    if (name != null) {
      return fighterService.getFightersByName(name);
    } else if (height != null) {
      return fighterService.getFightersByHeight(height);
    } else if (weight != null) {
      return fighterService.getFightersByWeight(weight);
    } else if (stance != null) {
      return fighterService.getFightersByStance(stance);
    } else if (dateOfBirth != null) {
      LocalDate dob = LocalDate.parse(dateOfBirth); // Convert String to LocalDate
      return fighterService.getFightersByDateOfBirth(dob);
    } else {
      return fighterService.getFighters(); // Return all fighters if no filters
    }
  }

  @PostMapping
  public ResponseEntity<Fighter> addFighter(@RequestBody Fighter fighter) {
    Fighter createdFighter = fighterService.addFighter(fighter);
    return new ResponseEntity<>(createdFighter, HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Fighter> updateFighter(@RequestBody Fighter fighter) {
    Fighter resultFighter = fighterService.updateFighter(fighter);
    if (resultFighter != null) {
      return new ResponseEntity<>(resultFighter, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{fighterName}")
  public ResponseEntity<String> deleteFighter(@PathVariable String fighterName) {
    fighterService.deleteFighter(fighterName);
    return new ResponseEntity<>("Fighter deleted successfully", HttpStatus.OK);
  }
}
