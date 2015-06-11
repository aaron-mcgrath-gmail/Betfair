package amc.betfair.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "point_in_time_odds")
public class PITOdds {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @Column(name = "back_odds", nullable = false)
  private Double backOdds;
  
  @Column(name = "lay_odds", nullable = false)
  private Double layOdds;
  
  @ManyToOne
  @Column(name = "contestant_event_ref", nullable = false)
  private ContestantEvent contestantEvent;

  public PITOdds() {
    
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getBackOdds() {
    return backOdds;
  }

  public void setBackOdds(Double backOdds) {
    this.backOdds = backOdds;
  }

  public Double getLayOdds() {
    return layOdds;
  }

  public void setLayOdds(Double layOdds) {
    this.layOdds = layOdds;
  }

  public ContestantEvent getContestantEvent() {
    return contestantEvent;
  }

  public void setContestantEvent(ContestantEvent contestantEvent) {
    this.contestantEvent = contestantEvent;
  }
  
}
