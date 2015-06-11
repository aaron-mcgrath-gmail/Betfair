package amc.betfair.ruleengine;

public abstract class AbstractRule implements Rule {
  
  private String name;
  
  public AbstractRule() {
    
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
