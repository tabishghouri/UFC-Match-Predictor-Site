package com.ufc.ufc_predictor.fighter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="fighter_statistic")
public class Fighter {
  @Id
  @Column(name = "fighter_name", nullable = false)
  private String fighterName;

  @Column(name = "height_cm")
  private Double heightCm; // Some values are missing (null-safe)

  @Column(name = "weight_pounds")
  private Double weightPounds;

  @Column(name = "reach_cm")
  private Double reachCm; // Some values are missing (null-safe)

  @Column(name = "stance")
  private String stance;

  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth; // Some values are NULL, handle accordingly

  @Column(name = "f_wins")
  private Integer fWins;

  @Column(name = "win_rate")
  private Double winRate;

  @Column(name = "f_losses")
  private Integer fLosses;

  @Column(name = "loss_rate")
  private Double lossRate;

  @Column(name = "f_draws")
  private Integer fDraws;

  @Column(name = "draw_rate")
  private Double drawRate;

  @Column(name = "f_dc_nc")
  private Integer fDcNc;

  @Column(name = "dc_nc_rate")
  private Double dcNcRate;

  @Column(name = "career_SLpM")
  private Double careerSLpM;

  @Column(name = "career_StrAcc")
  private Integer careerStrAcc; // Based on observed integer values in SQL

  @Column(name = "career_SApM")
  private Double careerSApM;

  @Column(name = "career_StrDef")
  private Integer careerStrDef; // Based on observed integer values in SQL

  @Column(name = "career_TD_Avg")
  private Double careerTDAvg;

  @Column(name = "career_TD_Acc")
  private Integer careerTDAcc; // Based on observed integer values in SQL

  @Column(name = "career_TD_Def")
  private Integer careerTDDef; // Based on observed integer values in SQL

  @Column(name = "career_Sub_Avg")
  private Double careerSubAvg;

  public Fighter() {
  }

  public Fighter(String fighterName, Double heightCm, Double weightPounds, Double reachCm, String stance,
                 LocalDate dateOfBirth, Integer fWins, Double winRate, Integer fLosses, Double lossRate, Integer fDraws,
                 Double drawRate, Integer fDcNc, Double dcNcRate, Double careerSLpM, Integer careerStrAcc,
                 Double careerSApM, Integer careerStrDef, Double careerTDAvg, Integer careerTDAcc, Integer careerTDDef,
                 Double careerSubAvg) {
    this.fighterName = fighterName;
    this.heightCm = heightCm;
    this.weightPounds = weightPounds;
    this.reachCm = reachCm;
    this.stance = stance;
    this.dateOfBirth = dateOfBirth;
    this.fWins = fWins;
    this.winRate = winRate;
    this.fLosses = fLosses;
    this.lossRate = lossRate;
    this.fDraws = fDraws;
    this.drawRate = drawRate;
    this.fDcNc = fDcNc;
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

  public Integer getFWins() {
    return fWins;
  }

  public void setFWins(Integer fWins) {
    this.fWins = fWins;
  }

  public Double getWinRate() {
    return winRate;
  }

  public void setWinRate(Double winRate) {
    this.winRate = winRate;
  }

  public Integer getFLosses() {
    return fLosses;
  }

  public void setFLosses(Integer fLosses) {
    this.fLosses = fLosses;
  }

  public Double getLossRate() {
    return lossRate;
  }

  public void setLossRate(Double lossRate) {
    this.lossRate = lossRate;
  }

  public Integer getFDraws() {
    return fDraws;
  }

  public void setFDraws(Integer fDraws) {
    this.fDraws = fDraws;
  }

  public Double getDrawRate() {
    return drawRate;
  }

  public void setDrawRate(Double drawRate) {
    this.drawRate = drawRate;
  }

  public Integer getFDcNc() {
    return fDcNc;
  }

  public void setFDcNc(Integer fDcNc) {
    this.fDcNc = fDcNc;
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

  public Integer getCareerStrAcc() {
    return careerStrAcc;
  }

  public void setCareerStrAcc(Integer careerStrAcc) {
    this.careerStrAcc = careerStrAcc;
  }

  public Double getCareerSApM() {
    return careerSApM;
  }

  public void setCareerSApM(Double careerSApM) {
    this.careerSApM = careerSApM;
  }

  public Integer getCareerStrDef() {
    return careerStrDef;
  }

  public void setCareerStrDef(Integer careerStrDef) {
    this.careerStrDef = careerStrDef;
  }

  public Double getCareerTDAvg() {
    return careerTDAvg;
  }

  public void setCareerTDAvg(Double careerTDAvg) {
    this.careerTDAvg = careerTDAvg;
  }

  public Integer getCareerTDAcc() {
    return careerTDAcc;
  }

  public void setCareerTDAcc(Integer careerTDAcc) {
    this.careerTDAcc = careerTDAcc;
  }

  public Integer getCareerTDDef() {
    return careerTDDef;
  }

  public void setCareerTDDef(Integer careerTDDef) {
    this.careerTDDef = careerTDDef;
  }

  public Double getCareerSubAvg() {
    return careerSubAvg;
  }

  public void setCareerSubAvg(Double careerSubAvg) {
    this.careerSubAvg = careerSubAvg;
  }
}
