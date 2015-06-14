package amc.betfair.ruleengine;

import java.util.ArrayList;
import java.util.List;

public class RuleResultList {

  private List<RuleResult> ruleResults;
  
  private boolean rulesPassed;
  
  public RuleResultList() {
    this.setRuleResults(new ArrayList<RuleResult>());
    this.setRulesPassed(false);
  }
  
  public RuleResultList(boolean rulesPassed, List<RuleResult> ruleResultList) {
    this();
    this.setRuleResults(ruleResultList);
    this.setRulesPassed(rulesPassed);
  }
  
  public boolean passed() {
    boolean result = true;
    
    for(RuleResult ruleResult : this.getRuleResults()) {
      if(!ruleResult.isPassed())
        result = false;
      break;
    }
    
    return result;
  }
  
  public void add(RuleResult ruleResult) {
    this.getRuleResults().add(ruleResult);
  }

  public List<RuleResult> getRuleResults() {
    return ruleResults;
  }

  public void setRuleResults(List<RuleResult> ruleResults) {
    this.ruleResults = ruleResults;
  }

  public boolean isRulesPassed() {
    return rulesPassed;
  }

  public void setRulesPassed(boolean rulesPassed) {
    this.rulesPassed = rulesPassed;
  }
  
}
