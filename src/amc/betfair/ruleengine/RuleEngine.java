package amc.betfair.ruleengine;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {

  private List<Rule> rules;
  
  public RuleEngine() {
    rules = new ArrayList<Rule>();
  }
  
  public RuleResultList run() {
    RuleResultList results = null;
    
    
    return results;
  }

  public void addRule(Rule rule) {
    rules.add(rule);
  }
  
  public List<Rule> getRules() {
    return rules;
  }

  public void setRules(List<Rule> rules) {
    this.rules = rules;
  }
  
}
