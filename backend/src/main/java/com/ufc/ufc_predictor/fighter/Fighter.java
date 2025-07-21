package com.ufc.ufc_predictor.fighter;

import jakarta.persistence.*;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="fighter_statistics", schema = "public")
public class Fighter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "fighter_name")
  private String fighterName;

  @Column(name = "height_cm")
  private Double heightCm;;

  @Column(name = "weight_pounds")
  private Double weightPounds;

  @Column(name = "reach_cm")
  private Double reachCm;

  @Column(name = "stance")
  private String stance;

  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;

  @Column(name = "f_wins")
  private Double wins;

  @Column(name = "win_rate")
  private Double winRate;

  @Column(name = "f_losses")
  private Double losses;

  @Column(name = "loss_rate")
  private Double lossRate;

  @Column(name = "f_draws")
  private Double draws;

  @Column(name = "draw_rate")
  private Double drawRate;

  @Column(name = "f_dc_nc")
  private Double dcNc;

  @Column(name = "dc_nc_rate")
  private Double dcNcRate;

  @Column(name = "career_slpm")
  private Double careerSLpM;

  @Column(name = "career_stracc")
  private Double careerStrAcc;

  @Column(name = "career_sapm")
  private Double careerSApM;

  @Column(name = "career_strdef")
  private Double careerStrDef;

  @Column(name = "career_td_avg")
  private Double careerTDAvg;

  @Column(name = "career_td_acc")
  private Double careerTDAcc;

  @Column(name = "career_td_def")
  private Double careerTDDef;

  @Column(name = "career_sub_avg")
  private Double careerSubAvg;

  public Fighter() {
  }

  public Fighter(String fighterName, Double heightCm, Double weightPounds, Double reachCm, String stance, LocalDate dateOfBirth, Double wins, Double winRate, Double losses, Double lossRate, Double draws, Double drawRate, Double dcNc, Double dcNcRate, Double careerSLpM, Double careerStrAcc, Double careerSApM, Double careerStrDef, Double careerTDAvg, Double careerTDAcc, Double careerTDDef, Double careerSubAvg) {
    this.fighterName = fighterName;
    this.heightCm = heightCm;
    this.weightPounds = weightPounds;
    this.reachCm = reachCm;
    this.stance = stance;
    this.dateOfBirth = dateOfBirth;
    this.wins = wins;
    this.winRate = winRate;
    this.losses = losses;
    this.lossRate = lossRate;
    this.draws = draws;
    this.drawRate = drawRate;
    this.dcNc = dcNc;
    this.dcNcRate = dcNcRate;
    this.careerSLpM = careerSLpM;
    this.careerStrAcc = careerStrAcc;
    this.careerSApM = careerSApM;
    this.careerStrDef = careerStrDef;
    this.careerTDAvg = careerTDAvg;
    this.careerTDAcc = careerTDAcc;
    this.careerTDDef = careerTDDef;
    this.careerSubAvg = careerSubAvg;
  }

  public String getFighterName() {
    return fighterName;
  }

  public void setFighterName(String fighterName) {
    this.fighterName = fighterName;
  }

  public Double getHeightCm() {
    return heightCm;
  }

  public void setHeightCm(Double heightCm) {
    this.heightCm = heightCm;
  }

  public Double getWeightPounds() {
    return weightPounds;
  }

  public void setWeightPounds(Double weightPounds) {
    this.weightPounds = weightPounds;
  }

  public Double getReachCm() {
    return reachCm;
  }

  public void setReachCm(Double reachCm) {
    this.reachCm = reachCm;
  }

  public String getStance() {
    return stance;
  }

  public void setStance(String stance) {
    this.stance = stance;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Double getWins() {
    return wins;
  }

  public void setWins(Double wins) {
    this.wins = wins;
  }

  public Double getWinRate() {
    return winRate;
  }

  public void setWinRate(Double winRate) {
    this.winRate = winRate;
  }

  public Double getLosses() {
    return losses;
  }

  public void setLosses(Double losses) {
    this.losses = losses;
  }

  public Double getLossRate() {
    return lossRate;
  }

  public void setLossRate(Double lossRate) {
    this.lossRate = lossRate;
  }

  public Double getDraws() {
    return draws;
  }

  public void setDraws(Double draws) {
    this.draws = draws;
  }

  public Double getDrawRate() {
    return drawRate;
  }

  public void setDrawRate(Double drawRate) {
    this.drawRate = drawRate;
  }

  public Double getDcNc() {
    return dcNc;
  }

  public void setDcNc(Double dcNc) {
    this.dcNc = dcNc;
  }

  public Double getDcNcRate() {
    return dcNcRate;
  }

  public void setDcNcRate(Double dcNcRate) {
    this.dcNcRate = dcNcRate;
  }

  public Double getCareerSLpM() {
    return careerSLpM;
  }

  public void setCareerSLpM(Double careerSLpM) {
    this.careerSLpM = careerSLpM;
  }

  public Double getCareerStrAcc() {
    return careerStrAcc;
  }

  public void setCareerStrAcc(Double careerStrAcc) {
    this.careerStrAcc = careerStrAcc;
  }

  public Double getCareerSApM() {
    return careerSApM;
  }

  public void setCareerSApM(Double careerSApM) {
    this.careerSApM = careerSApM;
  }

  public Double getCareerStrDef() {
    return careerStrDef;
  }

  public void setCareerStrDef(Double careerStrDef) {
    this.careerStrDef = careerStrDef;
  }

  public Double getCareerTDAvg() {
    return careerTDAvg;
  }

  public void setCareerTDAvg(Double careerTDAvg) {
    this.careerTDAvg = careerTDAvg;
  }

  public Double getCareerTDAcc() {
    return careerTDAcc;
  }

  public void setCareerTDAcc(Double careerTDAcc) {
    this.careerTDAcc = careerTDAcc;
  }

  public Double getCareerTDDef() {
    return careerTDDef;
  }

  public void setCareerTDDef(Double careerTDDef) {
    this.careerTDDef = careerTDDef;
  }

  public Double getCareerSubAvg() {
    return careerSubAvg;
  }

  public void setCareerSubAvg(Double careerSubAvg) {
    this.careerSubAvg = careerSubAvg;
  }
}
