package amc.betfair.ruleengine;

public class GreaterThanNumbersRule extends AbstractRule {

  private double leftSide;
  
  private double rightSide;
  
  public GreaterThanNumbersRule() {
  }
  
  public RuleResult test() {
    RuleResult ruleResult = new RuleResult();
    ruleResult.setPassed(leftSide > rightSide);
    return null;
  }

  public double getLeftSide() {
    return leftSide;
  }

  public void setLeftSide(double leftSide) {
    this.leftSide = leftSide;
  }

  public double getRightSide() {
    return rightSide;
  }

  public void setRightSide(double rightSide) {
    this.rightSide = rightSide;
  }

}
