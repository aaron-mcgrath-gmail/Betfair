package amc.betfair.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contestant_event")
public class ContestantEvent {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @ManyToOne
  @Column(name = "contestant_ref", nullable = false)
  private Long contestantRef;
  
  @ManyToOne
  @Column(name = "event_ref", nullable = false)
  private Long eventRef;
  
  public ContestantEvent() {
    
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getContestantRef() {
    return contestantRef;
  }

  public void setContestantRef(Long contestantRef) {
    this.contestantRef = contestantRef;
  }

  public Long getEventRef() {
    return eventRef;
  }

  public void setEventRef(Long eventRef) {
    this.eventRef = eventRef;
  }

}
