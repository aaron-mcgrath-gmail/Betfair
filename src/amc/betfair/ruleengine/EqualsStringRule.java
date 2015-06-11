package amc.betfair.ruleengine;

public class EqualsStringRule extends AbstractRule {

  private String leftSide;
  
  private String rightSide;
  
  public EqualsStringRule() {
  }

  public RuleResult test() {
    RuleResult ruleResult = new RuleResult();
    ruleResult.setPassed(leftSide.equals(rightSide));
    return ruleResult;
  }

  public String getLeftSide() {
    return leftSide;
  }

  public void setLeftSide(String leftSide) {
    this.leftSide = leftSide;
  }

  public String getRightSide() {
    return rightSide;
  }

  public void setRightSide(String rightSide) {
    this.rightSide = rightSide;
  }
  
}
