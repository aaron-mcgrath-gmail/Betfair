package amc.betfair.ruleengine;

public class RuleResult {
  
  private boolean passed;
  private String ruleName;
  
  public RuleResult() {
  }
  
  public RuleResult(boolean passed, String ruleName) {
    this.setPassed(passed);
    this.setRuleName(ruleName);
  }

  public boolean isPassed() {
    return passed;
  }

  public void setPassed(boolean passed) {
    this.passed = passed;
  }

  public String getRuleName() {
    return ruleName;
  }

  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }
}
