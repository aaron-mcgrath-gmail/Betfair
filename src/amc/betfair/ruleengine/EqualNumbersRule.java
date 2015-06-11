package amc.betfair.ruleengine;

public class EqualNumbersRule extends AbstractRule {

  private double leftSide;
  
  private double rightSide;
  
  public EqualNumbersRule() {
  }
  
  public RuleResult test() {
    RuleResult ruleResult = new RuleResult();
    ruleResult.setPassed(this.getLeftSide() == this.getRightSide());
    return ruleResult;
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
