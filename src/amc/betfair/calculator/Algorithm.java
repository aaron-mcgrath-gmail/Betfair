package amc.betfair.calculator;

import java.util.List;

public class Algorithm {
  
  private String algorithm;
  
  private List<String> variableNames;
  
  private List<Double> variableValues;
  
  public Algorithm() {
  }
  
  public Algorithm(String algorithm, List<String> variableNames, List<Double> variableValues) {
    this.setAlgorithm(algorithm);
    this.setVariableNames(variableNames);
    this.setVariableValues(variableValues);
  }
  
  public String compose() {
    String result = this.getAlgorithm();
    for(int counter = 0; counter < this.getVariableNames().size(); counter ++) {
      result.replace(this.getVariableNames().get(counter), Double.toString(this.getVariableValues().get(counter)));
    }
    return result;
  }

  public String getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  public List<String> getVariableNames() {
    return variableNames;
  }

  public void setVariableNames(List<String> variableNames) {
    this.variableNames = variableNames;
  }

  public List<Double> getVariableValues() {
    return variableValues;
  }

  public void setVariableValues(List<Double> variableValues) {
    this.variableValues = variableValues;
  }

}
